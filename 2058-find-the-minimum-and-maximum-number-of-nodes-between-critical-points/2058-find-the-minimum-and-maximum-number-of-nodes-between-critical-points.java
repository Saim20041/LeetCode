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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCP = -1;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int prevCP = -1;
        int index = 1;
        int max = -1;
        int min = Integer.MAX_VALUE;
        
        while(next != null){
            if((prev.val > curr.val && next.val > curr.val) || (prev.val < curr.val && next.val < curr.val)){
                if(firstCP == -1){
                    firstCP = index;
                    
                }
                else{
                    max = index - firstCP;
                    min = Math.min(min, index - prevCP);
                }
                prevCP = index;
            }
            prev = prev.next;
            curr = curr.next;
            next = next.next;
            index++;

        }
        if(min == Integer.MAX_VALUE || firstCP == -1){
            return new int[]{-1, -1};
        }
        return new int[]{min, max};
    }
}