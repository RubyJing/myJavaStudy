package designpatterns.迭代器模式;

/**
 * 迭代器接口
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/25 9:06
 */
public interface MyIterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}
