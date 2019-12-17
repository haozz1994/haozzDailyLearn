package com.haozz.dailylearn.dailylearn201912.dailylearn_20191216;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode https://leetcode-cn.com/problems/self-dividing-numbers/
 * <p>
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * @author haozhezhe@yunquna.com
 * @date 11:27 2019/12/16
 */
public class DailyLearn20191216 {


    /**
     * 穷举法
     * 复杂度分析
     *
     * 时间复杂度：O(D)。DD 是在区间[L,R] 里的整数数。
     * 空间复杂度：O(D)，使用了一个数组来存放结果。
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isZichushu(i)) {
                list.add(i);
            }
        }


        return list;
    }

    private boolean isZichushu(int n) {
        String nStr = n + "";
        if (nStr.indexOf("0") > -1) {
            return false;
        }
        for (String s : nStr.split("")) {
            if (n % Integer.parseInt(s) != 0) {
                return false;
            }
        }
        return true;
    }




}
