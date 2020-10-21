package com.blank.study.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wudc
 * @date 2020/10/22 0:36
 */
public class Code763 {

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
     * 示例 1：
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     */
    public List<Integer> partitionLabels(String S) {
        // 记录每个字母最后一次出现位置
        int[] charBooks = new int[26];
        for (int i = 0; i < S.length(); i++) {
            // 未记录过的, 记录最后出现的位置
            if (charBooks[S.charAt(i) - 'a'] == 0) {
                charBooks[S.charAt(i) - 'a'] = S.lastIndexOf(S.charAt(i));
            }
        }

        // 记录分片长度结果
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            // 找到该字符最后出现的位置
            int end = charBooks[S.charAt(i) - 'a'];
            // 区间内，遍历每个字符, 如果超过end, 则end延长
            for (int j = i + 1; j < end; j++) {
                if (charBooks[S.charAt(j) - 'a'] > end) {
                    end = charBooks[S.charAt(j) - 'a'];
                }
            }
            // 记录分片结果
            ans.add(end - i + 1);
            i = end;
        }

        return ans;
    }

    public static void main(String[] args) {
        Code763 code763 = new Code763();
//        String S = "ababcbacadefegdehijhklij";
//        String S = "caedbdedda";
//        String S = "aebbedaddc";
//        System.out.println(code763.partitionLabels(S));

        int[] charBooks = new int[26];
        System.out.println(Arrays.toString(charBooks));
    }
}
