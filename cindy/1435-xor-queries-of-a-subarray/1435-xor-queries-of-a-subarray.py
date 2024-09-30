class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        ans = []

        prefix = [0, arr[0]]

        for i in range(1, len(arr)):
            prefix.append(prefix[i] ^ arr[i])

        for left, right in queries:
            ans.append(prefix[left] ^ prefix[right + 1])

        return ans