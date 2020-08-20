package tips.容器;

import java.io.Serializable;
import java.util.AbstractQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 模仿实现一个PriorityQueue优先队列
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/18 11:08
 */
public class MyPriorityQueue<E> extends AbstractQueue<E>
        implements Serializable {

    public static final int DEFAULT_INITIAL_CAPACITY = 11;

    transient Object[] queue;

    private int size = 0;

    private final Comparator<? super E> comparator;

    transient int modCount = 0;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyPriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    @Override
    public boolean add(E e) {
        if (offer(e)) {
            return true;
        } else {
            throw new NullPointerException();
        }
    }

    public MyPriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public MyPriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        modCount++;
        int i = size;
        if (i >= queue.length) {
            grow(i + 1);
        }
        size = i + 1;
        if (i == 0) {
            queue[0] = e;
        } else {
            siftUp(i, e);
        }
        return false;
    }

    private void siftUp(int k, E x) {
        if (comparator == null) {
            siftUpUsingComparator(k, x);
        } else {
            siftUpComparable(k, x);
        }
    }

    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parentNodeIndex = (k - 1) >> 1;
            Object parent = queue[parentNodeIndex];
            if (key.compareTo((E) parent) >= 0) {
                break;
            }
            queue[k] = parent;
            k = parentNodeIndex;
        }
        queue[k] = x;
    }

    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parentNodeIndex = (k - 1) >> 1;
            Object parent = queue[parentNodeIndex];
            if (comparator.compare(x, (E) parent) >= 0) {
                break;
            }
            queue[k] = parent;
            k = parentNodeIndex;
            queue[k] = x;
        }
    }


    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity + (oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1);

        //防止溢出
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = hugeCapacity(minCapacity);
        }

        queue = Arrays.copyOf(queue, newCapacity);
    }

    private static int hugeCapacity(int capacity) {
        if (capacity < 0) {
            throw new OutOfMemoryError();
        }
        return capacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        modCount++;
        E head = queue(0);
        E x = queue(s);
        queue[s] = null;
        if (s != 0) {
            siftDown(0, x);
        }
        return head;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1) {
            return false;
        } else {
            removeAt(i);
            return true;
        }
    }

    private E removeAt(int i) {
        modCount++;
        int last = --size;
        if (i == last) {
            queue[i] = null;
        } else {
            E lastValue = queue(last);
            queue[last] = null;
            siftDown(i, lastValue);
            if (queue[i] == lastValue) {
                siftUp(i, lastValue);
                if (queue[i] != lastValue) {
                    return lastValue;
                }
            }
        }
        return null;
    }

    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (queue[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void siftDown(int k, E x) {
        if (comparator == null) {
            siftDownUsingComparator(k, x);
        } else {
            siftDownComparable(k, x);
        }
    }

    private void siftDownComparable(int k, E x) {
        Comparable<? super E> n = (Comparable<? super E>) x;
        int half = size >>> 1;
        while (k < half) {
            int childNode = k << 1 + 1;
            E c = queue(childNode);
            int rightNode = childNode + 1;
            if (rightNode <= size
                    && ((Comparable<? super E>) c).compareTo(queue(rightNode)) > 0) {
                c = queue(childNode = rightNode);
            }
            if (n.compareTo(c) <= 0) {
                break;
            }
            queue[k] = c;
            k = childNode;
        }
        queue[k] = x;
    }

    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int childNode = k << 1 + 1;
            E c = queue(childNode);
            int rightNode = childNode + 1;
            if (rightNode < size
                    && comparator.compare(c, queue(rightNode)) > 0) {
                c = queue(childNode = rightNode);
            }
            if (comparator.compare(c, x) >= 0) {
                break;
            }
            queue[k] = c;
            k = childNode;
        }
        queue[k] = x;
    }

    private E queue(int index) {
        return (E) queue[index];
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return (E) queue[0];
    }
}
