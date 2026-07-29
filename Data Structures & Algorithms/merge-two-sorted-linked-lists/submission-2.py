# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        point1 = list1
        point2 = list2

        head = ListNode(0)
        current = head

        while point1 and point2:
            if point1.val <= point2.val:
                current.next = point1
                current = point1
                point1 = point1.next
            else:
                current.next = point2
                current = point2
                point2 = point2.next
        
        if not point1:
            current.next = point2
        if not point2:
            current.next = point1

        head = head.next
        return head
