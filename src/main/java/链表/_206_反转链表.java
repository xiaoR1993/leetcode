package 链表;

import org.junit.Test;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/reverse-linked-list/
 * @Date 2020/1/8
 */
public class _206_反转链表
{

	public ListNode reverseList(ListNode head)
	{

		/**
		 * 	思路:
		 * 		1.我只要记录2个元素 然后将他们的关系调换 从null 1 开始 在改变指向前要获取到下一个元素
		 * 		2.结束的关键在于 获取下一个为null则停止
		 */
		// head为null或者单节点直接返回
		if (head == null || head.next == null)
			return head;

		// 调换位置
		// 要点在于那个临界状态 null<- 1  2->3 ...
		// 这时要记住1这个node 结束条件就是3是null
		ListNode prev = null;
		while (head != null)
		{
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}

		return prev;

	}

	//迭代法
	public ListNode reverseList2(ListNode head)
	{
		/**
		 * 	思路
		 * 		1.迭代的话 没办法记录前1个吧? 其实是可以的 在下一个返回的时候
		 * 		2.有点是从最里面开始换
		 * 		3.如果在Null这个位置则退出
		 * 		4.回到5这个位置 看右边 不需要工作
		 * 		5.回到4这个位置 就是把下1个的返回值 返回值 指向当前 返回当前
		 * 		6.迭代...
		 *
		 */
		if (head == null || head.next == null)
			return head;

		ListNode newHead = reverseList2(head.next);
		// 这里是反转的关键 原本4->5 这行代码是将5->4
		// 意思是改变next的指向
		head.next.next = head;
		//这里是为了head是最后1个元素 指向null
		head.next = null;
		return newHead;

	}

}
