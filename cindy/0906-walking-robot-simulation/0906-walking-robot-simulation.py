class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        cx, cy = 0, 0
        dx, dy = 0, 1
        obst = set(map(tuple, obstacles))
        ans = 0

        for c in commands:
            if c > 0:
                for _ in range(c):
                    tx, ty = cx + dx, cy + dy
                    if (tx, ty) not in obst:
                        cx, cy = tx, ty
                        ans = max(ans, pow(cx, 2) + pow(cy, 2))
                    else:
                        break
            elif c == -1:
                dx, dy = dy, -dx
            elif c == -2:
                dx, dy = -dy, dx
        
        return ans