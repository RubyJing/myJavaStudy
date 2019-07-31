package tips;

import java.util.ArrayList;
import java.util.List;
/**
 * List的add(Integer)只会在最后位置加
 *      remove(Integer)只会移除对应位置的数据，剩下的不会往前排
 */
public class ListTips {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for(int i =0;i<list.size();i++){
            System.out.println("i的值是："+i);
            if(list.get(i)==2 || list.get(i)==4) {
                list.remove(i);
            }
            if(list.get(i)==1){
                list.add(6);
            }
            System.out.println("list的值是:"+list.get(i));
        }
    }
}
