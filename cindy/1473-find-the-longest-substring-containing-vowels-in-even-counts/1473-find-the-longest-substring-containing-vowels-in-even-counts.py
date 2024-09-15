class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        vowel = {'a':1, 'e':2, 'i':4, 'o':8, 'u':16} # 각 모음을 독립 비트로 자리를 매김하기 위함

        dic, n, ans = {0:-1}, 0, 0

        for i, c in enumerate(s):
            if c in vowel: # 발견처리
                n ^= vowel[c] # 이미 발견했던거면 꺼짐, 처음 발견하는 거면 켜짐
            if n not in dic: # 처음 발견하는 모음
                dic[n] = i
            else: # 이미 발견했던 모음 (두번째 발견) = 최대 길이 업데이트
                ans = max(ans, i - dic[n])
        
        return ans

