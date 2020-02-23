package 队列;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * @Date 2020/2/22
 */
public class _451_根据字符出现频率排序
{

	/**
	 * 使用了map以及优先级队列(最小堆)
	 *
	 * @param s
	 * @return
	 */
	public String frequencySort(String s)
	{
		List<String> list = new ArrayList<>();
		for (char c : s.toCharArray())
		{
			list.add("" + c);

		}
		Map<String, Integer> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity()))
				.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));

		Queue<Obj> queue = new PriorityQueue<>();

		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			Obj<String> obj = new Obj<String>(entry.getKey(), entry.getValue());
			queue.add(obj);
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty())
		{
			Obj obj = queue.poll();
			for (int i = 0; i < obj.count; i++)
			{
				sb.append(obj.value);

			}
		}

		return sb.toString();

	}

//	private static class Obj implements Comparable<Obj>
//	{
//		String value;
//		Integer count;
//
//		public Obj(String value, Integer count)
//		{
//			this.value = value;
//			this.count = count;
//		}
//
//		@Override
//		public int compareTo(Obj that)
//		{
//			return that.count - this.count;
//		}
//	}

}
