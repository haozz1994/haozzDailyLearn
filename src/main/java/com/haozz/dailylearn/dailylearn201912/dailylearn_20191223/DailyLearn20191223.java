package com.haozz.dailylearn.dailylearn201912.dailylearn_20191223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode   https://leetcode-cn.com/problems/replace-words/
 * <p>
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 *
 * @author haozhezhe@yunquna.com
 * @date 13:20 2019/12/23
 */
public class DailyLearn20191223 {

    /**
     * 没有考虑：如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     */
    public static String replaceWords(List<String> dict, String sentence) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        for (String s : list) {
            boolean exist = false;
            for (String s1 : dict) {
                if (s.indexOf(s1) > -1) {
                    exist = true;
                    result.add(s1);
                }
            }
            if(!exist){
                result.add(s);
            }
        }
        return String.join(" ", result);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        replaceWords(list,
        "the cattle was rattled by the battery");

    }
}
