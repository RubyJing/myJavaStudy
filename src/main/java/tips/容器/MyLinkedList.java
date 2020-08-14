package tips.容器;

import java.io.Serializable;
import java.util.*;

/**
 * 模仿LinkedList自己实现一个
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/8/11 11:25
 */
public class MyLinkedList<E>
        extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, Serializable {

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public MyLinkedList() {
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkElementIndex(index);

        if (index == size - 1) {
            addLast(element);
        } else {
            linkBefore(node(index), element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        isPositionIndex(index);

        Object[] objects = c.toArray();
        int length = objects.length;
        if (length == 0) {
            return false;
        }

        Node<E> prev, curr;
        if (index == size) {
            curr = null;
            prev = last;
        } else {
            curr = node(index);
            prev = curr.prev;
        }

        for (Object object : objects) {
            @SuppressWarnings("unchecked") E e = (E) object;
            Node<E> newNode = new Node<>(prev, e, null);
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;
        }

        if (curr == null) {
            last = prev;
        } else {
            prev.prev = curr;
            curr.next = prev;
        }

        size += length;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);

        return unlink(node(index));
    }

    @Override
    public void clear() {
        for (Node<E> n = first; n != null; ) {
            final Node<E> next = n.next;
            n.item = null;
            n.prev = null;
            n.next = null;
            n = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    Node<E> node(int index) {

        if (index < (size >> 1)) {
            //从第一个开始
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            //从最后一个开始
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }

    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void isPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }


    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override
    public void addLast(E e) {
        linkLast(e);
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }

        return unlinkFirst();
    }

    @Override
    public E removeLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }

        return unlinkLast();
    }

    @Override
    public E pollFirst() {
        final Node<E> f = first;
        return f == null ? null : unlinkFirst();
    }

    @Override
    public E pollLast() {
        final Node<E> l = last;
        return l == null ? null : unlinkLast();
    }

    @Override
    public E getFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    @Override
    public E getLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    @Override
    public E peekFirst() {
        final Node<E> f = first;
        return f == null ? null : f.item;
    }

    @Override
    public E peekLast() {
        final Node<E> l = last;
        return l == null ? null : l.item;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> node = last; node != null; node = node.prev) {
                if (node.item == null) {
                    unlink(node);
                    return true;
                }
            }
        } else {
            for (Node<E> node = last; node != null; node = node.prev) {
                if (node.item.equals(o)) {
                    unlink(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        final Node<E> f = first;
        return f == null ? null : unlinkFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        final Node<E> f = first;
        return first == null ? null : first.item;
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private void linkBefore(Node<E> node, E e) {
        Node<E> beforeNode = node.prev;
        Node<E> newNode = new Node<>(beforeNode, e, node);
        if (beforeNode == null) {
            first = newNode;
        } else {
            beforeNode.next = newNode;
        }
        node.prev = newNode;
        size++;
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.prev = newNode;
        }
        size++;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.item.equals(o)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> node = last; node != null; node = node.prev) {
                index--;
                if (node.item == null) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = last; node != null; node = node.prev) {
                index--;
                if (node.item.equals(o)) {
                    return index;
                }
            }
        }
        return -1;
    }

    E unlink(Node<E> node) {
        final Node<E> p = node.prev;
        final Node<E> n = node.next;
        final E element = node.item;
        node.item = null;
        if (p == null) {
            first = null;
        } else {
            p.next = n;
            node.prev = null;
        }

        if (n == null) {
            last = null;
        } else {
            n.prev = p;
            node.next = null;
        }
        size--;

        return element;
    }

    private E unlinkFirst() {
        final Node<E> f = first;
        final Node<E> newFirst = f.next;
        final E element = first.item;
        //GC
        f.item = null;
        f.next = null;
        first = newFirst;
        if (newFirst == null) {
            last = null;
        } else {
            newFirst.prev = null;
        }
        size--;

        return element;
    }

    private E unlinkLast() {
        final Node<E> l = last;
        final Node<E> newLast = l.prev;
        final E element = l.item;
        l.item = null;
        l.prev = null;
        last = newLast;
        if (newLast == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return element;
    }
}
