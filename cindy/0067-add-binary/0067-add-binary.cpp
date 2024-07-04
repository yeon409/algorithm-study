class Solution {
public:
    string addBinary(string a, string b) {
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int carry = 0;
        string ans = "";
        
        while (la >= 0 || lb >= 0) {
            int sum = carry;
            
            if (la >= 0) {
                sum += a.at(la) - '0';
                la--;
            }
            if (lb >= 0) {
                sum += b.at(lb) - '0';
                lb--;
            }
            
            carry = sum / 2;
            sum %= 2;
            ans.insert(ans.begin(), sum + '0');
        }
        
        if (carry > 0) {
            ans.insert(ans.begin(), carry + '0');
        }
        
        return ans;
    }
};