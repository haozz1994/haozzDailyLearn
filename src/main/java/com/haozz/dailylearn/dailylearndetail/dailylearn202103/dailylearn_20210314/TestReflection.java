package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210314;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.annotation.ElementType;

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
        System.out.println("================================================================================================");


        User u1 = new User();
        u1.setName("sss");
        User u2 = new User();
        u2.setName("dsds");
        Class<? extends User> c4 = u1.getClass();
        Class<? extends User> c5 = u2.getClass();
        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());

        System.out.println("================================================================================================");


        //  Class  是用于描述类 的  类
        //  反射 可以理解为 和 new  相反的，   new是通过类实例化对象，  反射是通过对象 拿到类的信息


        User u11 = new Student();
        System.out.println("此乃" + u11.getName());
        Class aClass = u11.getClass();
        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());
        System.out.println(aClass.getDeclaredFields());
        System.out.println(Integer.TYPE);


        System.out.println("================================================================================================");


        Class c11 = Object.class;
        Class c12 = Comparable.class;
        Class c13 = String[].class;
        Class c14 = String[][].class;
        Class c15 = Override.class;
        Class c16 = ElementType.class;
        Class c17 = Integer.class;
        Class c18 = void.class;
        Class c19 = Class.class;
        System.out.println(c11);
        System.out.println(c12);
        System.out.println(c13);
        System.out.println(c14);
        System.out.println(c15);
        System.out.println(c16);
        System.out.println(c17);
        System.out.println(c18);
        System.out.println(c19);


    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class User {
    Long id;
    String name;
    Integer age;
}


@Data
@AllArgsConstructor
@ToString
class Student extends User {
    Long sId;

    public Student() {
        this.name = "学生";
    }
}

@Data
@AllArgsConstructor
@ToString
class Teacher extends User {

    Long tId;

    public Teacher() {
        this.name = "老师";
    }
}
