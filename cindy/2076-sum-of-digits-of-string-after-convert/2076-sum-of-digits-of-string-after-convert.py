class Solution:
    def getLucky(self, s: str, k: int) -> int:
        converted = ""
        ans = 0
        
        for c in s:
            converted += str(ord(c) - ord('a') + 1)
        
        while(k):
            temp = 0
            for c in converted:
                temp += int(c)
            converted = str(temp)
            k -= 1

        return int(converted)

         