package DataStructure;
/**
 * 抽象出来的链表接口的定义
 * 基于链表结构存取元素的方法API定义
 * 2021-1-24 18:37
 *
 * @author Akira
 */
public interface MyList<E> {
    //添加元素
    public void add(E element);
    //根据元素位置获取元素
    E get(int index);
    //返回数组长度
    int size();
    //链表中删除元素
    E remove(int index);
}
