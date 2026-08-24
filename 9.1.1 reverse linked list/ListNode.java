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

    public ListNode reverseList(ListNode head) {
        return reversing(head);
    }

    private ListNode reversing(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reversing(head.next);
        
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}