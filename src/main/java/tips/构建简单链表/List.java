package tips.构建简单链表;

public interface List<E> extends Iterable<E> {
    /**
     * 获取第Index个
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 添加一个实体
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 移除一个实体
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * 是否包含Object
     * @param o
     * @return
     */
    boolean contains(Object o);


}
