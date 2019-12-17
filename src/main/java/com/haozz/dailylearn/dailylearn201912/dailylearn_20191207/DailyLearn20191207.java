package com.haozz.dailylearn.dailylearn201912.dailylearn_20191207;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetCode 重塑矩阵 https://leetcode-cn.com/problems/reshape-the-matrix/
 *
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * 注意：
 *
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 * @author: haozz
 * @date: 2019/12/7 22:47
 */
public class DailyLearn20191207 {


    /**
     * 方法一 使用队列
     * <p>
     * 最简单的方法是通过以行方式读取元素来提取给定矩阵的所有元素。在此实现中，我们使用队列来放置提取的元素。然后，我们可以取出以串行顺序形成的队列元素，并再次按行逐行排列所得到的所需矩阵中的元素。
     * <p>
     * 如果原始矩阵中的元素数量不等于所得矩阵中的元素数量，则不可能形成所得矩阵。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(m*n)。我们遍历 m * n元素两次。这里，m 和 n 分别表示给定矩阵的行数和列数。
     * 空间复杂度：O(m∗n)。形成的队列大小为 m*n 。
     */
    public int[][] matrixReshape1(int nums[][], int r, int c) {
        int size = nums.length * nums[0].length;
        if (r * c != size) {
            return nums;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int[] num : nums) {
            for (int i : num) {
                queue.add(i);
            }
        }

        int result[][] = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = queue.remove();
            }
        }
        return result;
    }

    /**
     * 方法二 不用额外空间 [通过]
     * <p>
     * 我们不必像在暴力方法中那样不必要地使用队列，而是可以在逐行顺序迭代给定矩阵的同时，直接将数字放在结果矩阵中。在将数字放入结果数组时，我们固定一个特定的行，并继续增加列数，直到我们到达cc指示的所需列的末尾。此时，我们通过递增来更新行索引，并将列索引重置为从0开始。因此，我们可以节省队列消耗的空间，以便存储只需要复制到新数组中的数据。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(m∗n)。我们只遍历整个矩阵 m∗n。这里，m 和 n 指的是给定矩阵中的行数和列数。
     * 空间复杂度：O(m∗n)。使用大小为 m∗n 的结果矩阵。
     */
    public int[][] matrixReshape2(int nums[][], int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }

        int result[][] = new int[r][c];

        int row = 0;
        int col = 0;
        for (int[] num : nums) {
            for (int i : num) {
                result[row][col] = i;
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

    /**
     * 方法三 除法和取模 [通过]
     * 算法
     *
     * 在上一种方法中，我们需要跟踪我们何时到达结果矩阵的列的末尾，并且需要通过每次检查当前索引来更新当前行和列号以放置提取的元素。我们可以利用数学来帮助解决，而不是在每一步都进行限制性检查。
     *
     * 这种方法背后的想法如下。你知道二维数组是如何存储在主存中的（本质上是一维）吗？它仅在内部表示为一维阵列。元素nums [i] [j]nums[i][j] numsnums 数组通过使用以下形式的索引以一维数组的形式表示：$ nums [n * i + j] ，其中，其中 m 是给定矩阵中的列数。以相反的顺序查看相同的内容，同时将元素放在结果矩阵中的元素中，我们可以使用是给定矩阵中的列数。以相反的顺序查看相同的内容，同时将元素放在结果矩阵中的元素中，我们可以使用 count 变量，该变量对于遍历的每个元素都会递增，就像我们将元素放在一维中一样结果数组。但是，要将变量，该变量对于遍历的每个元素都会递增，就像我们将元素放在一维中一样结果数组。但是，要将 count 转换回列数为转换回列数为 c 的二维矩阵索引，我们可以获得的二维矩阵索引，我们可以获得 res [count / c] [count \％c] 的索引，其中的索引，其中 count / c 是行号和是行号和 count \％c $是列数字。因此，我们可以节省每一步所需的额外检查。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(m∗n)。我们只遍历整个矩阵 m*n 。这里，m 和 n 指的是给定矩阵中的行数和列数。
     *
     * 空间复杂度：O(m∗n)。使用大小为 m*n 的矩阵存储结果。
     */
    public int[][] matrixReshape3(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length) {
            return nums;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }
}
