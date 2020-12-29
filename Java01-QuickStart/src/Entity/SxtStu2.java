package Entity;

/**
 * 构造方法的重载问题，即考虑到有参构造和无参构造,注意找好this的含义，this表示的是该声明对象的成员变量。
 */
public class SxtStu2 {
    int id;
    String sname;
    int age;

    SxtStu2() {
    }

    SxtStu2(int id, String sname, int age) {
        this.id = id;
        this.sname = sname;
        this.age = age;
    }
}

class TestSxtStu2 {
    public static void main(String[] args) {
        SxtStu2 s1 = new SxtStu2(1001,"张三",18);
        System.out.println(s1.id);
        System.out.println(s1.sname);
        System.out.println(s1.age);
    }
}
