package Entity;

public class Point {
    double x, y;

    public Point(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public double getDistance(Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
    //要搞清楚的是，x、y、p.x、p.y四个指的是谁
    //x和y，是谁调用getDistance这个方法的对象值
    //p.x和p.y，是传入参数的对象值
}

class TestPointConstructor {
    public static void main(String[] args) {
        Point p = new Point(3.0, 4.0);
        Point origin = new Point(0.0, 0.0);
        System.out.println(p.getDistance(origin));
        //输出结果是5.0
    }
}
