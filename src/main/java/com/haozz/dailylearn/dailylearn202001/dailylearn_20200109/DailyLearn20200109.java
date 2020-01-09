package com.haozz.dailylearn.dailylearn202001.dailylearn_20200109;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * <p>
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 * @author: haozz
 * @date: 2020/1/9 23:06
 */
public class DailyLearn20200109 {

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //最终结果
        int result = 1;

        //临时结果
        int tempResult = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                //遇到递增时，临时结果+1
                tempResult++;

                //如果临时结果大于最终结果，把临时结果赋值给最终结果
                if (tempResult > result) {
                    result = tempResult;
                }
            } else {
                //遇到不递增的，把临时结果赋值给最终结果
                if (tempResult > result) {
                    result = tempResult;
                }
                tempResult = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{3, 0, 6, 2, 4, 7, 0, 0}));
    }


    /**
     * 评论区的解法，思路和上面一样，但是更加精简
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS1(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int ans = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                count = 1;
            }
            ans = count > ans ? count : ans;
        }
        return ans;
    }
}
