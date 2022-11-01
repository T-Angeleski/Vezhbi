package LeetCode;


import java.util.List;
import java.util.Stack;

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

public class SingleLinkedListProblems {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<Integer>();
        boolean flag = true;

        while(current != null) {
            stack.push(current.val);
            current = current.next;
        }

        while(head != null) {
            int stackCurrent = stack.pop();
            if(head.val == stackCurrent) flag = true;
            else {
                flag = false;
                break;
            }
            head = head.next;
        }
        return flag;
    }
}
