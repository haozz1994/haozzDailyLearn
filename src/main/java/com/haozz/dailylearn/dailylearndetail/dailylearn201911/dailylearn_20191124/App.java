package com.haozz.dailylearn.dailylearndetail.dailylearn201911.dailylearn_20191124;

/**
 * @author
 * @date 2019/11/24 10:57
 **/
public class App {

    String s1 = "全局变量";

    // 1. 匿名内部类中对于变量的访问
    public void testInnerClass() {
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";

            @Override
            public void run() {
                //访问全局变量
//                System.out.println(this.s1); // this关键字 表示是当前内部类型的对象,这里不能使用
                System.out.println(s1);

                //访问局部变量
                System.out.println(s2); //局部变量的访问 不能对局部变量进行数据的修改 会认为其是final的
//                s2 = "hello";

                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }

    // 2.lambda表达式变量捕获
    public void testLambda() {
        String s2 = "lambda局部变量";
        new Thread(() -> {
            String s3 = "内部变量lambda";

            // 访问全局变量
            System.out.println(this.s1); //this表示的就是所属方法所在类型的对象，可以使用

            System.out.println(s2);//局部变量的访问 不能对局部变量进行数据的修改 会认为其是final的
//            s2 = "hello";

            System.out.println(s3);
            s3 = "lambda 内部变量直接修改";
            System.out.println(s3);

        }).start();
    }


    public static void main(String[] args) {

        App app = new App();
        app.testInnerClass();

        app.testLambda();
    }

}
