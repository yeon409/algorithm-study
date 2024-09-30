from collections import Counter

class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        ans = []

        s1 = Counter(s1.split())
        s2 = Counter(s2.split())


        for s in s1:
            if s1[s] == 1 and s2[s] == 0:
                ans.append(s)

        for s in s2:
            if s2[s] == 1 and s1[s] == 0:
                ans.append(s) 

        return ans
            