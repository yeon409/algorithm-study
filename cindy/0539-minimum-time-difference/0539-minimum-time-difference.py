class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        def toMin(time):
            return 60 * int(time[:2]) + int(time[3:])
        
        minutes = [toMin(t) for t in timePoints]

        minutes.sort()

        ans = float('inf')

        for i in range(1, len(minutes)):
            ans = min(ans, minutes[i] - minutes[i-1])

        ans = min(ans, 1440 - (minutes[-1] - minutes[0]))

        return ans