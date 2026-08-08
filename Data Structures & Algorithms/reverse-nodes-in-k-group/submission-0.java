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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode temp1 = head, temp2 = head;
        Stack<Integer> st = new Stack<>();
        int count = 0;

        while (temp2 != null) {
            st.push(temp2.val);
            temp2 = temp2.next;
            count++;

            if(count == k){
                while(count!=0){
                    temp1.val=st.pop();
                    temp1=temp1.next;
                    count--;
                }
            }
        }
        return head;
    }
}