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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            head = null;
            return head;
        }
        int len = 1;
        ListNode count = head;
        while(count.next!= null){
            count = count.next;
            len++;
        }
        int index = len - n;
        if(index == 0){
            head = head.next;
            return head;
        }
        ListNode p1 = head;
        while(index > 1){
            p1 = p1.next;
            index--;
        }
        ListNode p2 = p1.next;
        p1.next = p2.next;
        p2.next = null;

        // System.out.println(len);
        return head;
    }
}