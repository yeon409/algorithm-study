class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        M = 0
        ans = 0
        cnt = 0

        for num in nums:
            if num > M:
                M = num
                ans = cnt = 1
            elif num == M:
                cnt += 1
            else:
                ans = max(ans, cnt)
                cnt = 0

        return max(ans, cnt)
