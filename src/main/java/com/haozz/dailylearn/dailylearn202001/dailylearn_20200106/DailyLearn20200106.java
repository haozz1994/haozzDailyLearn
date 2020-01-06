package com.haozz.dailylearn.dailylearn202001.dailylearn_20200106;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/buddy-strings/
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 * <p>
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 * <p>
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 * <p>
 * 输入： A = "", B = "aa"
 * 输出： false
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 *
 * @author: haozz
 * @date: 2020/1/6 23:00
 */
public class DailyLearn20200106 {

    public static void main(String[] args) {
        buddyStrings("aa", "aa");
    }

    /**
     * 这个方法 时间复杂度太高
     * @param A
     * @param B
     * @return
     */
    public static boolean buddyStrings(String A, String B) {
        //长度不相等，不行
        if (A.length() != B.length()) {
            return false;
        }

        //只有一位或者是空字符串，不行
        if (A.length() == 0 || A.length() == 1) {
            return false;
        }

        //存储不相等字符的下标
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                list.add(i);
            }
        }

        //有超过两个字符不一样
        if (list.size() > 2) {
            return false;
        }

        //如果刚好只有两位不一样，判断这两位是否互相相等
        if (list.size() == 2) {
            return A.charAt(list.get(0)) == B.charAt(list.get(1)) && A.charAt(list.get(1)) == B.charAt(list.get(0));
        }

        //所有位都一样，这个逻辑比较复杂。需要判断A中是否有相同的字母，比如两个abc不满足题意，但是aab是满足的
        if (list.size() == 0) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length(); i++) {
                if (!map.containsKey(A.charAt(i))) {
                    map.put(A.charAt(i), 1);
                } else {
                    map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
                }
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 官方解法
     *
     * 方法：情况列举
     * 思路
     *
     * 如果 A[i] == B[i]，我们就说 i 是匹配的，否则称 i 是不匹配的。亲密字符串几乎是完全匹配的，因为一次交换只会影响到两个索引。
     *
     * 如果交换 A[i] 和 A[j] 可以证明 A 和 B 是亲密字符串，那么就有 A[i] == B[j] 以及 A[j] == B[i]。 这意味着在 A[i], A[j], B[i], B[j] 这四个自由变量中，只存在两种情况：A[i] == A[j] 或 A[i] != A[j]
     *
     * 算法
     *
     * 让我们来看看这些情况。
     *
     * 在 A[i] == A[j] == B[i] == B[j] 的情况下，字符串 A 与 B 相等。因此，如果 A == B，我们应当检查每个索引 i 以寻找具有相同值的两个匹配。
     *
     * 在 A[i] == B[j], A[j] == B[i], (A[i] != A[j]) 的情况下，其余索引是相匹配的。所以如果 A 和 B 只有两个不匹配的索引（记作 i 和 j），我们应该检查并确保等式 A[i] == B[j] 和 A[j] == B[i] 成立。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(N)，其中 N 是 A 和 B 的长度。
     *
     * 空间复杂度：O(1)。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean buddyStrings1111(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }


}
