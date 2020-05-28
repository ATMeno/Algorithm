package algorithm.tree;

import java.util.Objects;

/**
 * 在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 */
abstract class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree(Node rootNode) {
        super(rootNode);
    }


    /**
     * 先取根节点，如果它等于我们要查找的数据，那就返回。
     * 如果要查找的数据比根节点的值小，那就在左子树中递归查找；
     * 如果要查找的数据比根节点的值大，那就在右子树中递归查找
     * @param value the Node's value
     * @return if exist the node,return the node,else return null;
     */
    @Override
    public Node search(T value) {
        if(Objects.isNull(value))
            throw new NullPointerException("the value searched must not be null");

        return search(value,this.getRootNode());
    }

    private Node search(T value,Node node){
        if(Objects.isNull(node)) return null;
        int compareResult = value.compareTo(node.getNodeValue());
        if(compareResult == 0)
            return node;
        else if (compareResult < 0){
            return search(value,node.getLeft());
        }else {
            return search(value,node.getRight());
        }
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean add() {
        return false;
    }
}
