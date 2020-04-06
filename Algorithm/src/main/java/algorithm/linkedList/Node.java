package algorithm.linkedList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T extends Comparable<T>>
{
    private T value;
    private Node next;

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
