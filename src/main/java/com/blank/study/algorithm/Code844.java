package com.blank.study.algorithm;

/**
 * @author wudc
 * @date 2020/10/19 12:53
 */
public class Code844 {

	/**
	 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
	 * 注意：如果对空文本输入退格字符，文本继续为空。
	 * 示例 1：
	 * 输入：S = "ab#c", T = "ad#c"
	 * 输出：true
	 * 解释：S 和 T 都会变成 “ac”。
	 */
	public boolean backspaceCompare(String S, String T) {
		StringBuilder SBuilder = new StringBuilder();
		StringBuilder TBuilder = new StringBuilder();
		// 扫描器，代表当前退格数
		int count = 0;
		// 尾扫描
		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) != '#') {
				if (count == 0) {
					SBuilder.append(S.charAt(i));
				} else {
					count--;
				}
			} else {
				count++;
			}
		}
		count = 0;
		for (int i = T.length() - 1; i >= 0; i--) {
			if (T.charAt(i) != '#') {
				if (count == 0) {
					TBuilder.append(T.charAt(i));
				} else {
					count--;
				}
			} else {
				count++;
			}
		}

		return SBuilder.toString().equals(TBuilder.toString());
	}

	public static void main(String[] args) {
		Code844 code844 = new Code844();
		String S = "ab##";
		String T = "c#d#";
		System.out.println(code844.backspaceCompare(S, T));
	}
}
