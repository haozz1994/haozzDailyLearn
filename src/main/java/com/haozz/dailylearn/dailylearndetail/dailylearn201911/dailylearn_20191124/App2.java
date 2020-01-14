package com.haozz.dailylearn.dailylearndetail.dailylearn201911.dailylearn_20191124;

import java.util.ArrayList;
import java.util.List;

/**
 * lambda类型检查
 *
 * @author
 * @date 2019/11/24 11:25
 **/
public class App2 {
    public static void test(MyInterface<String, List> inter) {
        List<String> list = inter.strategy( "hello", new ArrayList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        //jvm在底层构建时，会自动进行推导，识别参数的类型
        test((x, y) -> {
            //此处的y被自动识别为list
            y.add(x);
            return y;
        });
    }


    //  命令行中
    //  javac App.java  对java文件进行编译
    //  javap -p App.class  查看编译后的class文件

    //  lambda编译后  会生成一个私有的main方法
    /**
     *  private static void lambda&main&0(java.lang.String)
     */

}


interface MyInterface<T, R> {
    R strategy(T t, R r);
}