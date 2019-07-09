package tips.构建简单链表;

import java.util.Collection;
import java.util.Iterator;

/**
 * 抽象简单链表类
 * @param <E>
 */
public abstract class AbstractSimpleList<E> implements List<E>{
    protected AbstractSimpleList() {
    }

    public abstract int size();

    @Override
    public abstract Iterator<E> iterator();

    @Override
    abstract public E get(int index);

    @Override
    public boolean add(E e){
        add(size(),e);
        return true;
    }

    /**
     *这个实现总是抛出一个
     *  {@code UnsupportedOperationException}。
     * @param index
     * @param element
     */
    public void add(int index,E element){
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> c){
        boolean modified = false;
        for (E e:c){
            if(add(e)){
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean contains(Object o){
        Iterator<E> it = iterator();
        if(o == null){
            if(it.hasNext()){
                if(it.next()==null){
                    return true;
                }
            }
        }else {
            if(it.hasNext()){
                if (it.next().equals(o)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c){
        for(Object o :c){
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o){
        Iterator<E> it = iterator();
        if(o == null){
            if(it.hasNext()){
                if(it.next()==null){
                    it.remove();
                    return true;
                }
            }
        }else {
            if (it.hasNext()){
                if (it.next().equals(o)){
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

}
