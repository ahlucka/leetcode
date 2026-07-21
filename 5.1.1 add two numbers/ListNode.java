class Solution {
    public static void main(String[] args) {
        
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode result = new ListNode();
    ListNode curr = result;

    while (l1 != null || l2 != null || carry != 0) {
        int val1 = (l1 != null) ? l1.val : 0;
        int val2 = (l2 != null) ? l2.val : 0;     
        
        int currentSum = val1 + val2 + carry;

        carry = currentSum / 10;
        int digit = currentSum % 10;

        curr.next = new ListNode(digit);
        curr = curr.next;

        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
        } 
    

    return result.next;

    }
}