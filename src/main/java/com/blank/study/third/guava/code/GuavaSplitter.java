package com.blank.study.third.guava.code;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Guava Util Splitter 分割器
 * @author wudc
 * @date 2020/10/12 15:55
 */
public class GuavaSplitter {

	private static Pattern pattern = Pattern.compile("\\|");

	/**
	 * Splitter-on
	 * 通过分隔符创建一个Splitter对象并返回
	 * 1.Char和CharMather调用的是同一个方法：{@link Splitter#on(com.google.common.base.CharMatcher)}
	 * 2.Pattern和PatternString调用的是同一个方法：{@link Splitter#on(com.google.common.base.CommonPattern)}
	 */
	public static Splitter on(int type) {
		switch (type) {
			case 1:
				// Char
				char charSeparator = '+';
				return Splitter.on(charSeparator);
			case 2:
				// CharMatcher
				CharMatcher charMatcher = CharMatcher.whitespace();
				return Splitter.on(charMatcher);
			case 3:
				// String
				String stringSeparator = "++";
				return Splitter.on(stringSeparator);
			case 4:
				// Pattern
				return Splitter.on(pattern);
			case 5:
				// PatternString
				String pattern = "\\|";
				Splitter.onPattern(pattern);
			default:
				return Splitter.on(";");
		}
	}

	/**
	 * Splitter-split
	 * 通过分隔符进行切割
	 */
	public static void split(Splitter splitter, CharSequence charSequence, int type) {
		switch (type) {
			case 1:
				// List
				List<String> list = splitter.splitToList(charSequence);
				System.out.println(list);
				break;
			case 2:
				// Iterable
				Iterable<String> iterable = splitter.split(charSequence);
				for (String string : iterable) {
					System.out.print(String.format("%s ", string));
				}
				break;
			case 3:
				// Stream
				Stream<String> stream = splitter.splitToStream(charSequence);
				System.out.println(Arrays.toString(stream.toArray()));
				break;
			default:
				break;
		}
	}

	/**
	 * Splitter-whiteSpace
	 * 针对空格或空值的处理
	 * 第3种情况
	 */
	public static void handleWhiteSpaceOrNullValue(Splitter splitter, CharSequence charSequence, int type) {
		switch (type) {
			case 1:
				// 允许空值,最后剩下的只有非空值
				System.out.println(splitter.omitEmptyStrings().splitToList(charSequence));
				break;
			case 2:
				// 去除两边的空格,全部,不止去除一个
				System.out.println(splitter.trimResults().splitToList(charSequence));
				break;
			case 3:
				// 去除两边的值,全部,不止去除一个
				System.out.println(splitter.trimResults(CharMatcher.is('_')).splitToList(charSequence));
				break;
			default:
				break;
		}
	}

	/**
	 * joiner-MapSplitter
	 * 针对Map处理的Splitter内部类
	 * @param separator 这个是用来分割key和value的
	 */
	public static void withKeyValueSeparator(Splitter splitter, char separator, CharSequence charSequence) {
		Map<String, String> map = splitter.withKeyValueSeparator(separator).split(charSequence);
		System.out.println(map);
	}
}
