package algorithm.queue;

/**
 * 数组顺序队列
 */
public class ArrayQueue<T> {
    private Object[] data;
    private int tail;
    private int head;
    private int size;

    public ArrayQueue(int n){
        data = new Object[n];
        this.size = n;
    }

    /**
     * 入队
     * @param t
     */
    public void enqueue(T t){

    }

    /**
     * 出队
     */
    public void dequeue(){

    }

    /**
     * 判断是否队列为空
     * @return
     */
    public boolean isEmpty(){
        if(tail == head) return true;
        return false;
    }
}
