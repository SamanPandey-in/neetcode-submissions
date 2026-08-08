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
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;

        
        // reached mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //break in half
        ListNode sec = slow.next;
        slow.next = null;
        ListNode rev = null;
        
        while (sec != null) {
            ListNode temp = sec.next;
            sec.next = rev;
            rev = sec;
            sec = temp;
        }

        //mergingn botht the halfs
        ListNode first = head;
        sec = rev;
        while (sec != null) {
            ListNode temp1 = first.next, temp2 = sec.next;
            first.next = sec;
            sec.next = temp1;
            first = temp1;
            sec = temp2;
        }
        return;
    }
}
