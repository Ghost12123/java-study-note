package com.blank.study.algorithm;

/**
 * @author wudc
 * @date 2020/10/22 16:22
 */
public class Code752 {

	/**
	 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
	 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
	 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
	 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
	 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
	 * 示例 1:
	 *
	 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
	 * 输出：6
	 * 解释：
	 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
	 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
	 * 因为当拨动到 "0102" 时这个锁就会被锁定。
	 *
	 * 0000 -> 上下转 * 4 = 8种可能
	 * (1)1000 9000 判断下是否dead, 以及不回头
	 *   (1.1)1000 -> 2000 1100 ... 1900 1010 1090 1001 1009
	 *     (1.1.2) 1100 -> 2100 ....
	 *       (1.1.2.x) 1200 ->1201
	 * ...
	 * (4)0001 0009
	 */
	public int openLock(String[] deadends, String target) {


		return -1;
	}

	/**
	 * 获取某位上能够拨转后的结果
	 * @param nums
	 * @param index
	 * @return
	 */
	public String[] getTwoNums(String nums, int index) {
		String[] ans = new String[2];

		if (nums.charAt(index) >= '1' && nums.charAt(index) <= '8') {
			// 处理1-8
			ans[0] = nums.substring(0, index) + ((char) (nums.charAt(index) - 1)) + nums.substring(index + 1);
			ans[1] = nums.substring(0, index) + ((char) (nums.charAt(index) + 1)) + nums.substring(index + 1);
		} else if (nums.charAt(index) == '0') {
			// 处理0
			ans[0] = nums.substring(0, index) + "9" + nums.substring(index + 1);
			ans[1] = nums.substring(0, index) + "1" + nums.substring(index + 1);
		} else {
			// 处理9
			ans[0] = nums.substring(0, index) + "8" + nums.substring(index + 1);
			ans[1] = nums.substring(0, index) + "0" + nums.substring(index + 1);
		}

		return ans;
	}

	/**
	 * public int openLock(String[] deadends, String target) {
	 *         Set<String> dead = new HashSet();
	 *         for (String d: deadends) dead.add(d);
	 *
	 *         Queue<String> queue = new LinkedList();
	 *         queue.offer("0000");
	 *         queue.offer(null);
	 *
	 *         Set<String> seen = new HashSet();
	 *         seen.add("0000");
	 *
	 *         int depth = 0;
	 *         while (!queue.isEmpty()) {
	 *             String node = queue.poll();
	 *             if (node == null) {
	 *                 depth++;
	 *                 if (queue.peek() != null)
	 *                     queue.offer(null);
	 *             } else if (node.equals(target)) {
	 *                 return depth;
	 *             } else if (!dead.contains(node)) {
	 *                 for (int i = 0; i < 4; ++i) {
	 *                     for (int d = -1; d <= 1; d += 2) {
	 *                         int y = ((node.charAt(i) - '0') + d + 10) % 10;
	 *                         String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
	 *                         if (!seen.contains(nei)) {
	 *                             seen.add(nei);
	 *                             queue.offer(nei);
	 *                         }
	 *                     }
	 *                 }
	 *             }
	 *         }
	 *         return -1;
	 *     }
	 */

	public static void main(String[] args) {
		String nums = "1111";
		int index = 0;
		String str = nums.substring(0, index) + ((char) (nums.charAt(index) - 1)) + nums.substring(index + 1);
		System.out.println(str);
	}
}
