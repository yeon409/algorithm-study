class Solution {
public:
    int romanToInt(string s) {
        int ans = 0;
        int len = s.length();
        
        for(int i = 0; i < len; ++i) {
            switch(s[i]) {
                case 'I': {
                    if(i+1 < len) {
                        if(s[i+1] == 'V') {
                            ans += 4;
                            ++i;
                            break;
                        }
                        else if(s[i+1] == 'X') {
                            ans += 9;
                            ++i;
                            break;
                        }
                    }
                    ans += 1;
                    break;
                }
                case 'V': {
                    ans += 5;
                    break;
                }
                case 'X': {
                    if(i+1 < len) {
                        if(s[i+1] == 'L') {
                            ans += 40;
                            ++i;
                            break;
                        }
                        else if(s[i+1] == 'C') {
                            ans += 90;
                            ++i;
                            break;
                        }
                    }
                    ans += 10;
                    break;
                }
                case 'L': {
                    ans += 50;
                    break;
                }
                case 'C': {
                    if(i+1 < len) {
                        if(s[i+1] == 'D') {
                            ans += 400;
                            ++i;
                            break;
                        }
                        else if(s[i+1] == 'M') {
                            ans += 900;
                            ++i;
                            break;
                        }
                    }
                    ans += 100;
                    break;
                }
                case 'D': {
                    ans += 500;
                    break;
                }
                case 'M': {
                    ans += 1000;
                    break;
                }   
            }
            cout << ans << " ";
        }
        
        return ans;
    }
};