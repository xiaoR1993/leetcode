package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @Date 2020/1/26
 */
public class _589_N叉树的前序遍历
{

	/**
	 * 使用迭代完成前序遍历
	 *
	 * @param root
	 * @return
	 */
	// 在二叉树的前序遍历基础上改进而来
	public List<Integer> preorder(Node root)
	{
		List<Integer> list = new ArrayList<>();
		// 考虑最简单的情况 没有节点
		if (root == null)
			return list;

		// 使用栈来实现
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty())
		{
			Node node = stack.pop();

			if (node == null)
				continue;

			// node需要继续啊 那就是循环
			do
			{
				// 直接访问本身
				list.add(node.val);

				// 存储这个moment的右节点
				List<Node> children = node.children;
				if (children == null || children.size() == 0)
				{
					break;
				}

				List<Node> rightList = children.subList(1, children.size());
				Collections.reverse(rightList);

				for (Node child : rightList)
				{
					stack.push(child);
				}

				node = children.get(0);
			}
			while (node != null);

		}

		return list;

	}

	/**
	 * 递归进行前序遍历
	 *
	 * @param root
	 * @return
	 */
	// 总结 类似二叉树的前序遍历 只是节点那边是操作的事集合
	public List<Integer> preorder2(Node root)
	{
		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;

		preorder(root, list);

		return list;

	}

	private void preorder(Node node, List<Integer> list)
	{
		if (node == null)
			return;

		// 先访问
		list.add(node.val);
		// 访问
		//		if (CollectionUtils.isNotEmpty(node.children))
		if (node.children != null)
		{
			for (Node child : node.children)
			{
				preorder(child, list);
			}
		}
	}

}
