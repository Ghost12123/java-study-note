package com.blank.study.algorithm;

import java.util.*;

/**
 * @author wudc
 * @date 2020/10/14 11:00
 */
public class Code322 {

	/**
	 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
	 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
	 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
	 * 所有的机场都用三个大写字母表示（机场代码）。假定所有机票至少存在一种合理的行程。
	 * 所有的机票必须都用一次 且 只能用一次。
	 *
	 * 输入
	 * [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
	 * 输出：
	 * ["JFK","MUC","LHR","SFO","SJC"]
	 */
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, List<String>> container = new LinkedHashMap<>();
		// 先将数据归置到key-value容器
		for (List<String> ticket : tickets) {
			List<String> values = new ArrayList<>();
			if (container.containsKey(ticket.get(0))) {
				values = container.get(ticket.get(0));
			}
			values.add(ticket.get(1));
			container.put(ticket.get(0), values);
		}
		// 遍历容器, 将容器内的value排序
		for (Map.Entry entry : container.entrySet()) {
			List<String> values = new ArrayList<>();
			if (entry.getValue() instanceof ArrayList<?>) {
				for (Object o : (List<?>) entry.getValue()) {
					values.add(String.class.cast(o));
				}
			}
			Collections.sort(values);
			container.put(entry.getKey().toString(), values);
		}
		// 定义返回值
		List<String> result = new LinkedList<>();
		visit(container, "JFK", result);
		return result;
	}

	public void visit(Map<String, List<String>> container, String key, List<String> result) {
		List<String> values = container.get(key);
		while (values != null && values.size() > 0) {
			String nextKey = values.get(0);
			values.remove(0);
			visit(container, nextKey, result);
		}
		result.add(0, key);
	}
}
