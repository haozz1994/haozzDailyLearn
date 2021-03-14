package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210314;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author haozhezhe@yunquna.com
 * @date 11:05 PM 3/14/21
 */
public class TestReflection {

    public static void main(String[] args) throws ClassNotFoundException {

        Class c1 = Class.forName("com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210314.User");
        System.out.println(c1.hashCode());

        Class c2 = Class.forName("com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210314.User");
        System.out.println(c2.hashCode());

        Class c3 = Class.forName("com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210314.User");
        System.out.println(c3.hashCode());

        // 一个类在内存中只有一个Class对象


        User u1 = new User();
        u1.setName("sss");
        User u2 = new User();
        u2.setName("dsds");
        Class<? extends User> c4 = u1.getClass();
        Class<? extends User> c5 = u2.getClass();
        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());


        //  Class  是用于描述类 的  类
        //  反射 可以理解为 和 new  相反的，   new是通过类实例化对象，  反射是通过对象 拿到类的信息


    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class User {
    private Long id;
    private String name;
    private Integer age;
}
