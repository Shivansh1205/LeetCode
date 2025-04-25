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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverse(slow);
        while(head2!=null){
            if(head.val!=head2.val) return false;
            head = head.next;
            head2=head2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode front  = temp.next;
            temp.next = prev;
            prev = temp; 
            temp = front;            
        }
        return prev;
    } 
}