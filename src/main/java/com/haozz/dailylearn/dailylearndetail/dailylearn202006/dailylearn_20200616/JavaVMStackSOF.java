package com.haozz.dailylearn.dailylearndetail.dailylearn202006.dailylearn_20200616;

/**
 * 测试java栈溢出
 * <p>
 * 设置JVM启动参数：  -Xss160k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }


}
