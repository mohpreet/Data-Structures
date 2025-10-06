package day5;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headTemp1 =list1;
        ListNode headTemp2 =list2;
        ListNode newLinkedListHead = new ListNode(-1);
        ListNode currentNode=newLinkedListHead;
        while (headTemp1.next!=null && headTemp2.next!=null){
            if(headTemp1.val<headTemp2.val){
                currentNode.next=headTemp1;
                headTemp1=headTemp1.next;
            }else{
                currentNode.next=headTemp2;
                headTemp2=headTemp2.next;
            }
            currentNode=currentNode.next;
        }
        if(headTemp1!=null){
            currentNode.next=headTemp1;
        }
        if(headTemp2!=null){
            currentNode.next=headTemp2;
        }

        return newLinkedListHead;
    }
}

public class Tester {
    public static void main(String[] args) {
        // Create first sorted linked list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Create second sorted linked list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // Merge them
        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(l1, l2);

        // Print merged list
        System.out.print("Merged List: ");
        printList(merged);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
//https://www.geeksforgeeks.org/dsa/merge-two-sorted-linked-lists/