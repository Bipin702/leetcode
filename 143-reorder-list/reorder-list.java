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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode mid = findMid(head);
        ListNode curr = mid;
        ListNode prev = null;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode left = head;
        ListNode right = prev;

        while(left != null && right!= null){
            ListNode temp = left.next;
            left.next = right;
            left = temp;

            temp = right.next;
            right.next = left;
            right = temp;
        }

        if(left != null) left.next = null;
    }

    public ListNode findMid(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}