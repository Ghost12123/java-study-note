package com.blank.study.algorithm;

import java.util.Arrays;

/**
 * @author wudc
 * @date 2020/10/19 23:26
 */
public class Code474 {

    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     * 示例 1：
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
     * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // 处理字符集，整理出0和1的数组
        int[] zeros = new int[strs.length], ones = new int[strs.length];
        Arrays.fill(zeros, 0);
        Arrays.fill(ones, 0);
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    zeros[i]++;
                } else {
                    ones[i]++;
                }
            }
        }

        // 动态规划：
        // 3个状态：（1）可选字符串 （2）0的背包容量 （3）1的背包容量
        // 产生价值 val[0,1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            // 处理边界值，这里巧妙设计，可以过滤掉边界值影响
            // 3维dp退化2维
            for (int zero = m; zero >= zeros[i - 1]; zero--) {
                for (int one = n; one >= ones[i - 1]; one--) {
                    dp[zero][one] = Math.max(dp[zero][one], dp[zero - zeros[i - 1]][one - ones[i - 1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Code474 code474 = new Code474();
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(code474.findMaxForm(strs, m, n));
    }
}
