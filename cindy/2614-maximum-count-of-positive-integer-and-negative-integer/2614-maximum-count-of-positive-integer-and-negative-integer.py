class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        p = n = 0
        for num in nums:
            if (num > 0):
                p += 1
            elif (num < 0):
                n += 1
        
        if (p > n):
            return p
        return n