class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int M = nums.size() - 1;
        int m = 0;

        while (m <= M) {
            int mid = (m + M) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                m = mid + 1;
            }
            else {
                M = mid - 1;
            }
        }

        return m;
    }
};