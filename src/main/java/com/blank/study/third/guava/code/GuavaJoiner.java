package com.blank.study.third.guava.code;

import com.blank.study.third.guava.util.ObjectCheckUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Guava Util Joiner 连接器
 * @author wudc
 * @date 2020/10/12 11:55
 */
public class GuavaJoiner {

	/**
	 * Joiner-on
	 * 通过分隔符创建一个Joiner对象并返回
	 */
	public static <T extends Object> Joiner on(T separator) {
		ObjectCheckUtil.checkNotNull(separator);
		return Joiner.on(String.valueOf(separator));
	}

	/**
	 * Joiner-appendTo
	 * 追加元素
	 * 整体来就分两种：一种Appendable，另一种StringBuilder。这里就列举Appendable实现就行了
	 * 其实看完源码可以发现： 数组、Iterable、多参数真正调用的方法是 {@link Joiner#appendTo(java.lang.Appendable, java.util.Iterator)}
	 */
	public static <T extends Appendable> T appendTo(T appendable, Joiner joiner, int type) throws IOException {
		switch (type) {
			case 1:
				// 数组
				Object[] objects = new Object[]{"google", "java", "guava"};
				return joiner.appendTo(appendable, objects);
			case 2:
				// Iterable:这里用List举例
				List<String> list1 = Arrays.asList("google", "java", "guava");
				return joiner.appendTo(appendable, list1);
			case 3:
				// 多参数:这里至少有两个参数
				Object obj1 = "google", obj2 = "java", obj3 = "guava";
				return joiner.appendTo(appendable, obj1, obj2, obj3);
			case 4:
				// Iterator:这里用List的iterator举例
				List<String> list2 = Arrays.asList("google", "java", "guava");
				return joiner.appendTo(appendable, list2.iterator());
			default:
				return null;
		}
	}

	/**
	 * joiner-join
	 * 追加元素
	 * 可以看做是Joiner-appendTo里面的StringBuilder一种实现，最终调用的方法是 {@link Joiner#join(java.util.Iterator)}
	 */
	public static String join(Joiner joiner, int type) {
		switch (type) {
			case 1:
				// 数组
				Object[] objects = new Object[]{"google", "java", "guava"};
				return joiner.join(objects);
			case 2:
				// Iterable:这里用List举例
				List<String> list1 = Arrays.asList("google", "java", "guava");
				return joiner.join(list1);
			case 3:
				// 多参数:这里至少有两个参数
				Object obj1 = "google", obj2 = "java", obj3 = "guava";
				return joiner.join(obj1, obj2, obj3);
			case 4:
				// Iterator:这里用List的iterator举例
				List<String> list2 = Arrays.asList("google", "java", "guava");
				return joiner.join(list2.iterator());
			default:
				return null;
		}
	}

	/**
	 * joiner-null
	 * 对空值的处理
	 */
	public static String handleNullValue(Joiner joiner, int type) {
		Object obj1 = "google", obj2 = null, obj3 = "guava";
		switch (type) {
			case 1:
				// 跳过空值
				return joiner.skipNulls().join(obj1, obj2, obj3);
			case 2:
				// 将空值替换某个值
				String replaceValue = "null";
				return joiner.useForNull(replaceValue).join(obj1, obj2, obj3);
			default:
				return joiner.join(obj1, obj2, obj3);
		}
	}

	/**
	 * joiner-MapJoiner
	 * 针对Map处理的Joiner内部类
	 * 这里就列举StringBuilder的一个例子就好了，其他类似的
	 */
	public static StringBuilder withKeyValueSeparator(Joiner joiner, String separator, StringBuilder stringBuilder) {
		Map<String, String> map = ImmutableMap.of("id", "001", "name", "google");
		// 数组
		Object[] objects = new Object[]{"google", "java", "guava"};
		return joiner.withKeyValueSeparator(separator).appendTo(stringBuilder, map);
	}
}
