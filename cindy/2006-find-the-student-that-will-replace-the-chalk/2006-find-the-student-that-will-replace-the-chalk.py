class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        # return reduce(lambda a, c: (a[0] - c[1], c[0] if 0 <= a[0] < c[1] else a[1]), enumerate(chalk), (k % sum(chalk), -1))[1]
        total_chalk = sum(chalk)
        
        k %= total_chalk
        
        for i, c in enumerate(chalk):
            if k < c:
                return i
            k -= c