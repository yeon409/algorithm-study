#define ll long long

class Solution {
public:
    bool isPalindrome(int x) {
        string string_x = to_string(x);
        int l = string_x.length();
        int front = 10;
        ll back = pow(10, l-1);
        int temp = l-1;
        
        if (x < 0) {
            return false;
        }
        for (int i = 0; i < l / 2; i++) {
            cout << string_x.at(i);
            cout << string_x.at(temp-i);
            if (string_x.at(i) != string_x.at(temp-i)) {
                return false;
            }
        }
        return true;
    }
};