# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        dic = {i:1 for i in nums}
        ans = ListNode()
        cur = ans

        while head != None:
            if head.val not in dic.keys():
                cur.next = ListNode(head.val)
                cur = cur.next
            head = head.next

        return ans.next