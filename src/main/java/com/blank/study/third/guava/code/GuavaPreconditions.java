package com.blank.study.third.guava.code;

import com.google.common.base.Preconditions;

/**
 * Guava Util Preconditions 断言
 * 不需要实例化, 是final class
 * @author wudc
 * @date 2020/10/14 12:10
 */
public class GuavaPreconditions {

	/**
	 * Preconditions-checkArgument
	 * 判断参数, 抛异常：IllegalArgumentException
	 */
	public static void checkArgument(String argument) {
		// 这里就不一一列举了, 要用的时候根据需求看看参数使用哪种就行
		Preconditions.checkArgument(!"guava".equals(argument), "这个参数不合法");
	}

	/**
	 * Preconditions-checkNotNull
	 * 判断参数, 抛异常：NullPointerException
	 * 注意：这里不能识别出空白字符串是空串,即argument=""可以通过断言
	 */
	public static void checkNotNull(String argument) {
		// 这里就不一一列举了, 要用的时候根据需求看看参数使用哪种就行
		Preconditions.checkNotNull(argument, "这个参数不能为空");
	}

	/**
	 * Preconditions-checkState
	 * 判断参数, 抛异常：IllegalStateException
	 */
	public static void checkState(String argument) {
		// 这里就不一一列举了, 要用的时候根据需求看看参数使用哪种就行
		Preconditions.checkState("suc".equals(argument), "这个参数状态非法");
	}

	/**
	 * Preconditions-checkElementIndex
	 * 判断下标是否越界, 抛异常：IndexOutOfBoundsException
	 */
	public static void checkElementIndex(int index, int size) {
		Preconditions.checkElementIndex(index, size, "这个下标非法越界");
		Preconditions.checkPositionIndex(index, size, "这个下标非法越界");
	}


}
