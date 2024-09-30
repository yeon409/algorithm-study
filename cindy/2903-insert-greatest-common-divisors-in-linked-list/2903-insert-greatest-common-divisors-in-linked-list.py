# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head.next == None:
            return head
        
        prev = head
        curr = head.next
        
        while curr:
            gcd = math.gcd(prev.val, curr.val)

            new = ListNode(gcd)
            prev.next = new
            new.next = curr
            
            prev = curr
            curr = curr.next
        
        return head
