class AllOne:

    def __init__(self):
        self.res = ""
        self.state = 0
        self.nodes = {}

    def inc(self, key: str) -> None:
        if key not in self.nodes:
            self.nodes[key] = 1
        else:
            self.nodes[key] += 1

        self.state = 0

        return None
        

    def dec(self, key: str) -> None:
        if self.nodes[key] > 1:
            self.nodes[key] -= 1
        else:
            del self.nodes[key]

        self.state = 0

        return None

    def getMaxKey(self) -> str:
        if self.state != 1 and self.nodes:
            k = list(self.nodes.keys())[0]
            v = list(self.nodes.values())[0]

            for i in self.nodes.keys():
                if self.nodes[i] > v:
                    k = i
                    v = self.nodes[i]
            self.res = k

        self.state = 1

        return self.res
        

    def getMinKey(self) -> str:
        if self.state != 2 and self.nodes:
            k = list(self.nodes.keys())[0]
            v = list(self.nodes.values())[0]

            for i in self.nodes.keys():
                if self.nodes[i] < v:
                    k = i
                    v = self.nodes[i]
            self.res = k

        self.state = 2

        return self.res


# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()