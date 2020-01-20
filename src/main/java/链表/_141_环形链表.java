package 链表;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/linked-list-cycle/
 * @Date 2020/1/8
 */
public class _141_环形链表
{

	public boolean hasCycle(ListNode head)
	{
		/**
		 *  思路:
		 *  	1.使用快慢指针实现
		 */
		if (head == null || head.next == null)
			return false;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			if (slow.equals(fast))
			{
				return true;
			}
		}

		return false;

	}

}
