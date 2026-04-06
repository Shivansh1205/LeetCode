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
    public ListNode sortList(ListNode head) {
        ListNode ptr = head;
        List<Integer> arr = new ArrayList<>();
        while(ptr!=null){
            arr.add(ptr.val);
            ptr = ptr.next;
        }
        Collections.sort(arr);
        ptr = head;
        int i=0;
        while(ptr!=null){
            ptr.val = arr.get(i);
            i++;
            ptr = ptr.next;
        }
        return head;
    }
}