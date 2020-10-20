package com.blank.study.algorithm;

/**
 * @author wudc
 * @date 2020/10/21 1:14
 */
public class Code925 {

    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     * 示例 1：
     * 输入：name = "alex", typed = "aaleex"
     * 输出：true
     * 解释：'alex' 中的 'a' 和 'e' 被长按。
     */
    public boolean isLongPressedName(String name, String typed) {
        // 双指针遍历
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            // 相等
            if (name.charAt(i) == typed.charAt(j)) {
                // i继续遍历
                i++;
                // 判断name[i]和name[i-1]是否一样, 一样的话j继续遍历, 否则j一直遍历到不一致的字符
                if (i == name.length() || name.charAt(i) != name.charAt(i - 1)) {
                    while (j + 1 < typed.length() && typed.charAt(j) == typed.charAt(j + 1)) {
                        j++;
                    }
                }
                j++;
            } else {
                return false;
            }
        }
        return i == name.length() && j == typed.length();
    }

    public static void main(String[] args) {
        Code925 code925 = new Code925();
        String name = "saeed";
        String typed = "ssaaedd";
//        String name = "alex";
//        String typed = "aaleelx";
        System.out.println(code925.isLongPressedName(name, typed));
    }
}
