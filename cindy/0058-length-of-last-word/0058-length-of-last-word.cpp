class Solution {
public:
    int lengthOfLastWord(string s) {
        int l = s.length() - 1;
        int count = 0;

        for (int i = l; i >= 0; i--) {
            if (s.at(i) < 'A') {
                if (count > 0) {
                    return count;
                }
                else {
                    continue;
                }
            }
            else {
                count += 1;
            }
        }

        return count;
    }
};