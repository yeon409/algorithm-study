class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        vowel = {'a':1, 'e':2, 'i':4, 'o':8, 'u':16}

        dic, n, ans = {0:-1}, 0, 0

        for i, c in enumerate(s):
            if c in vowel:
                n ^= vowel[c]
            if n not in dic:
                dic[n] = i
            else:
                ans = max(ans, i - dic[n])
        
        return ans

