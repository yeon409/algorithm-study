class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        ans = ""
        nums = list(map(str, nums))

        nums.sort(key = lambda n : n * 10, reverse = True)

        if nums[0] == '0':
            return "0"
        else:
            ans = "".join(nums)

        return ans