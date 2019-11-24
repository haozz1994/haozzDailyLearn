package com.haozz.dailylearn.dailylearn_20191124;

import java.util.ArrayList;
import java.util.List;

/**
 * lambda类型检查
 * @author
 * @date 2019/11/24 11:25
 **/
public class App2 {
        public static void test(MyInterface<String, List> inter){
            List<String> list = inter.strategy("hello", new ArrayList());
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

}


interface MyInterface<T, R> {
    R strategy(T t, R r);
}