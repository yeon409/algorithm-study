class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        bool flag = false;
        int l = digits.size() - 1;

        if (digits[l] == 9) {
            flag = true;
            digits[l] = 0;
        }
        else {
            digits[l] += 1;
            return digits;
        }
        for (int i = l - 1; i >= 0; --i) {
            if (flag) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    continue;
                }
                else {
                    digits[i] += 1;
                    flag = false;
                    break;
                }
            }
            else {
                flag = false;
                break;
            }
        }

        if (flag) {
            digits.insert(digits.begin(), 1);
        }

        return digits;
    }
};