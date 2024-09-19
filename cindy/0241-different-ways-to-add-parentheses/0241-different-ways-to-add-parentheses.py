class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        ans = []

        # if expression.length == 1
        if expression.isdigit():
            return [int(expression)]

        for i, exp in enumerate(expression):
            if exp in ['+', '-', '*']:
                left = self.diffWaysToCompute(expression[:i])
                right = self.diffWaysToCompute(expression[i+1:])
                
                for i in left:
                    for j in right:
                        if exp == "+":
                            ans.append(int(i)+int(j))
                        elif exp == "-":
                            ans.append(int(i)-int(j))
                        elif exp == "*":
                            ans.append(int(i)*int(j))


        return ans