package tips.容器;

import java.io.Serializable;
import java.util.*;

/**
 * 按照ArrayDeque写一个类似的
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/17 9:22
 */
public class MyArrayDeque<E> extends AbstractCollection<E>
        implements Deque<E>, Cloneable, Serializable {

    transient Object[] elements;

    transient int head;

    transient int tail;

    private static final int MIN_INITIAL_CAPACITY = 8;

    public MyArrayDeque() {
        elements = new Object[16];
    }

    public MyArrayDeque(int capacity) {
        allocateElements(capacity);
    }


    private void allocateElements(int numElements) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>> 1);
            initialCapacity |= (initialCapacity >>> 2);
            initialCapacity |= (initialCapacity >>> 4);
            initialCapacity |= (initialCapacity >>> 8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0) {
                //  Good luck allocating 2 ^ 30 elements
                initialCapacity >>>= 1;
            }

        }
        elements = new Object[initialCapacity];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        elements[head = (head - 1) & (elements.length - 1)] = e;
        if (head == tail) {
            doubleCapacity();
        }
    }

    private void doubleCapacity() {
        assert head == tail;
        int m = head;
        int o = elements.length;
        // head 右边元素的个数
        int length = o - m;
        int newLength = o << 1;
        if (newLength < 0) {
            throw new IllegalStateException("sorry , too large");
        }
        Object[] newElements = new Object[newLength];
        System.arraycopy(elements, m, newElements, 0, length);
        System.arraycopy(elements, 0, newElements, length, m);
        elements = newElements;
        head = 0;
        tail = o;

    }

    @Override
    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        elements[tail] = e;
        if ((tail = (tail + 1) & (elements.length - 1)) == head) {
            doubleCapacity();
        }
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        int h = head;
        Object result = elements[h];
        if (result == null) {
            return null;
        }
        //let GC work
        elements[h] = null;
        //下标越界处理
        head = (head + 1) & (elements.length - 1);
        return (E) result;
    }


    @Override
    public E pollLast() {
        int t = (tail - 1) & (elements.length - 1);
        Object result = elements[t];
        if (result == null) {
            return null;
        }
        elements[t] = null;
        tail = t;
        return (E) result;
    }

    @Override
    public E getFirst() {
        E result = (E) elements[head];
        if (result == null){
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public E getLast() {
        int t = (tail - 1) & (elements.length - 1);
        E ta = (E) elements[t];
        if (ta == null) {
            throw new NullPointerException();
        }
        return ta;
    }

    @Override
    public E peekFirst() {
        E h = (E)elements[head];
        return h;
    }

    @Override
    public E peekLast() {
        int t = (tail - 1) & (elements.length - 1);
        E ta = (E) elements[t];
        return ta;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
