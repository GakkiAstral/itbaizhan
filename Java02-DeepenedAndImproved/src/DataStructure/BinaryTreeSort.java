package DataStructure;

/**
 * 基于二叉树结构实现元素排序处理的排序器
 * 2021-1-25 20:13
 *
 * @author Akira
 */
public class BinaryTreeSort<E extends Integer> {
    //上限是Integer，Integer类和继承了Integer的类都可以

    /**
     * 以内部类的形式，定义结点类
     *
     * @param <N>
     */
    class Node<N extends Integer> {
        private E item;
        //存放元素
        private Node left;
        //存放左子树地址
        private Node right;
        //存放右子树地址

        //构造方法
        Node(E item) {
            this.item = item;
        }

        /**
         * 添加结点
         *
         * @param node
         */
        public void addNode(Node node) {
            //完成新节点中的元素与当前结点中的元素的判断。
            //如果新结点中的元素小于当前结点中的元素，那么新结点则放到当前结点的左子树。
            if (node.item.intValue() < this.item.intValue()) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.addNode(node);
                }
            } else {
                //如果新结点中的元素大于当前结点中的元素，那么新结点放到当前结点的右子树
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.addNode(node);
                }
            }
        }

        /**
         * 使用中序遍历二叉树
         * 递归的压栈，弹栈要考虑好，看似只是其中一个小循环，但因为递归嵌套，已经是输出整个二叉树了。
         */
        public void inorderTraversal() {
            //找到最左侧的那个结点
            if (this.left != null) {
                this.left.inorderTraversal();
            }

            System.out.println(this.item);

            if (this.right != null) {
                this.right.inorderTraversal();
            }
        }
    }


    //存放当前二叉树的根节点的地址
    private Node root;

    /**
     * 将元素添加到排序器中
     *
     * @param element
     */
    public void add(E element) {
        //实例化结点对象
        Node<E> node = new Node<>(element);
        //判断当前二叉树中是否有根节点，如果没有，那么新结点则为根节点
        if (this.root == null) {
            this.root = node;
        } else {
            //将当前结点加到左子树还是右子树下
            this.root.addNode(node);
        }
    }

    /**
     * 对元素进行排序
     */
    public void sort() {
        //判断根节点是否为空
        if (this.root ==null) {
            return;
        }
        this.root.inorderTraversal();
    }

    public static void main(String[] args) {
        BinaryTreeSort<Integer> sort = new BinaryTreeSort<>();
        //12,10,5,6,3,1
        sort.add(1);
        sort.add(6);
        sort.add(3);
        sort.add(12);
        sort.add(10);
        sort.add(5);

        //调用排序方法
        sort.sort();
        //1
        //3
        //5
        //6
        //10
        //12
    }

}
