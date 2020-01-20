package 链表;

import org.springframework.format.datetime.joda.MillisecondInstantPrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @Date 2020/1/8
 */
public class _876_链表的中间结点
{
	public static ListNode middleNode(ListNode head)
	{

		/**
		 * 	思路:
		 * 		1.首先要知道有多少个元素
		 * 		2.空间换时间 将每个节点存入HashMap<index,ListNode>
		 * 		3.根据元素个数判断出目标index num/2 +1 -1 = num/2
		 */
		if (head == null || head.next == null)
			return head;

		List<ListNode> list = new ArrayList<>();

		ListNode curr = head;

		// 数量
		int num = 0;
		while (curr != null)
		{
			list.add(curr);
			num++;
			curr = curr.next;
		}

		int middleIndex = num >> 1;
		return list.get(middleIndex);
	}

}
