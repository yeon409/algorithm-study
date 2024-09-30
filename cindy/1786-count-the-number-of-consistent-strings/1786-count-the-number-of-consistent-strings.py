class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        cnt = 0

        for word in words:
            for c in word:
                if c not in allowed:
                    cnt += 1
                    break

        return len(words) - cnt
