package com.blank.study.algorithm;

import java.util.TreeSet;

/**
 * @author wudc
 * @date 2020/10/15 9:40
 */
public class Code414 {

	/**
	 * 输出第三大
	 * 输入: [2, 2, 3, 1]
	 * 输出: 1
	 */
	public int thirdMax(int[] nums) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			treeSet.add(nums[i]);
			if (treeSet.size() > 3) {
				treeSet.pollFirst();
			}
		}
		if (treeSet.size() < 3) {
			return treeSet.pollLast();
		}
		return treeSet.pollFirst();
	}
}
