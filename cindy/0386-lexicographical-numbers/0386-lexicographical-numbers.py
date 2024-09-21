class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []
        curr = 1

        for _ in range(n):
            ans.append(curr)

            if curr * 10 <= n:
                curr *= 10
            else:
                if curr >= n:
                    curr //= 10

                curr += 1

                while curr % 10 == 0:
                    curr //= 10


        return ans
