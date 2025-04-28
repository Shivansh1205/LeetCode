class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null; // to keep track of the node before slow
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        // delete the slow node (middle)
        prev.next = slow.next;
        
        return head;
    }
}
