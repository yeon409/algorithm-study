class MyCircularDeque:

    def __init__(self, k: int):
        self.capacity = k
        self.deque = [0] * k
        self.front = 0
        self.rear = -1
        self.size = 0


    def insertFront(self, value: int) -> bool:
        if self.size == self.capacity:
            return False
        
        self.front = (self.front - 1 + self.capacity) % self.capacity
        self.deque[self.front] = value
        self.size += 1

        return True

    def insertLast(self, value: int) -> bool:
        if self.size == self.capacity:
            return False

        self.rear = (self.rear + 1) % self.capacity
        self.deque[self.rear] = value
        self.size += 1

        return True

    def deleteFront(self) -> bool:
        if self.size == 0:
            return False

        self.front = (self.front + 1) % self.capacity
        self.size -= 1

        return True

    def deleteLast(self) -> bool:
        if self.size == 0:
            return False

        self.rear = (self.rear - 1 + self.capacity) % self.capacity
        self.size -= 1

        return True

    def getFront(self) -> int:
        if self.size == 0:
            return -1

        return self.deque[self.front]

    def getRear(self) -> int:
        if self.size == 0:
            return -1
            
        return self.deque[self.rear]

    def isEmpty(self) -> bool:
        if self.size > 0:
            return False

        return True

    def isFull(self) -> bool:
        if self.size != self.capacity:
            return False
        
        return True
        


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()