package 链表;

import java.util.HashSet;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @Date 2020/1/8
 */
public class _83_删除排序链表中的重复元素
{

	public static ListNode deleteDuplicates(ListNode head)
	{

		/**
		 * 思路
		 * 		1.首先是重复数据的记录问题 使用HashSet记录
		 * 		2.数据删除问题 还是使用哨兵模式 比较方便
		 * 		3.记录pre 和curr 2个指针
		 */
		HashSet<Integer> set = new HashSet<>();

		// 其实可以不用哨兵 因为不用考虑头节点的问题 但是这是1类非常好的解决思路
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;

		ListNode prev = sentinel;
		ListNode curr = head;

		while (curr != null)
		{
			// 获取值
			int val = curr.val;
			// 判断是否存在
			if (set.contains(val))
			{
				prev.next = curr.next;
			}
			else
			{
				set.add(val);
				prev = curr;
			}
			// 前进1步
			curr = curr.next;
		}

		return sentinel.next;

	}

}
