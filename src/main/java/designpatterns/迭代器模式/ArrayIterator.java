package designpatterns.迭代器模式;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * ArrayList 的迭代器
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/25 9:07
 */
public class ArrayIterator<E> implements MyIterator<E> {

    private int cursor;
    private ArrayList<E> arrayList;


    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        //cursor 在指向最后一个元素的时候，hasNext()仍然返回true
        return cursor != arrayList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor >= arrayList.size()){
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor);
    }


}
