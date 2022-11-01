package LeetCode.middleOfNode;

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

public class Solution {
    //Return middle node of linked list, is list is even return the 2nd node
    public ListNode middleNode(ListNode head) {
        //Get length
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }

        double middle = Math.ceil((double) len / 2);

        current = head;
        int count = 1;

        while (current != null) {
            if (len % 2 != 0) {
                if (count == middle) {
                    head = current;
                    break;
                }
            } else {
                if (count > middle) {
                    head = current;
                    break;
                }
            }

            count++;
            current = current.next;

        }
        return head;
    }
}


