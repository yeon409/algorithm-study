# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def check(head, root):
            if not head: # 다 확인
                return True
            if not root: # 남은 트리가 없음
                return False
            if head.val != root.val: # 데이터가 다름
                return False
            return check(head.next, root.left) or check(head.next, root.right)
        
        if not root:
            return False
        
        if check(head, root):
            return True
        
        return self.isSubPath(head, root.left) or self.isSubPath(head, root.right)
        