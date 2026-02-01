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
        if(head == null || head.next == null) return true;

        ListNode rev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode node = new ListNode(curr.val);
            node.next = rev;
            rev = node;
            curr = curr.next;
        }

        ListNode p1 = head;
        ListNode p2 = rev;

        while(p1 != null){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}