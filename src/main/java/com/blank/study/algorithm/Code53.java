package com.blank.study.algorithm;

/**
 * @author wudc
 * @date 2020/10/19 15:07
 */
public class Code53 {

	/**
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 *
	 * 示例:
	 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
	 * 输出: 6
	 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 *
	 *
	 *
	 * 法1：长度9、8、7...1暴力破解 超时
	 * 法2：如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
	 *      如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
	 */
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum > 0) {
				sum += nums[i];
			} else {
				sum = nums[i];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
