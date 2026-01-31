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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode ptr = result;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
            }else if(l2.val < l1.val){
                ptr.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ptr = ptr.next;
        }

        while(l1 != null){
            ptr.next = new ListNode(l1.val);
            l1 = l1.next;
            ptr = ptr.next;
        }

        while(l2 != null){
            ptr.next = new ListNode(l2.val);
            l2 = l2.next;
            ptr = ptr.next;
        }

        return  result.next;
    }
}