package com.blank.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudc
 * @date 2020/10/15 15:31
 */
public class Code1380 {
	/**
	 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
	 * 幸运数是指矩阵中满足同时下列两个条件的元素：
	 * 在同一行的所有元素中最小
	 * 在同一列的所有元素中最大
	 *
	 * 输入：matrix = [
	 * [3,7,8],
	 * [9,11,13],
	 * [15,16,17]]
	 * 输出：[15]
	 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
	 */
	public List<Integer> luckyNumbers(int[][] matrix) {
		if (matrix.length == 0) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			int[] aMatrix = matrix[i];
			// 找到这行最小的位置
			int min = 0;
			for (int j = 1; j < matrix[0].length; j++) {
				if (aMatrix[j] < aMatrix[min]) {
					min = j;
				}
			}
			// 纵向探测最大值
			// 探测器,一有不对劲就跑
			boolean flag = false;
			// 向上
			for (int j = i; j >= 0; j--) {
				if (aMatrix[min] < matrix[j][min]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			// 向下
			for (int j = i; j < matrix.length; j++) {
				if (aMatrix[min] < matrix[j][min]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				list.add(aMatrix[min]);
			}
		}

		return list;
	}
}
