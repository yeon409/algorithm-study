class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        vector<int> temp;
        int ans = 0;
        for (int n : nums) {
            temp.push_back(n);
        }

        nums.clear();

        for (int n : temp) {
            if (n != val) {
                nums.push_back(n);
                ans += 1;
            }
        }

        return ans;
    }
};