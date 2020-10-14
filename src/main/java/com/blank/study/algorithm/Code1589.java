package com.blank.study.algorithm;

import java.util.Arrays;

/**
 * @author wudc
 * @date 2020/10/14 15:27
 */
public class Code1589 {
	/**
	 * 有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。
	 * 第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
	 * 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。
	 *
	 * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
	 *
	 * 示例 1：
	 * 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
	 * 输出：19
	 * 解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
	 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
	 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
	 * 总和为：8 + 3 = 11。
	 * 一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
	 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
	 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
	 * 总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
	 */
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		int num = (int) 1e9 + 7;
		int[] times = new int[nums.length + 1];

		// 计算查询区间出现的值
		for (int i = 0; i < requests.length; i++) {
			times[requests[i][0]]++;
			times[requests[i][1] + 1]--;
		}
		for (int i = 0; i < nums.length; i++) {
			times[i + 1] += times[i];
		}

		// 排序:降序
		Arrays.sort(times);
		// 排序:升序
		Arrays.sort(nums);

		// 计算结果
		long sum = 0;
		for (int i = nums.length + 1; i >= 1 && times[i] > 0; i--) {
			sum += (long) times[i] * nums[i - 1];
			sum %= num;
		}
		return (int) sum;
	}

}
