# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        cnt = [0] * k
        start = head
        i = 0

        while start:
            cnt[i%k] += 1
            i += 1
            start = start.next

        if not head:
            return [None for _ in range(k)]

        ans = []
        prev = head

        while head:
            for i in cnt:
                temp = ListNode()
                temp.next = head
                for j in range(i):
                    prev = head
                    head = head.next
                prev.next = None
                ans.append(temp.next)


        return ans