package com.haozz.dailylearn.dailylearn_20191203;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetCode 独一无二的出现次数
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * <p>
 * <p>
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author: haozz
 * @date: 2019/12/3 21:57
 */
public class DailyLearn20191203 {

    /**
     * 我的解答：
     * 现将arr中的数字和出现的次数组成map
     * 然后对map的values进行判断，如果每个数出现的次数是独一无二的话，那么其组成的set应该和其大小是一致的
     * <p>
     * 例如:1,1,2    组成的map的values会是2,1,  打成set之后也是2,1  返回true
     * 在例如1,2,3   组成的map的values会是1,1,1    打成set之后是1，返回false
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.values().size();
    }


    /**
     * 某网友的答案
     * <p>
     * map的merge方法接受三个参数
     * 第一个为key
     * 第二个为key不存在时初始化的value值
     * 第三个为执行的操作
     * 也就是将存在的key对应的oldValue和传入的value执行操作，赋值给新的key
     * 第三个参数要求是函数式接口
     */
    public static boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }

        int i1 = map.values().stream().distinct().mapToInt(i -> i).sum();
        int i2 = map.values().stream().mapToInt(i -> i).sum();
        return i1 == i2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(uniqueOccurrences1(arr));
    }
}
