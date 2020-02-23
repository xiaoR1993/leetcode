package 队列;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @Date 2020/2/22
 */
public class _347_前K个高频元素
{

	// 总结:仍然是使用对象结合优先级队列
	public List<Integer> topKFrequent(int[] nums, int k)
	{

		List<Integer> list = new ArrayList<>();

		for (int num : nums)
		{
			list.add(num);
		}

		Map<Integer, Integer> map = list
				.stream()
				.collect(Collectors.groupingBy(Function.identity()))
				.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));

		/**
		 * 思路:
		 * 		1.仍然选择到优先级队列求topN
		 */
		Queue<Obj> queue = new PriorityQueue<>(new Comparator<Obj>()
		{
			@Override
			public int compare(Obj o1, Obj o2)
			{
				return o1.count - o2.count;
			}
		});
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			Obj<Integer> obj = new Obj<>(entry.getKey(), entry.getValue());
			queue.offer(obj);
			if (queue.size() > k)
			{
				queue.poll();
			}
		}

		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty())
		{
			Obj<Integer> obj = queue.poll();
			result.add(obj.value);
		}
		Collections.reverse(result);
		return result;

	}

}
