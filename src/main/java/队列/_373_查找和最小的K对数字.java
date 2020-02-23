package 队列;

import java.util.*;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * @Date 2020/2/22
 */
public class _373_查找和最小的K对数字
{
	// 总结:使用了优先级队列结合对象
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
	{
		/**
		 * 思路:
		 * 		1.还是按照优先级队列来实现
		 */
		// 不做优化
		Queue<Tuple> queue = new PriorityQueue<>(new Comparator<Tuple>()
		{

			@Override
			public int compare(Tuple o1, Tuple o2)
			{
				return o2.sum - o1.sum;
			}
		});

		for (int num1 : nums1)
		{
			for (int num2 : nums2)
			{
				Tuple obj = new Tuple(num1, num2);
				queue.offer(obj);

				if (queue.size() > k)
				{
					queue.poll();
				}
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		while (!queue.isEmpty())
		{
			Tuple obj = queue.poll();
			List<Integer> list = Arrays.asList(obj.value1, obj.value2);
			result.add(list);
		}
		Collections.reverse(result);
		return result;

	}

}

class Tuple
{
	int value1;
	int value2;
	int sum;

	public Tuple(int value1, int value2)
	{
		this.value1 = value1;
		this.value2 = value2;
		this.sum = value1 + value2;
	}

}