package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200419;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 通过反射获取Unsafe类实践
 *
 * @author: haozz
 * @date: 2020/4/19 21:02
 */
public class TestUnsafeByReflect {

    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            //设置为可存取
            field.setAccessible(true);

            //获取该变量的值
            unsafe = (Unsafe) field.get(null);

            //获取state在TestUnsafe中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }

    }

    public static void main(String[] args) {
        TestUnsafeByReflect test = new TestUnsafeByReflect();

        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);

    }


}
