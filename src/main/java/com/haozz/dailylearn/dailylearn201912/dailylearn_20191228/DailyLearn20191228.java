package com.haozz.dailylearn.dailylearn201912.dailylearn_20191228;

/**
 * leetcode https://leetcode-cn.com/problems/student-attendance-record-i/
 * <p>
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 *
 * @author
 * @date 2019/12/28 9:18
 **/
public class DailyLearn20191228 {

    /**
     * 方法 1： 简单的解法 [Accepted]
     * 解决这个问题最简单的方法就是同济字符串中 A 的数目并检查 LLL 是否是给定字符串的一个子串。如果 A 的数目比 2 少且 LLL 不是给定字符串的一个子串，那么返回 true，否则返回 false。
     * Java 中indexOf 方法可以用来检查一个串是否是另一个串的子串。如果找不到子串，那么返回 -1，否则返回这个字符串第一次出现的位置。
     *
     * 时间复杂度： O(n)。遍历字符串一遍和 indexOf 需要花费 O(n) 的时间。
     * 空间复杂度： O(1)。只使用了常数的空间。
     */
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
            }
        }
        return countA <= 1 && s.indexOf("LLL") == -1;
    }


    /**
     * 方法 2：优化的解法 [Accepted]
     * 上述方法的一个优化是当 A 的数目有 2 个的时候就中断循环。
     *
     * 时间复杂度： O(n)。遍历字符串一次和 indexOf 方法需要花费 O(n) 的时间。
     * 空间复杂度： O(1)。只使用了常数的空间。
     */
    public boolean checkRecord2(String s) {
        int countA = 0;
        for (int i = 0; i < s.length() && countA <= 1; i++) {
            if (s.charAt(i) == 'A') {
                countA++;
            }
        }
        return countA <= 1 && s.indexOf("LLL") == -1;
    }

    /**
     * 方法 3：不需要 indexOf 的单遍循环方法 [Accepted]
     * 我们可以遍历这个字符串一次不使用 indexOf 来解决这个问题。在单遍循环中，我们统计 A 的数目并检查子字符串 LLL 是否是一个子串。
     *
     * 时间复杂度： O(n)O(n)。单遍循环的上限是字符串的长度。
     * 空间复杂度： O(1)O(1)。只使用了常数级别的空间。
     */
    public boolean checkRecord3(String s) {
        int countA = 0;
        for (int i = 0; i < s.length() && countA <= 1; i++) {
            if (s.charAt(i) == 'A') {
                countA++;
            }
            if (i > 1 && s.charAt(i - 2) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i) == 'L') {
                return false;
            }
        }
        return countA <= 1;
    }

    /**
     * 方法4：正则表达式
     *
     * 一个有趣的解法是使用正则表达式去匹配字符串。Java 提供了 java.util.regex 包来做正则表达式的模式匹配。一个正则表达式是一个特殊的字符串序列，可以帮助你匹配或者找到其他字符串或者字符串集合，它使用一种特殊的语法模式。
     *
     * 下面是此解法中用到的正则表达式符号：
     *
     * . : 匹配任何除了换行以外的单个字符。
     *
     * * : 匹配 0 个或者 大于 0 个 * 符号前面的表达式。
     *
     * .* : 匹配任何字符串
     *
     * a|b : 要么匹配 a 要么匹配 b
     * matches 方法被用来检查是否有字符串匹配我们给定的正则表达式。
     *
     * 包含 2 个或更多 A 的正则表达式为 .*A.*A.*，包含子字符串 LLL 对应的正则表达式为 .*LLL.*。我们可以把两个正则表达式用 ∣ 形成一个正则表达式，来表示或者包含超过 1 个 A 或者包含 3 个连续的 L 的字符串。那么正则表达就变成 .*(A.*A|LLL).*。只有当字符串不能匹配正则表达式的时候我们返回 true。
     *
     * 时间复杂度： O(n)。 matches 方法花费的时间最多为 O(n)。
     *
     * 空间复杂度： O(1)。不需要使用额外的空间。
     *
     */
    public boolean checkRecord4(String s){
        return !s.matches(".*(A.*A|LLL).*");
    }
}
