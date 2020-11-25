package designpatterns.迭代器模式;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * LinkedIterator
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/25 9:20
 */
public class LinkedIterator<E> implements MyIterator<E> {

    private int cursor;
    private LinkedList<E> linkedList;

    public LinkedIterator(LinkedList<E> linkedList) {
        this.cursor = 0;
        this.linkedList = linkedList;
    }

    @Override
    public boolean hasNext() {
        return cursor != linkedList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor >= linkedList.size()) {
            throw new NoSuchElementException();
        }
        return linkedList.get(cursor);
    }
}
