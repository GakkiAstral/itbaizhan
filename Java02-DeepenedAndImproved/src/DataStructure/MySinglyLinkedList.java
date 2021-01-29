package DataStructure;

/**
 * 基于单向链表实现元素存取的容器
 * 2021-1-24 18:40
 *
 * @author Akira
 */
public class MySinglyLinkedList<E> implements MyList<E> {
    /**
     * 定义单向链表中的结点对象
     *
     * @param <E>
     */
    class Node<E> {
        private E item;//存储元素
        private Node next;//存储下一个结点对象的地址

        Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


    private Node head;
    //存放链表中的头结点
    private int size;
    //记录元素个数

    /**
     * 向链表中添加元素
     *
     * @param element
     */
    @Override
    public void add(E element) {
        //第一步：创建结点
        Node<E> node = new Node<>(element, null);
        //第二步：找到尾结点
        Node tail = getTail();
        //第三步：节点的挂接
        if (tail == null) {
            this.head = node;
        } else {
            tail.next = node;
        }
        //第四步：记录元素个数
        this.size++;

    }

    /**
     * 查找尾结点的方法
     *
     * @return
     */
    private Node getTail() {
        //先判断头结点是否存在
        if (this.head == null) {
            return null;
        }
        //头结点不可以变动，用一个临时变量去变动。
        Node node = this.head;
        while (true) {
            if (node.next == null) {
                break;
            }
            //移动指针，指向下一个结点
            node = node.next;
        }
        return node;
    }

    /**
     * 根据元素位置获取元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        //校验index的合法性（抽象出去，作为独立方法）
        this.checkIndex(index);
        //根据位置获取指定结点(抽象出去，作为独立方法)
        Node<E> node = this.getNode(index);
        //将该结点中的元素返回
        return node.item;
    }

    /**
     * 对Index进行校验
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException("现在给定的index是：" + index + "，现在实际的长度是" + size);
        }
    }

    /**
     * 根据位置获取结点
     *
     * @param index
     * @return
     */
    private Node getNode(int index) {
        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 根据元素的位置删除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //校验index的合法性
        this.checkIndex(index);
        //根据位置找到该结点对象
        Node<E> node = this.getNode(index);
        //获取该结点对象中的元素
        E item = node.item;
        //将该结点对象从单向链表中移除
        //判断当前要删除的结点是否是头结点
        if (this.head == node) {
            this.head = node.next;
        } else {
            //不是头结点，就要找到node的前一个结点
            Node<E> temp = this.head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = node.next;
        }
        node.next = null;
        //记录元素个数
        this.size--;
        //将该元素返回
        return item;
    }

    public static void main(String[] args) {
        MySinglyLinkedList<String> mySinglyLinkedList = new MySinglyLinkedList<>();
        mySinglyLinkedList.add("A");
        mySinglyLinkedList.add("B");
        mySinglyLinkedList.add("C");
        mySinglyLinkedList.add("D");
        mySinglyLinkedList.add("E");
        System.out.println(mySinglyLinkedList.size());
        //长度是5

        //删除第0个第1个位置的元素
        System.out.println(mySinglyLinkedList.remove(0));
        System.out.println(mySinglyLinkedList.remove(1));
        //被删除元素分别是：
        //A
        //C

        System.out.println(mySinglyLinkedList.size());
        //当前链表长度是3

        for (int i = 0;i<mySinglyLinkedList.size();i++) {
            System.out.println(mySinglyLinkedList.get(i));
        }
        //遍历剩余链表中的元素
        //B
        //D
        //E
    }
}
