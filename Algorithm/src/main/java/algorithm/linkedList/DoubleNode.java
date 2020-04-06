package algorithm.linkedList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleNode<T extends Comparable<T>> extends Node<T> {
    private DoubleNode pre;

    public DoubleNode( DoubleNode pre, T value, Node next) {
        super(value, next);
        this.pre = pre;
    }
}
