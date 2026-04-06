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
    public ListNode middleNode(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while(ptr1!=null && ptr1.next!=null){
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }
}