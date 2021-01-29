package DataStructure;

/**
 * 基于双向链表实现元素存取的容器
 * 2021-1-24 21:50
 *
 * @author Akira
 */
public class MyDoublyLinkedList<E> implements MyList<E> {
    /**
     * 定义双向链表的结点对象
     *
     * @param <E>
     */
    class Node<E> {
        E item;//记录元素
        Node<E> prev;//记录前一个结点对象
        Node<E> next;//记录下一个结点对象

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node head;
    //记录头结点
    private Node tail;
    //记录尾结点
    private int size;
    //记录元素个数


    /**
     * 向双向链表添加元素的方法
     *
     * @param element
     */
    @Override
    public void add(E element) {
        this.linkLast(element);
    }

    /**
     * 将节点对象添加到双向链表的尾部
     *
     * @param element
     */
    private void linkLast(E element) {
        //获取尾结点
        Node t = this.tail;
        //创建新的结点对象,新节点的尾当前是空的。
        Node<E> node = new Node<>(t, element, null);
        //将新节点定义为尾结点
        this.tail = node;
        if (t == null) {
            //如果一个元素都没有，那么node既是头结点又是尾结点
            this.head = node;
        } else {
            //完成原来的尾结点和当前结点的挂接
            t.next = node;
        }
        this.size++;
    }

    /**
     * 根据指定位置获取元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        //对Index做合法性校验（抽取方法）
        this.checkIndex(index);
        //根据位置查找结点对象（抽取方法）
        Node<E> node = this.getNode(index);
        return node.item;
    }

    /**
     * 校验Index的合法性
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException("Index:" + index + "Size:" + size);
        }
    }

    /**
     * 根据位置获取指定结点对象
     *
     * @param index
     * @return
     */
    private Node getNode(int index) {
        //分两种情况，判断当前位置，决定从头往尾找还是从尾往头找，提高查询效率。size/2
        if (index < (size >> 1)) {
            //右位移比除以2效率高
            Node node = this.head;
            //小于一半的位置，从头往尾查找，头结点head不可变，新建临时结点对象node。
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            //大于等于一半的位置，从尾往头查找，尾结点tail不可变，新建临时结点对象node。
            Node node = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    /**
     * 返回元素的个数
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 根据指定位置删除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //对index进行合法性校验
        this.checkIndex(index);
        //根据指定位置获取到结点对象
        Node<E> node = this.getNode(index);
        //获取结点对象中的元素
        E item = node.item;
        //删除结点对象（当前结点是否是头结点，尾结点）
        //分别考虑是否是头尾结点，完成该结点删除后前后结点的挂接
        //判断当前结点是否是头结点
        if (node.prev == null) {
            this.head = node.next;
            //该头结点被删除后，则下一个结点被当成是头结点。
        } else {
            //区别于单向链表的查找，双向链表可以直接查到直接前驱和直接后继
            node.prev.next = node.next;
        }
        //判断当前结点是否是尾结点
        if (node.next == null) {
            this.tail = node.prev;
            //该尾结点被删除后，则前一个结点被当成是尾结点。
        } else {
            node.next.prev = node.prev;
            //完成当前结点的直接后继结点与当前结点的直接前驱结点的挂接
        }
        //当前结点断掉与他直接前驱结点的连接
        node.prev = null;
        //当前结点断掉与他直接后继结点的连接
        node.next = null;
        //加快资源回收
        node.item = null;
        //记录元素个数
        this.size--;
        return item;
    }

    /**
     * 在双向链表的头添加元素
     * @param element
     */
    public void addFirst(E element) {
        this.linkFirst(element);
    }

    /**
     * 在链表的头添加元素
     * @param element
     */
    private void linkFirst(E element) {
        //获取头结点对象，在头结点前侧增加一个结点。
        Node head = this.head;
        Node node = new Node(null,element,head);
        //完成尾结点的挂接了，尾结点和之前的头结点的挂接。
        //将新节点定义为头结点，给this.head;
        this.head = node;
        //判断当前链表中是否有结点，如果没有，那么该结点既是头结点也是尾结点
        if (head == null) {
            this.tail = node;
        } else {
            head.prev = node;
        }
        //记录元素个数
        this.size++;
    }

    /**
     * 在链表的尾添加元素
     * @param element
     */
    public void addLast(E element) {
        this.linkLast(element);
    }



    public static void main(String[] args) {
        //实例化
        MyList<String> myList = new MyDoublyLinkedList<>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        System.out.println(myList.size());
        //返回结果是4，说明add和size方法都没问题
        System.out.println("被删除的元素是："+myList.remove(2));
        //被删除的元素是：c
        for (int i= 0;i<myList.size();i++) {
            System.out.println(myList.get(i));
        }
        //a
        //b
        //d

        //下面要测试addFirst和addLast两个方法，但是接口MyList是没有这两个方法的。
        //所以之前的实例化的对象就不可以用了，需要重新实例化对象了。
        System.out.println("-------------------------------");
        MyDoublyLinkedList<String> list = new MyDoublyLinkedList<>();
        list.add("a");
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");
        for (int i = 0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        //打印结果是：
        //C
        //A
        //a
        //B
        //addFirst和addLast是可用的。
    }
}
