package com.haozz.dailylearn.dailylearn_20191214;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * leetcode  https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * @author
 * @date 2019/12/14 10:08
 **/
public class DailyLearn20191214 {

    public static void main(String[] args) {
        String str1 = "((()))";
    }


    /**
     * 有效表达式的子表达式也是有效表达式
     * <p>
     * 从有效表达式中每次删除一个较小的子表达式，最终会剩下一个空字符串
     * <p>
     * 递归结构
     * <p>
     * 栈： 我们无法真正从内到外处理，因为我们对整体结构一无所知，但是，栈可以帮助我们递归的处理这种情况，即从外部到内部。
     * <p>
     * 思路：
     * 初始化一个栈
     * 遍历字符串，处理表达式的每个括号
     * 如果遇到开括号，将其推到栈上即可，稍后处理
     * 如果遇到闭括号，检查栈顶的元素，如果是相同类型的开括号，将其从栈中弹出即可，否则意味着表达式无效
     * 如果遍历完字符串之后栈中还有元素，意味着表达式无效
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1) 的推入和弹出操作。
     * 空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。例如 ((((((((((。
     *
     */
    public boolean isValid(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                //是开括号
                stack.push(aChar);//推入栈中
            } else {
                //不是开括号，取出栈顶元素，判断是否对应的开括号
                if(stack.isEmpty()){
                    return false;
                }
//                Character top = stack.peek();
                Character top = stack.pop();//此处不能用peek，因为不仅要判断，还要取出栈顶元素
                if (!Objects.equals(map.get(top), aChar)) {
                    return false;
                }
            }
        }

        if(!stack.empty()){
            return false;
        }

        return true;
    }


    /**
     * 以下为官方解答，与上面原理相同
     */
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public DailyLearn20191214() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValids(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}




