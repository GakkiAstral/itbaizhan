public class DataTypeOperator {
    /**
     * 运算符功能测试及运算结果
     *
     * @author Akira
     */
    public static void main(String[] args) {
        //算术运算符(+-*/%，自增自减)
        System.out.println("测试算术运算符");
        System.out.println("3 + 4 = " + (3 + 4));
        //7,两个数字对应相加
        System.out.println("5 - 1 = " + (5 - 1));
        //4,两个数字相减
        System.out.println("4 * 3 = " + (4 * 3));
        //12，两个数字相乘
        System.out.println("12 / 6 = " + (12 / 6));
        //2，两个数字相除，取商
        System.out.println("33 % 2 = " + (33 % 2));
        //1,两个数字相除，取余数
        int a = 7;
        int b = 4;
        System.out.println("a的值是：" + a + ",b的值是：" + b);
        a++;
        b--;
        System.out.println("a++后的值是：" + a);
        //8，自增，++在后，表示先运算再自增，++在前，表示先自增后运算。
        System.out.println("b--后的值是：" + b);
        //3，自减，--在后，表示先运算再自减，--在前，表示先自减后运算。
        System.out.println("——————————————————————————");
        //赋值扩展运算符
        System.out.println("测试赋值扩展运算符");
        int c = 8;
        int d = 9;
        System.out.println("c的值是：" + c + ",d的值是：" + d);
        System.out.println("c += d的值是：" + (c += d));
        //17，+=表示左边加上右边后赋给左边
        System.out.println("c -= d的值是：" + (c -= d));
        //8，-=表示左边减去右边后赋给左边
        System.out.println("c %= d的值是：" + (c %= d));
        //8，%=表示左边取余右边后赋给左边
        System.out.println("——————————————————————————");
        //关系运算符(<,>,<=,>=,!=,==)
        System.out.println("测试关系运算符");
        System.out.println("3 < 2的值是：" + (3 < 2));
        //false，判断左边是否小于右边，是返回true，否返回false
        System.out.println("1 > 4的值是：" + (1 > 4));
        //false，判断左边是否大于右边，是返回true，否返回false
        System.out.println("6 <= 1的值是：" + (6 <= 1));
        //false，判断左边是否小于或等于右边，是返回true，否返回false
        System.out.println("3 >= 2的值是：" + (3 >= 2));
        //true，判断左边是否大于或等于右边，是返回true，否返回false
        System.out.println("8 != 3的值是：" + (8 != 3));
        //true，判断左右是否不等，是返回true，否返回false
        System.out.println("4 == 4的值是：" + (4 == 4));
        //true，判断左右是否相等，是返回true，否返回false
        System.out.println("——————————————————————————");
        //逻辑运算符(&&，||，!)
        System.out.println("测试逻辑运算符");
        System.out.println("(3 >= 2) && (1 > 4) = " + ((3 >= 2) && (1 > 4)));
        //false，左右两个布尔类型表达式，&&两边都为true，结果为true，否则为false。
        System.out.println("(3 < 2) || (8 != 3) = " + ((3 < 2) || (8 != 3)));
        //true，左右两个布尔类型表达式，||两边任一个为true，结果为true，否则为false。
        System.out.println("!(3 < 2) = " + !(3 < 2));
        //true，布尔类型表达式取反，是为false，否为true
        System.out.println("——————————————————————————");
        //位运算符(&,|,^)
        System.out.println("测试位运算符");
        System.out.println("7 & 4 = " + (7 & 4));
        //4，&左右转为二进制数，按位对比，都为1，结果为1，否则为0
        System.out.println("3 | 11 = " + (3 | 11));
        //11，|左右转为二进制数，按位对比，一方为1，结果为1，否则为0
        System.out.println("6 ^ 9 = " + (6 ^ 9));
        //15，^左右转为二进制数，按位对比，二者互异，则结果为1，否则为0
        System.out.println("——————————————————————————");
        //条件运算符?
        System.out.println("测试条件运算符");
        int e = (7 + 4) > 7 ? a : b;
        System.out.println("(7 + 4) > 7 ? a : b = " + e);
        //8，先判断表达式的值，表达式为真，结果为：左边的值，表达式为假，结果为：右边的值。
        System.out.println("——————————————————————————");
        //字符串连接符
        System.out.println("测试字符串连接符");
        System.out.println("\"abc\" + " + "\"d\"" + " = " + ("abc" + "d"));
        //abcd，实现字符串的连接效果，注意转义字符
    }
}
