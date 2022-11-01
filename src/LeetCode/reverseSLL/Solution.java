package LeetCode.reverseSLL;
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tmp = head;
        ListNode previous = null;
        ListNode next;

        while(tmp != null) {
            next = tmp.next;
            tmp.next = previous;
            previous = tmp;
            tmp = next;
        }
        head = previous;
        return head;
    }
}