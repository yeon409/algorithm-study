class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> vec;
        bool flag = false;
        
        for (int i = 0; i < nums.size(); i++) {
            if (flag) {
                break;
            }
            for (int j = i+1; j < nums.size(); j++) {
                if (nums[i] + nums[j] == target) {
                    flag = true;
                    vec = {i, j};
                    break;
                }
            }
        }
        return vec;
    }
};