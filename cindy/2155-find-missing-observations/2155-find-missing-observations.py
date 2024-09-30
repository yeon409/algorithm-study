class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        sum = 0

        for r in rolls:
            sum += r
        
        rest = mean * (len(rolls) + n) - sum
        if rest > n * 6 or rest < n * 1:
            return []
        
        d = rest // n
        m = rest % n
        ans = [d] * n
        for i in range(m):
            ans[i] += 1

        # ans = [1] * n
        # idx = 0
        # for i in range(rest - n):
        #     ans[idx] += 1
        #     idx = (idx + 1) % n

        return ans
        