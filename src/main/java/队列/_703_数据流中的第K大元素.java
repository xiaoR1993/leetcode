package 队列;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * @Date 2020/2/22
 */
public class _703_数据流中的第K大元素
{

}

// 总结 主要是使用了优先级队列 也就是二叉堆 实现到求第k大数据的方便方法
// 解决topN以及第K大的数据
class KthLargest
{

	// 使用到优先级队列
	// 默认最小堆
	private Queue<Integer> queue = new PriorityQueue<>();
	private int k;

	public KthLargest(int k, int[] nums)
	{
		// 使用批量建堆
		for (int num : nums)
		{
			queue.offer(num);
			if (queue.size() > k)
			{
				queue.poll();
			}
		}
		this.k = k;
	}

	public int add(int val)
	{
		queue.offer(val);
		if (queue.size() > k)
		{
			queue.poll();
		}

		return queue.peek();

	}
}