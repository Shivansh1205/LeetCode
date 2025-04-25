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
        int n = size(head);
        if(n%2==0){
            n=(n/2);
        }else{
            n=n/2+1;
        }
        ListNode cur = head;
        for(int i = 0;i<n;i++){
            cur = cur.next;
        }
        return cur;
    }
    public int size(ListNode head){
        int cnt=0;
        ListNode temp = head;
        while(temp.next!=null){
            temp=temp.next;
            cnt++;
        }
        return cnt;
    }
}