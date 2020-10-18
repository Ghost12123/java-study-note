package com.blank.study.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wudc
 * @date 2020/10/18 12:47
 */
public class Code5543 {

    /**
     * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
     * 子字符串 是字符串中的一个连续字符序列。
     * 示例 1：
     * 输入：s = "aa"
     * 输出：0
     * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> container = new HashMap<>();
        // 遍历一遍, 记录每个字符出现, 以及出现的位置
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            List<Integer> values = new ArrayList<>();
            if (container.containsKey(ch)) {
                values = container.get(ch);
            }
            values.add(i);
            container.put(ch, values);
        }
        int max = -1;
        // 遍历容器，如果当前字符下标多于2个，计算最长长度
        for (Map.Entry<Character, List<Integer>> entry : container.entrySet()) {
            if (entry.getValue().size() >= 2) {
                max = Math.max(max, entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0) - 1);
            }
        }
        return max;
    }
}
