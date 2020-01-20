package 链表;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @Date 2020/1/8
 */
public class _237_删除链表中的节点
{
	public static void main(String[] args)
	{

	}

	public void deleteNode(ListNode node)
	{
		//考虑的是自身的消灭?
		node.val = node.next.val;
		node.next = node.next.next;

	}

}
