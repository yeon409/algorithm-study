class CustomStack:

    def __init__(self, maxSize: int):
        self.stack = [0] * maxSize
        self.top = -1
        self.maxSize = maxSize

    def push(self, x: int) -> None:
        if self.top+1 < self.maxSize:
            self.top += 1
            self.stack[self.top] = x
        # print("p - ", self.stack)

        return None

    def pop(self) -> int:
        if self.top > -1:
            self.top -= 1
            return self.stack[self.top+1]

        return -1
        

    def increment(self, k: int, val: int) -> None:
        cnt = 0

        for i in range(self.maxSize):
            if cnt == k:
                return None
            self.stack[i] += val
            cnt += 1

        return None


# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)