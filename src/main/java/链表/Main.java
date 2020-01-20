package 链表;

import org.junit.Test;

/**
 * @author zyr
 * @Description 测试类
 * @Date 2020/1/8
 */
public class Main
{

	@Test public void test01()
	{
		// 构建链表
		ListNode node = new ListNode(1);
		ListNode first = node;
		for (int i = 2; i < 7; i++)
		{
			node.next = new ListNode(i);
			node = node.next;
		}

		System.out.println(ListNodeTOString(first));

		// 测试
		System.out.println(ListNodeTOString(_876_链表的中间结点.middleNode(first)));

	}

	public String ListNodeTOString(ListNode node)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(node.val);
		while (node.next != null)
		{
			sb.append(", ");
			node = node.next;
			sb.append(node.val);
		}

		sb.append("]");

		return sb.toString();

	}

}
