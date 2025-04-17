package org.neetcode150.linkedList;

public class ReverseLinkedList_206 {

    /*
        Problem Statement: Reverse a singly linked list
        Intuition: need, prev, curr and next pointers
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        ReverseLinkedList_206 sol = new ReverseLinkedList_206();

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse it
        ListNode reversed = sol.reverseList(head);

        // Print reversed list
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
