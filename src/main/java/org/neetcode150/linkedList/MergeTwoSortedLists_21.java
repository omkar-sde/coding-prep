package org.neetcode150.linkedList;

public class MergeTwoSortedLists_21 {

    /*
        Problem Statement: Merge two sorted lists such that the result is sorted
        Intuition: Use a dummy head to mark the beginning of the linked list, move the curr pointer as you iterate over the lists
        Time Complexity: O(m+n)
        Space Complexity: O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Create first sorted list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Create second sorted list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        MergeTwoSortedLists_21 merger = new MergeTwoSortedLists_21();
        ListNode merged = merger.mergeTwoLists(list1, list2);

        // Print the merged list
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }

}
