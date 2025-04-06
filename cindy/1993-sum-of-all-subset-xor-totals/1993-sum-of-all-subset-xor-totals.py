class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        ans = 0
        n = len(nums)

        for i in range(n+1):
            subs = combinations(nums, i)
            for sub in subs:
                xor = 0
                for num in sub:
                    xor ^= num
                ans += xor       

        return ans

