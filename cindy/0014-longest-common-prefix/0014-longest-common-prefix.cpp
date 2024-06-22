class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans = "";
        int min_len = 200;

        for(string s : strs) {
            if(min_len > s.length()){
                min_len = s.length();
            }
        }

        for(int i = 0; i < min_len; ++i) {
            char temp = strs[0][i];
            for(string s : strs) {
                if(temp != s[i]) {
                    return ans;
                }
            }
            ans += temp;
        }
        return ans;
    }
};