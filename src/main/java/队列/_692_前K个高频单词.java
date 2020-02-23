package 队列;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/top-k-frequent-words/
 * @Date 2020/2/22
 */
public class _692_前K个高频单词
{

	/**
	 * 使用了优先级队列和Map
	 * @param words
	 * @param k
	 * @return
	 */
	public List<String> topKFrequent(String[] words, int k)
	{
		/**
		 * 思路:
		 * 		默认使用Map加优先级队列实现
		 */
		List<String> list = new ArrayList<>();
		for (String str : words)
		{
			list.add(str);
		}

		Map<String, Integer> map = list
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
				Obj<String> obj1 = o1;
				Obj<String> obj2 = o2;
				// 外面不用 因为外面是取反
				// 然后这里也是写 认为count谁大就是谁大
				int cmp = obj1.count - obj2.count;
				if (cmp == 0)
				{
//					cmp = obj1.value.compareTo(obj2.value);
					// 因为要求是按照字典的升序 外面是最小堆
					// 因此题目的要求就是要认为 字典数字比较小的 实质是比较大的
					// 外面取了反 因此这里也要取反
					// 这里实质是认为字段小则大
					// 所以这里的实质上是
					cmp = -(obj1.value.compareTo(obj2.value));
//					cmp = obj2.value.compareTo(obj1.value);
				}
				return cmp;
			}
		});

		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			Obj<String> obj = new Obj<>(entry.getKey(), entry.getValue());
			queue.offer(obj);

			if (queue.size() > k)
			{
				queue.poll();
			}
		}

		List<String> result = new ArrayList<>();
		while (!queue.isEmpty())
		{
			Obj<String> obj = queue.poll();
			result.add(obj.value);
		}
		Collections.reverse(result);
		return result;

	}

}


