package algorithm.linkedList;

import javax.jws.Oneway;
import java.util.HashSet;
import java.util.Objects;

/**
 * 链表工具类
 */
public class LinkedListUtils {
    /**
     * 遍历单链表
     */
    public static void traverse(Node root){
        Node node = root;
        StringBuilder builder = new StringBuilder("[");
        while (Objects.nonNull(node)){
            builder.append(node.getValue() + " ");
            node = node.getNext();
        }
        builder.deleteCharAt(builder.length()-1).append("]");
        System.out.println(builder);
    }

    /**
     * 单链表反转 Leetcode 206
     * 输入: 1->2->3->4->5
     * 输出: 5->4->3->2->1
     *
     * 思路：A --> B  变成 A <--- B
     */
    public static void reverse(Node head){
        //注意:第一个参数要传null，把头节点的指针变为Null
        reverse0(null,head);
    }

    private static void reverse0(Node first, Node second) {
        if(Objects.isNull(second))
            return;

        Node next = second.getNext();
        second.setNext(first);
        reverse0(second,next);
    }

    /**
     * 链表中环的检测 Leetcode 141 142
     * 如果有环，输出环的那个节点；反之则输出null
     *
     * 思路:
     *      方法一：
     *      1.是否为环-----快慢指针，如果相遇，则为环
     *      2.找出环
     * 1.判断是否有环用快慢指针，只要相遇即为环，不用说，好理解。
     * 2.求环入口，就是一个数学问题转换为代码的问题。
     * 假设A为环入口，B为相遇点，设0到A距离为x,A到B距离为y,环的长度为c，快慢指针相遇是慢指针绕环n圈，快指针绕环m圈，
     * 由条件得快慢指针相遇时快指针走的长度是慢指针的2倍，则：2(x+nc+y)=x+mc+y；化简得x+y=(m-2n)c；
     * 这意味着从起点0相遇点B的长度为环长度的正整数倍；
     * 换句话说，就是现在让两个指针速度都变成1(重点！！！)，第一个指针从起点0出发，第二个指针从相遇点B出发，则两个指针最后一定会在B点相遇；
     * 但这是两个指针第一次相遇吗？不，因为两个指针速度是相同的，所以往前退一退，就会发现两个指针其实是在环的入口第一次相遇后，就一直重合了；
     * 所以代码就转换成两个速度为1的指针，一个从起点出发，一个从B点出发，第一次相遇的节点即为入环点。

     *
     *      方法二：
     *          HashSet
     */
    public static Node hasCycle(Node head) {
        Node fast = null;
        Node slow = null;
        if(Objects.nonNull(head.getNext()) && Objects.nonNull(head.getNext().getNext())) {
            fast = head.getNext().getNext();
            slow = head.getNext();
        }else return null;
        while (true){
            if(fast.equals(slow)){
                //有环
                return hasCycle0(head,fast);
                //return hasCycle1(head);
            }
            else {
                if(Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())){
                    fast = fast.getNext().getNext();
                    slow = slow.getNext();
                }else return null;
            }
        }
    }

    /**
     * 方法二
     * @return
     */
    private static Node hasCycle1(Node head) {
        HashSet<Node> set = new HashSet<>();
        set.add(head);
        Node next = head.getNext();
        while (!set.contains(next)){
            set.add(next);
            next = next.getNext();
        }
        return next;
    }

    /**
     * 方法一
     * @param head
     * @return
     */
    private static Node hasCycle0(Node head,Node point) {
        Node fast = null;
        Node slow = null;
        fast = head;
        slow = point;
        while (!fast.equals(slow)){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return fast;
    }

    /**
     * 合并两个有序链表 Leetcode 21
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 思路：
     *      方法一：
     *          类似插入排序，将起始较大的链表插入另一个链表
     *          难点：一个链表全部比较完后，另一个链表的处理，第一个先空，第二个先空都有可能；
     *      方法二：
     *          递归比较
     * @param head1
     * @param head2
     * @return
     */
    public <T extends Comparable<T>> Node  mergeTwoLists(Node<T> head1, Node<T> head2) {
        return mergeTwoLists0(head1, head2);
    }

    private <T extends Comparable<T>> Node mergeTwoLists0(Node<T> head1, Node<T> head2) {
        Node<T> head = null;
        Node<T> comp = null;
        if(head1.getValue().compareTo(head2.getValue()) < 0){
            head = head1;
            comp = head2;
        }else {
            head = head2;
            comp = head1;
        }
        Node<T> now = head;
        Node<T> pre = now;
        while (Objects.nonNull(comp)){
            while (Objects.nonNull(now) && comp.getValue().compareTo(now.getValue()) >= 0){
                pre = now;
                now = now.getNext();
            }

            if(Objects.nonNull(now))
            pre.setNext(comp);
            now = comp;
            comp = comp.getNext();
        }
        return  head;
    }

    private  <T extends Comparable<T>> Node  mergeTwoLists1(Node<T> head1, Node<T> head2) {
        return null;
    }
}
