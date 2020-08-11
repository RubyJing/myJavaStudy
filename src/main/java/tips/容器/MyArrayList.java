package tips.容器;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/**
 * 按照ArrayList写一个类似的
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/10 13:57
 */
public class MyArrayList<E> extends AbstractList<E>
        implements Cloneable, List<E>, RandomAccess, Serializable {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    public MyArrayList() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initCapacity) {
        if (initCapacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else if (initCapacity > 0) {
            elementData = new Object[initCapacity];
        } else {
            throw new IllegalArgumentException("非法容量：" + initCapacity);
        }
    }

    @Override
    public E get(int index) {
        this.checkRange(index);
        return elementData(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        ++size;
        checkRangeForAdd();
        elementData[size - 1] = e;
        return true;
    }


    @Override
    public boolean remove(Object e) {
        if (size == 0) {
            return true;
        }
        for (int i = 0; i < elementData.length; i++) {
            if (e == elementData[i]) {
                remove(i);
                break;
            }
        }
        return true;
    }

    @Override
    public E remove(int index) {
        checkRange(index);

        if (size == 0 || elementData == EMPTY_ELEMENTDATA) {
            return null;
        }

        E value = elementData(index);

        int copyLength = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, copyLength);
        elementData[--size] = null;

        return value;
    }

    @Override
    public E set(int index, E element){
        checkRange(index);

        E oldValue = elementData(index);
        elementData[index] = element;

        return oldValue;
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 判断是否在范围中
     *
     * @param index 下标
     */
    private void checkRange(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
    }

    /**
     * 判断是否在范围中新增用
     */
    private void checkRangeForAdd() {
        if (elementData.length == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else if (size > elementData.length) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }

    private String outOfBoundsMsg(int index) {
        return "index：" + index + ",size：" + size;
    }
}
