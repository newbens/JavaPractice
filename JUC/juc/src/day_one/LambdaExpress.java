package day_one;

/**
 * 函数式编程
 *  拷贝中括号，写死大箭头，落地大括号
 *   函数式接口才可以用lambda表达式
 *   接口中只能有一个方法，可以有多个default方法和static方法
 */
interface Inter{
    void sayHello();
}

public class LambdaExpress {

    public static void main(String[] args) {
//        Inter inter = new Inter() {
//            @Override
//            public void sayHello() {
//                System.out.println("Hello");
//            }
//
//            @Override
//            public int add(int x, int y) {
//                return x+y;
//            }
//        };
//        inter.sayHello();
//        inter.add(1, 2);

        Inter inter = () -> {
            System.out.println("Hello");
        };
        inter.sayHello();
    }

}
