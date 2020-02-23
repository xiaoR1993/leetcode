package 队列;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @Date 2020/2/22
 */
public class _23_合并K个排序链表
{
	// 总结:仍然是使用了优先级队列  但是效率较低
	public ListNode mergeKLists(ListNode[] lists)
	{
		/**
		 * 思路
		 * 		1.还是使用优先级队列
		 */
		Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>()
		{
			@Override
			public int compare(ListNode o1, ListNode o2)
			{
				return o1.val - o2.val;
			}
		});

		for (ListNode node : lists)
		{
			while (node != null)
			{
				queue.offer(node);
				node = node.next;
			}
		}

		ListNode root = queue.poll();
		ListNode node = root;
		while (!queue.isEmpty())
		{
			ListNode next = queue.poll();
			node.next = next;
			node = next;
		}

		return root;
	}

}
