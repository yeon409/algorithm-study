"""
특정 알파벳을 substring으로 묶을 때 최대 substring의 길이

1. s를 순회하며 각 char의 마지막 idx를 last에 저장
2. 다시 s를 순회
2-1. end를 last max로 업데이트
2-2. 현재 idx가 end와 같을 때
2-2-1. ans에 현재까지의 길이(end-start+1)를 저장
2-2-2. start를 다음 idx로 업데이트
"""
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        start = end = 0
        last = [0] * 26
        ans = []

        for i, c in enumerate(s):
            last[ord(c) - ord('a')] = i
        
        for i, c in enumerate(s):
            end = max(last[ord(c) - ord('a')], end)
            if i == end:
                ans.append(end-start+1)
                start = end + 1
        
        return ans