package DataStructure;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 自定义栈容器
 * 2021-1-24 12:18
 *
 * @author Akira
 */
public class MyStack<E> {
    private Object[] arr;
    //存放元素的物理结构
    private int stackLength = 4;
    //数组的默认长度
    private int size;
    //记录栈容器的元素个数
    private int index = -1;
    //操作数组下标位置的指针，指针默认不指向任何一个元素。

    //判断栈容器是否为空
    public boolean empty() {
        return this.size == 0;
    }

    //获取栈顶元素
    public E pop() {
        //如果栈容器中没有元素，则抛出异常。
        if (this.index == -1) {
            throw new EmptyStackException();
        }
        //记录元素个数
        this.size--;
        //否则返回栈顶元素
        return (E)this.arr[index--];
    }

    //向栈容器中添加元素
    public E push(E item) {
        //初始化数组
        this.capacity();
        //向数组中添加元素
        this.arr[++index] = item;
        //先对index自增后再往里面存放元素
        //记录元素个数
        this.size++;
        //最后把item返回回去。
        return item;
    }

    //数组初始化，或者以1.5倍容量对数组扩容
    private void capacity() {
        //数组初始化
        if (this.arr == null) {
            this.arr = new Object[this.stackLength];
        }
        //数组以1.5倍进行扩容
        if (this.size - (this.stackLength - 1) >= 0) {
            this.stackLength = this.stackLength + (this.stackLength >> 1);
            //位运算的效率大于除法的效率
            //只获取到了扩容后的数组长度
            this.arr= Arrays.copyOf(this.arr,this.stackLength);
            //完成数组扩容
        }
    }

    public static void main(String[] args) {
        //实例化栈容器
        MyStack<String> myStack = new MyStack<>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        myStack.push("d");
        myStack.push("e");
        myStack.push("f");

        System.out.println(myStack.size);
        //6
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        //f
        //e
        //d

    }
}