package 队列;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Date 2020/2/22
 */
public class _215_数组中的第K个最大元素
{

	/**
	 * @param nums 数组
	 * @param k    取最大的第k个
	 * @return
	 */
	public int findKthLargest(int[] nums, int k)
	{
		/**
		 * 思路
		 * 		1.使用topN思路来解决
		 * 		2.模拟TopN
		 */
		Queue<Integer> queue = new PriorityQueue<>();

		for (int num : nums)
		{
			queue.add(num);
			// 反正1股脑进去 数量超标就出队,因为小的都会出去了
			if (queue.size() > k)
			{
				queue.poll();
			}
		}

		return queue.poll();

	}

}
