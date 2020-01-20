package 链表;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @Date 2020/1/8
 */
public class _203_移除链表元素
{

	//官方
	public static ListNode removeElementsOff(ListNode head, int val)
	{
		/**
		 * 	思路:
		 *		1.使用哨兵模式 解决头部问题
		 *		2.定义prev 和 curr 指向前1个和当前
		 */
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;

		ListNode prev = sentinel;
		ListNode curr = head;

		while (curr != null)
		{
			if (curr.val == val)
			{
				prev.next = curr.next;
			}else{
				//不删除则prev前进
				prev = curr;
			}
			curr = curr.next;
		}
		return sentinel.next;

	}

	public ListNode removeElements(ListNode head, int val)
	{
		/**
		 * 思路
		 * 		1->2->6->3->4->5->6
		 * 		1.获取到1的node 然后判断下个数是否为null
		 * 		2.然后判断下个数是否值是否相等 相等则node.next = node.next.next
		 */

		// 解决开头head是重复
		while (head != null && head.val == val)
		{
			head = head.next;
		}

		if (head == null)
			return null;

		// 普通情况 中间的情况
		ListNode current = head;

		// 解决中间的问题
		// 尾部的问题也能解决
		while (current.next != null)
		{
			if (current.next.val == val)
			{
				current.next = current.next.next;
			}
			else
			{
				current = current.next;
			}
		}

		return head;

	}

}
