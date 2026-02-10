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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        return mergeKList(lists,0,lists.length-1);
    }

    public ListNode mergeKList(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        int mid = start+(end-start)/2;
        ListNode left = mergeKList(lists,start,mid);
        ListNode right = mergeKList(lists,mid+1,end);

        return merge(left,right);
    }

    public ListNode merge(ListNode left, ListNode right){
        if(left == null && right == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
            }else if(right.val < left.val){
                temp.next = right;
                right = right.next;
            }else{
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }

        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}