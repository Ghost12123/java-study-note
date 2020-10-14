package com.blank.study.algorithm;

/**
 * @author wudc
 * @date 2020/10/14 17:51
 */
public class Code1287 {
	/**
	 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
	 *
	 * 请你找到并返回这个整数
	 * 示例：
	 *
	 * 输入：arr = [1,2,2,6,6,6,6,7,10]
	 * 输出：6
	 */
	public int findSpecialInteger(int[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}
		int step = (int) Math.ceil(arr.length * 0.25);
		for (int i = 0; i < arr.length - step; i++) {
			if (arr[i] == arr[i + step]) {
				return arr[i];
			}
		}

		return arr[arr.length - step - 1];
	}
}
