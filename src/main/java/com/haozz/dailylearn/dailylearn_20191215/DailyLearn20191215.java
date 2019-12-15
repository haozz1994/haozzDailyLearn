package com.haozz.dailylearn.dailylearn_20191215;

/**
 * leetcode   3的幂
 * https://leetcode-cn.com/problems/power-of-three/
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * <p>
 * 进阶：不适用循环或者递归
 *
 * @author: haozz
 * @date: 2019/12/15 20:58
 */
public class DailyLearn20191215 {

    /**
     * 方法一：循环迭代
     * 找出数字 n 是否是数字 b 的幂的一个简单方法是，n%3 只要余数为 0，就一直将 n 除以 b。
     * 该方法可以适用其他数字的判断整数次幂
     * <p>
     * 复杂度分析
     * 时间复杂度：O(\log_b(n))在我们的例子中是 O(\log n)。除数是用对数表示的。
     * 空间复杂度：O(1)，没有使用额外的空间。
     */
    public boolean isPowerOfThree(int n) {

        if (n < 1) {
            return false;
        }

        //n能整除3
        while (n % 3 == 0) {
            n = n / 3;
        }

        //n不能整除3的时候，判断n是不是1，因为1是3的0次幂
        return n == 1;
    }

    /**
     * 递归
     *
     * @return
     */
    public boolean isPowerOf3(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return n % 3 == 0 && isPowerOf3(n / 3);
    }


}
