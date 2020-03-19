package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
          move(A.size(), A, B, C);
          C.forEach(System.out::println);
    }

    //将n-1个元素从from借助mid移动to,
    // 再将from中元素移动到mid
    // 再将to里所有元素
    public void move (int num, List<Integer> from, List<Integer> mid, List<Integer> to ){
        if(num == 1){
            moveTo(from,to);
            return;
        }

        //将from中的最后一个元素直接移动到to
        move(num-1,from,to, mid);
        moveTo(from,to);
        move(num-1,mid, from , to);
    }

    public void moveTo(List<Integer> from, List<Integer> to){
        Integer remove = from.remove(from.size() - 1);
        to.add(remove);
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        Hanota hanota = new Hanota();
        hanota.hanota(list,new ArrayList<Integer>(),new ArrayList<Integer>());

    }
}
