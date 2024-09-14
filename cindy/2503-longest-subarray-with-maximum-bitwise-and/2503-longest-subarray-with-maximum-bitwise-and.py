class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        M = 0
        n = 0

        for num in nums:
            M = max(M, num)

        cnt = 0
        
        for num in nums:
            if num == M:
                cnt += 1
                n = max(n, cnt)
            else:
                cnt = 0

        return n
