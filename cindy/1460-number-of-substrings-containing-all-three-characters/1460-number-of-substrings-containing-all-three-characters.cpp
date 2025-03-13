/*
a, b, c로 이루어진 문자열에 대해 a, b, c가 모두 한 번씩은 포함되는 substring 카운트

1. 한 char씩 확인하면서 해당 char에 대해 a, b, c 카운트
2. a, b, c가 모두 1개 이상이면
2-1. 문자열 length - 현재 idx 만큼 ans에 추가(가능한 substring의 개수)
2-2. substring의 맨앞 기준인 left++로 한 칸 이동
*/

class Solution {
public:
    int numberOfSubstrings(string s) {
        int left = 0;
        int char_cnt[3] = {0, };
        int l = s.length();
        int ans = 0;

        for (int i = 0; i < l; i++) {
            char c = s[i];

            if (c == 'a') char_cnt[0]++;
            else if (c == 'b') char_cnt[1]++;
            else char_cnt[2]++;

            while (char_cnt[0] > 0 && char_cnt[1] > 0 && char_cnt[2] > 0) {
                ans += (l - i);
                
                if (s[left] == 'a') char_cnt[0]--;
                else if (s[left] == 'b') char_cnt[1]--;
                else char_cnt[2]--;

                left++;
            }
        }

        return ans;
    }
};