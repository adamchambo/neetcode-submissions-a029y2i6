/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null; 
        if (lists.length == 1) return lists[0];
        int middle = lists.length / 2; 
        ListNode[] leftArr = Arrays.copyOfRange(lists, 0, middle); 
        ListNode[] rightArr = Arrays.copyOfRange(lists, middle, lists.length); 
        ListNode left = mergeKLists(leftArr);
        ListNode right = mergeKLists(rightArr);

        return merge(left, right); 
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;      
        ListNode l = left;
        ListNode r = right;

        while(l != null && r != null) {
            if (l.val <= r.val) {
                temp.next = l;
                temp = temp.next; 
                l = l.next; 
            } else {
                temp.next = r;
                temp = temp.next; 
                r = r.next; 
            }
        }

        while (l != null) {
            temp.next = l;
            temp = temp.next;
            l = l.next; 
        }

        while (r != null) {
            temp.next = r;
            temp = temp.next; 
            r = r.next; 
        }

        return dummy.next; 
    }
}
