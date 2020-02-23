package 队列;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @Date 2020/2/22
 */
public class _378_有序矩阵中第K小的元素
{

	// 仍然是使用到优先级队列求第k大小的场景
	public int kthSmallest(int[][] matrix, int k)
	{
		/**
		 * 思路:
		 * 		还是使用优先级队列来实现吧
		 */
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o2 - o1;
			}
		});

		for (int[] ints : matrix)
		{
			for (int num : ints)
			{
				queue.offer(num);
				if (queue.size() > k)
				{
					queue.poll();
				}
			}
		}

		return queue.peek();

	}

}
