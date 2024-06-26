class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        set<int> ans;

        for (int n:nums) {
            ans.insert(n);
        }

        nums.clear();
        for (int n:ans) {
            nums.push_back(n);
        }

        return ans.size();
    }
};