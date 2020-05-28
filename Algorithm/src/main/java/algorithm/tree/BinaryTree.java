package algorithm.tree;

import java.util.Objects;

/**
 * 二叉树
 */
public abstract class BinaryTree<T extends Comparable<T>> {
    protected class Node{
        private T nodeValue;
        private Node left;
        private Node right;

        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }

        public void setNodeValue(T nodeValue) {
            this.nodeValue = nodeValue;
        }
        public T getNodeValue() {
            return nodeValue;
        }

        /**
         * 是否有左叶子节点
         * @param node
         * @return
         */
        public boolean hasLeft(Node node){
            return Objects.nonNull(node.left);
        }

        /**
         * 是否有右叶子节点
         * @param node
         * @return
         */
        public boolean hasRight(Node node){
            return Objects.nonNull(node.right);
        }
    }

    private Node rootNode;

    public BinaryTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }
    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }



    /**
     * 前序遍历
     */
    public void preTraverse(){
        this.preTraverse(this.rootNode);
    }

    private void preTraverse(Node node) {
        System.out.println(node.getNodeValue());
        if (Objects.nonNull(node.left))
            preTraverse(node.getLeft());
        if (Objects.nonNull(node.right))
            preTraverse(node.right);
    }

    /**
     * 中序遍历
     */
    public void midTraverse(){
        this.midTraverse(this.rootNode);
    }
    private void midTraverse(Node node) {
        if (Objects.nonNull(node.left))
            midTraverse(node.left);
        System.out.println(node.getNodeValue());
        if (Objects.nonNull(node.right))
            midTraverse(node.right);
    }

    /**
     * 后序遍历
     */
    public void postTraverse(){
        this.postTraverse(this.rootNode);
    }

    private void postTraverse(Node node) {
        if (Objects.nonNull(node.left))
            postTraverse(node.left);
        if (Objects.nonNull(node.right))
            postTraverse(node.right);
        System.out.println(node.getNodeValue());
    }

    /**
     * 层序遍历
     */

    public abstract Node search(T value);
    public abstract boolean add();
    public abstract boolean delete();
    public abstract boolean alert();
}
