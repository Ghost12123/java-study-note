package com.blank.study.algorithm;

import java.util.Arrays;

/**
 * @author wudc
 * @date 2020/10/18 14:59
 */
public class Code5545 {
    /**
     * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
     * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
     * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
     * 示例 1：
     * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
     * 输出：34
     * 解释：你可以选中所有球员。
     * <p>
     * 示例 2：
     * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
     * 输出：16
     * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        // 先按年龄排序，再按分数排序，最后只需要分数
        int[][] temp = new int[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            temp[i][0] = ages[i];
            temp[i][1] = scores[i];
        }
        Arrays.sort(temp, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 获取最长的上升序列
        int max = -1;
        int[] dp = new int[ages.length + 1];
        dp[0] = temp[0][1];
        for (int i = 1; i < ages.length; i++) {
            dp[i] = temp[i][1];
            for (int j = 0; j < i; j++) {
                if (temp[j][1] <= temp[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + temp[i][1]);
                }
            }
        }
        for (int i = 0; i < ages.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
