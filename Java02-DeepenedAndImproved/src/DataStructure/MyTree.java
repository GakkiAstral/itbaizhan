package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于树形结构实现元素存储的容器
 * 2021-1-25 21:43
 *
 * @author Akira
 */
public class MyTree<E> {
    private Map<E, E> map = new HashMap<>();
    //(String ---> String)
    //找父节点方法

    private Map<E, List<E>> map2 = new HashMap<>();
    //(String ---> List)
    //找子节点方法

    /**
     * 向容器中添加元素
     */
    public void add(E parent, E item) {
        //完成在单节点之间映射
        this.map.put(item, parent);
        //子节点是key,父节点是value

        //完成多结点之间映射
        List<E> list = this.map2.get((parent));
        //判断当前结点下是否含有子节点，如果没有则创建一个新的List
        if (list == null) {
            list = new ArrayList<>();
            this.map2.put(parent, list);
        }
        list.add(item);
        //先把list放到了map2中，然后再往list里面添加元素
    }

    /**
     * 获取当前结点的父节点
     * 返回父节点的元素就可以了
     */
    public E getParent(E item) {
        //获取父节点的话,用map的话更简单
        return this.map.get(item);

    }

    /**
     * 获取当前结点的子节点
     * 因为有多个子结点，所以有多个返回值，则需要返回到一个数组里。
     */
    public List<E> getChild(E item) {
        //获取子节点的话,用map2的话更简单
        return this.map2.get(item);
    }

    /**
     * 获取当前结点的兄弟结点
     * 同上，会有多个结点，需要返回到一个数组
     */
    public List<E> getBrother(E item) {
        //首先的是要获取当前结点的父节点
        E parent = this.getParent(item);
        //获取当前父节点的所有的子节点
        List<E> list = this.getChild(parent);
        List<E> brother = new ArrayList<>();
        if (list != null) {
            brother.addAll(list);
            brother.remove(item);

        }
        return brother;
    }

    /**
     * 获取当前结点的祖先结点
     * 同上，会有多个结点，需要返回到一个数组
     * 会用到递归，知道根节点，无父节点的情况下
     */
    public List<E> getForefathers(E item) {
        //获取当前结点的父节点
        E parent = this.getParent(item);
        //递归调用，必须考虑到边界条件，结束循环的标志，否则就是死循环了
        if (parent == null) {
            return new ArrayList<>();
        }
        //使用递归调用，再次获取当前结点parent的父节点
        List<E> list = this.getForefathers(parent);
        //右边的是上面new的ArrayList
        //将递归到的所有结点元素添加到返回的list中
        list.add(parent);
        return list;
    }

    /**
     * 获取当前结点的子孙结点
     * 同上，会有多个结点，需要返回到一个数组
     * 分析：如何获取到子孙结点
     * 先找到当前结点的所有子节点，for循环遍历得到每一个子节点，子节点递归调用得到每一个子节点的子节点
     * 结束递归的边界是：当每一个结点都没有子节点的时候就结束了
     */
    public List<E> getGrandChildren(E item) {
        //存放所有子孙结点中的元素
        List<E> list = new ArrayList<>();
        //获取当前结点的子节点
        List<E> child = this.getChild(item);
        //同样的在递归方法的上面定义递归的边界条件
        if (child == null) {
            return list;
        }

        //遍历子节点
        for (int i = 0; i < child.size(); i++) {
            //获取结点中的元素
            E ele = child.get(i);
            List<E> temp = this.getGrandChildren(ele);
            list.add(ele);
            list.addAll(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        //实例化容器
        MyTree<String> myTree = new MyTree<>();
        //添加元素
        myTree.add("root", "生物");
        myTree.add("生物", "植物");
        myTree.add("生物", "动物");
        myTree.add("生物", "菌类");
        myTree.add("动物", "脊椎动物");
        myTree.add("动物", "脊索动物");
        myTree.add("动物", "腔肠动物");
        myTree.add("脊椎动物", "哺乳动物");
        myTree.add("脊椎动物", "鱼类");
        myTree.add("哺乳动物", "猫");
        myTree.add("哺乳动物", "牛");
        myTree.add("哺乳动物", "人");
        System.out.println("———————————获取父节点———————————");
        String parent1 = myTree.getParent("鱼类");
        System.out.println(parent1);
        //脊椎动物
        System.out.println("———————————获取子节点———————————");
        List<String> child1 = myTree.getChild("动物");
        for (String str : child1) {
            System.out.print(str + " ");
        }
        System.out.println();
        //脊椎动物 脊索动物 腔肠动物
        System.out.println("———————————获取兄弟节点———————————");
        List<String> brother1 = myTree.getBrother("脊椎动物");
        for (String str : brother1) {
            System.out.print(str + " ");
        }
        System.out.println();
        //脊索动物 腔肠动物
        System.out.println("———————————获取祖先节点———————————");
        List<String> forefathers1 = myTree.getForefathers("人");
        for (String str : forefathers1) {
            System.out.print(str + " ");
        }
        System.out.println();
        //root 生物 动物 脊椎动物 哺乳动物
        System.out.println("———————————获取子孙节点———————————");
        List<String> grandChildren1 = myTree.getGrandChildren("生物");
        for (String str : grandChildren1) {
            System.out.print(str + " ");
        }
        System.out.println();
        //植物 动物 脊椎动物 哺乳动物 猫 牛 人 鱼类 脊索动物 腔肠动物 菌类
    }
}
