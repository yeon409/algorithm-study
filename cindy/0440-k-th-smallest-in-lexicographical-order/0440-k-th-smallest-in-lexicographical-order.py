class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        curr = 1
        k -= 1

        while k > 0:
            cnt = self.countStep(n, curr, curr+1)

            if cnt <= k:
                curr += 1
                k -= cnt
            else:
                curr *= 10
                k -= 1

        return curr

    def countStep(self, n, start, end):
        step = 0

        while start <= n:
            step += min(n+1, end) - start
            start *= 10
            end *= 10

        return step