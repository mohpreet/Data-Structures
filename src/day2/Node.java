package day2;

public class Node {
    private Node next;
    private Integer value;

    public Node(Node next, Integer value) {
        this.next = next;
        this.value = value;
    }

    public Node() {
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
