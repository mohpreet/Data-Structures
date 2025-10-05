package day2;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;


public class LinkedListTest {
    public static void main(String[] args) {
        // problem statement , detect cycle in linked list
        Node node = createList("noncyclic", 9);
        Node tempHeaderNode = node;
        //problem1 cyclic
        //boolean isLinkedListCyclic = checkLinkedListIsCyclic(tempHeaderNode);
        //System.out.println(">>>" + isLinkedListCyclic);

        //problem2 middle of linked list
        //tempHeaderNode = node;
        //Optional<Node> middle = findMiddleValueInLinkedList(tempHeaderNode);
        //System.out.println(">>>"+middle.get().getValue());

        //problem3 reverse a list
        //tempHeaderNode = node;
        //printLinkedList(tempHeaderNode);
        //Optional<Node> optionalHeaderReversed=reverseLinkedList(tempHeaderNode);
        //System.out.println("\n");
        //printLinkedList(optionalHeaderReversed.get());

        //Problem4 reverse list in pairs
        //tempHeaderNode = node;
        //printLinkedList(tempHeaderNode);
        //System.out.println("\n");
        //Node reversedInPair = reverseListInPairs(tempHeaderNode.getNext());
        //printLinkedList(reversedInPair);

        //problem statement5, replace the kth element from begining with the kth element from end in linked list
        tempHeaderNode = node;
        printLinkedList(tempHeaderNode);
        Node replacedNode = swapKthNodeInLinkedList(tempHeaderNode.getNext(),6);
        System.out.println("\n");
        printLinkedList(replacedNode);

    }

    private static Node swapKthNodeInLinkedList(Node  current, int pos) {
        //if pos greater than length of linked list then return head
        // if current node is null return current node
        if (current == null) return current;

        // Count length
        int lengthOfLinkedList = 0;
        Node temp = current;
        while (temp != null) {
            lengthOfLinkedList++;
            temp = temp.getNext();
        }

        // if pos is more than length, no swap
        if (pos > lengthOfLinkedList) return current;

        if (2 * pos - 1 == lengthOfLinkedList) {
            return current;
        }

        Node kthFromStart = findKthElement(current,pos);
        Node kthElementFromEnd = findKthElement(current,(lengthOfLinkedList-pos+1));
        // Step 4: swap values
        int tempVal = kthFromStart.getValue();
        kthFromStart.setValue(kthElementFromEnd.getValue());
        kthElementFromEnd.setValue(tempVal);
        return current;
    }

    private static Node findKthElement(Node node, int pos){
        // Step 2: find kth from start
        Node kthFromStart = node;
        for (int i = 1; i < pos; i++) {
            kthFromStart = kthFromStart.getNext();
        }
        return kthFromStart;
    }

    private static Node reverseListInPairs(Node currentNode) {
        //Current node is: 1

        if (Objects.isNull(currentNode)) {
            return currentNode;
        }

        //2
        Node nextNode = currentNode.getNext();
        if (Objects.isNull(nextNode)) {
            return currentNode;
        }
        //3->4->5->6->7
        Node referenceToTail = nextNode.getNext();
        System.out.println("current: " + currentNode.getValue()
                + ", next: " + nextNode.getValue() + ", tail:"+ (Objects.isNull(referenceToTail)?null:referenceToTail.getValue()));
        //update pair reference
        //2<-1
        nextNode.setNext(currentNode);

        Node reversedPair = reverseListInPairs(referenceToTail);
        currentNode.setNext(reversedPair);

        //1->2->3->4->5->6->7
        //2->1->4->3->6->5->7


        //itr1
        //1<-2
        //temp 3->4->5->6->7
        // ret 2->1->4->3-> 6->5->7

        //itr2
        //3<-4
        //temp 5->6->7
        //ret 4->3-> 6->5->7

        //itr3
        //5<-6
        //temp 7 (ccurrent needs to be set to revered pair, gives, 6->5->7)
        //ret 6->5->7 (6 was next node which was supposed tobe returned from here to feed result to old recurrsiuve call)

        return nextNode;
    }


    private static Optional<Node> reverseLinkedList(Node headNode) {

        Node headerPointer = headNode;
        if (Objects.isNull(headerPointer)) {
            return Optional.empty();
        }
        Node current = headerPointer;
        Node next = null;
        Node prev = null;

        while (Objects.nonNull(current)) {
            next = current.getNext();
            current.setNext(prev);
            //Setting value for the next iteration
            //https://www.naukri.com/code360/library/reversing-a-linked-list
            prev = current;
            current = next;
        }
        return Optional.of(prev); //prev has the value of the current node for the last iteration
        // next in last iteration will point to empty or null
    }

    private static Optional<Node> findMiddleValueInLinkedList(Node headNode) {
        if (Objects.isNull(headNode)) {
            return Optional.empty();
        }

        Node slow = headNode;
        Node fast = headNode;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.getNext())) {
            slow = slow.getNext();          // move 1 step
            fast = fast.getNext().getNext(); // move 2 steps
        }

        return Optional.of(slow); // slow is the middle
    }


    private static void printLinkedList(Node node) {
        Node tempHeaderNode = node;
        while (Objects.nonNull(tempHeaderNode.getNext())) {
            System.out.print("\t" + tempHeaderNode.getValue());
            tempHeaderNode = tempHeaderNode.getNext();
        }
        System.out.print("\t" + tempHeaderNode.getValue());
    }

    private static Node createList(String type, int size) {
        if (size <= 0) {
            return null;
        }

        Node head = new Node();
        head.setValue(0);
        Node current = head;

        for (int i = 1; i < size; i++) {
            Node next = new Node();
            next.setValue(i);
            current.setNext(next);
            current = next;
        }

        if ("cyclic".equalsIgnoreCase(type)) {
            current.setNext(head); // last node points to first node
        }

        return head;
    }


    private static boolean checkLinkedListIsCyclic(Node node) {
        //slowPtr = slowPtr.getNext() {handle null check}
        //fastPtr = fastPtr.getNext().getNext(); {handle null check at 2 levels}
        //slowPtr.equals(fastPtr) means cyclic

        Node headerPointer = node;
        if (Objects.isNull(node)) {
            return false;
        }
        Node slowPtr = headerPointer;
        Node fastPtr = headerPointer;
        do {
            slowPtr = slowPtr.getNext();
            if (Objects.isNull(slowPtr)) {
                return false;
            }
            fastPtr = fastPtr.getNext();
            if (Objects.isNull(fastPtr)) {
                return false;
            }
            fastPtr = fastPtr.getNext();
            if (Objects.isNull(fastPtr)) {
                return false;
            }
        } while (!slowPtr.equals(fastPtr));

        return true;
    }

    // middle of the linked list
    // reverse
    // pair reverse (pending)

}
