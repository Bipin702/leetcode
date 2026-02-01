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
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        right = sortList(right);

        return merge(left,right);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(0);
        ListNode ptr = temp;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }else if(l2.val < l1.val){
                ptr.next = l2;
                l2 = l2.next;
            }else{
                ptr.next = l1;
                l1 = l1.next;
            }
            ptr = ptr.next;
        }
        
        while(l1 != null){
            ptr.next = l1;
            l1 = l1.next;
            ptr = ptr.next;
        }

        while(l2 != null){
            ptr.next = l2;
            l2 = l2.next;
            ptr = ptr.next;
        }

        return temp.next;
    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}