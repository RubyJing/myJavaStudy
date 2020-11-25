package designpatterns.迭代器模式;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 快照数组迭代器
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/25 10:55
 */
public class SnapshotArrayIterator<E> implements Iterator<E> {

    private ArrayList<E> snapshot;

    private int cursor;

    public SnapshotArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.snapshot = new ArrayList<>();
        this.snapshot.addAll(arrayList);
    }

    @Override
    public boolean hasNext() {
        return cursor < snapshot.size();
    }

    @Override
    public E next() {
        E curr = snapshot.get(cursor);
        cursor++;
        return curr;
    }

}
