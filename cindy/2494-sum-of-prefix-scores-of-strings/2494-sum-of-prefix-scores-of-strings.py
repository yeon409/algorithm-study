class TrieNode:
    def __init__(self):
        self.child = {}
        self.pre_cnt = 0

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        root = TrieNode()

        for word in words:
            curr = root
            
            for c in word:
                if c not in curr.child:
                    curr.child[c] = TrieNode()
                curr = curr.child[c]
                curr.pre_cnt += 1
        
        ans = []

        for word in words:
            curr = root
            scr = 0

            for c in word:
                curr = curr.child[c]
                scr += curr.pre_cnt
            ans.append(scr)

        return ans