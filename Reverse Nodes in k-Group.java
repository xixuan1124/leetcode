/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return head;
        if(k == 1)
            return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        int listn = 0;
        while(head!=null){
            listn++;
            if(listn %k == 0){
                pre = reverseList(pre,head.next);
                head = pre.next;
            }
            else{
                head = head.next;
            }
        }
        return h.next;
    }
    
    public ListNode reverseList(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur!=next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}
