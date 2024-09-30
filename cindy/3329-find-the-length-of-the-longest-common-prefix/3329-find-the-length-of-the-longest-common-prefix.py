class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        m = {}

        for n in arr1:
            s = str(n)
            pre = ""

            for c in s:
                pre += c
                m[pre] = m.get(pre, 0) + 1

        ans = 0

        for n in arr2:
            s = str(n)
            pre = ""
            
            for c in s:
                pre += c
                if pre in m:
                    ans = max(ans, len(pre))

        return ans