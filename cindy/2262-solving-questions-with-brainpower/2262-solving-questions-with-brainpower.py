"""class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        l = len(questions[0])
        dp = [0] * l
        dp[1] = questions[1][0]

        for i in range(1, l):
            if (i+questions[i][1]+1 > l or i+1 > l):
                dp[l-1] = max(dp[l-1], dp[i] + questions[i][0])
            else:
                dp[i+questions[i][1]] = max(dp[i] + questions[i][0], dp[i+questions[i][1]+1])
                dp[i+1] = max(dp[i+1], dp[i])

        return max(dp)"""

"""class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        dp = [0] * n

        for i in range(n - 1, -1, -1):
            points, skip = questions[i]
            next_question = i + skip + 1

            if next_question < n:
                dp[i] = max(points + dp[next_question], dp[i + 1] if i + 1 < n else points)
            else:
                dp[i] = points if i == n -1 else max(points, dp[i+1])

        return dp[0]"""

class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        dp = [0]*n
        dp[n-1]=questions[n-1][0]
        for i in range(len(questions)-2, -1, -1):
            incr = i + questions[i][1]+1
            dp[i]=max(dp[i+1], questions[i][0] + (dp[incr] if incr < n else 0))
        return dp[0]
        