package com.haozz.dailylearn.dailylearn202001.dailylearn_20200105;

/**
 * leetcode https://leetcode-cn.com/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author: haozz
 * @date: 2020/1/5 22:00
 */
public class DailyLearn20200105 {


    /**
     * 这个解法是不对的
     * 对于1,2,7,9,1这样的可以执行成功
     * 但是对于2,1,1,2这样的就不行
     * 只考虑了每隔一个的情况，没有考虑到相隔多个的情况
     * @param nums
     * @return
     */
    public static int robError(int[] nums) {
        int result1 = 0;

        for (int i = 0; i < nums.length; i += 2) {
            result1 += nums[i];
        }

        int result2= 0;
        if(nums.length>1){
            for (int i = 1; i < nums.length; i+=2) {
                result2 += nums[i];
            }
            if(result2 > result1){
                result1 = result2;
            }
        }
        return result1;
    }

//    public static void main(String[] args) {
//        System.out.println(rob(new int[]{2,1,1,2}));
//    }


    /**
     * 官方解法：动态规划
     *
     * 【由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值】
     *
     * 考虑所有可能的抢劫方案过于困难。一个自然而然的想法是首先从最简单的情况开始。记：
     *
     * f(k) = 从前 k 个房屋中能抢劫到的最大数额，Ai = 第 i 个房屋的钱数。
     *
     * 首先看 n = 1 的情况，显然 f(1) = A1
     * 再看 n = 2，f(2) = max(A1,A2)
     * 对于 n = 3，有两个选项:
     *       抢第三个房子，将数额与第一个房子相加。
     *       不抢第三个房子，保持现有最大数额。
     *
     * 显然，你想选择数额更大的选项。于是，可以总结出公式：
     * f(k) = max(f(k – 2) + Ak,f(k-1))
     *
     * 我们选择 f(–1) = f(0) = 0 为初始情况，这将极大地简化代码。
     *
     * 答案为 f(n)。可以用一个数组来存储并计算结果。不过由于每一步你只需要前两个最大值，两个变量就足够用了。
     *
     * @param nums
     * @return
     */
    public int rob(int [] nums){
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
