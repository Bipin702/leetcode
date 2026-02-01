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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        int pos = 1;

        while(pos < left){
            prev = curr;
            curr = curr.next;
            pos++;
        }

        ListNode prevLeft = prev;
        ListNode subListHead = curr;

        int k = right-left+1;
        ListNode next = null;
        while(k > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        if(prevLeft != null){
            prevLeft.next = prev;
        }else{
            head = prev;
        }

        subListHead.next = curr;

        return head;
    }
}