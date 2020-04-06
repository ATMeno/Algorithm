package algorithm.linkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        testSingleReverse();
        testDoubleReverse();
        testHasCycle();
    }

    private static void testHasCycle() {
        Node<Integer> node5 = new Node<>(5, null);
        Node<Integer> node4 = new Node<>(4, node5);
        Node<Integer> node3 = new Node<>(3, node4);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node1 = new Node<>(1, node2);
        node5.setNext(node3);
        System.out.println("是否有环");
        Node node = LinkedListUtils.hasCycle(node1);
        System.out.println(node);
    }

    private static void testDoubleReverse() {
        DoubleNode node4 = new DoubleNode(null,4,null);

        DoubleNode node3 = new DoubleNode(null,3,node4);
        node4.setPre(node3);

        DoubleNode node2 = new DoubleNode(null,2,node3);
        node3.setPre(node2);

        DoubleNode node1 = new DoubleNode(null,1,node2);
        node2.setPre(node1);
        System.out.println("双向链表反转");
        LinkedListUtils.traverse(node1);
        LinkedListUtils.reverse(node1);
        LinkedListUtils.traverse(node4);
    }

    private static void testSingleReverse() {
        Node<Integer> node5 = new Node<>(5, null);
        Node<Integer> node4 = new Node<>(4, node5);
        Node<Integer> node3 = new Node<>(3, node4);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node1 = new Node<>(1, node2);
        System.out.println("单链表反转");
        LinkedListUtils.traverse(node1);
        LinkedListUtils.reverse(node1);
        LinkedListUtils.traverse(node5);
    }
}
