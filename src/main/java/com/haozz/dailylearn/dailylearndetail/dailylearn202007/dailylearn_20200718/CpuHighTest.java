package com.haozz.dailylearn.dailylearndetail.dailylearn202007.dailylearn_20200718;

import com.haozz.dailylearn.dailylearndetail.dailylearn202007.dailylearn_20200704.User;

/**
 * @author haozhezhe@yunquna.com
 * @date 15:59 2020-07-18
 */
public class CpuHighTest {

    public static final int initData = 666;
    public static User user = new User();

    public int compute() {  //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    /**
     * 运行此代码，cpu会飙高
     * @param args
     */
    public static void main(String[] args) {
        CpuHighTest math = new CpuHighTest();
        while (true) {
            math.compute();
        }
    }

    /**
     * 使用jstack查看CPU标高之后的信息
     *
     * 1.首先获取CPU标高的java程序的进程PID，（jps或任务管理器都可以看到）
     * 2.使用命令top -p PID显示该进程的内存情况
     * 3.按H获取该进程下每个线程的内存情况
     * 4.找到内存和cpu占用最高的线程tid，比如19664
     * 5.转为十六进制得到 0x4cd0，此为线程id的十六进制表示
     * 6.执行 jstack 19663|grep -A 10 4cd0，得到线程堆栈信息中 4cd0 这个线程所在行的后面10行，从堆栈中可以发现导致cpu飙高的调用方法
     * 7.查看对应的堆栈信息找出可能存在问题的代码
     */
}
