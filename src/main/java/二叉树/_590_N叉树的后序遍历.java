package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * @Date 2020/1/26
 */
public class _590_N叉树的后序遍历
{
	/**
	 * 使用迭代方式后续遍历
	 *
	 * @param root
	 * @return
	 */
	// 总结：根据二叉树的后续遍历修改而来
	public List<Integer> postorder(Node root)
	{
		Stack<Node> inStack = new Stack<>();
		Stack<Integer> outStack = new Stack<>();

		if (root == null)
			return outStack;

		inStack.push(root);

		while (!inStack.isEmpty())
		{
			Node node = inStack.pop();

			if (node == null)
				continue;

			// 要符合先进后出性质
			outStack.push(node.val);

			// 然后左树和右树要进inStack 并且是要符合
			// 后进先出性质
			List<Node> children = node.children;
			if (children == null || children.size() == 0)
			{
				continue;
			}

			//			List<Node> reChildren = new ArrayList<>(children);
			//			Collections.reverse(reChildren);

			for (Node child : children)
			{
				inStack.push(child);
			}

		}

		// 结果集转换
		List<Integer> list = new ArrayList<>();

		while (!outStack.isEmpty())
		{
			list.add(outStack.pop());
		}

		return list;
	}

	/**
	 * 使用迭代方式
	 *
	 * @param root
	 * @return
	 */
	// 总结：后续遍历比较简答
	public List<Integer> postorder2(Node root)
	{
		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;

		postorder(root, list);

		return list;

	}

	private void postorder(Node node, List<Integer> list)
	{

		if (node == null)
			return;

		// 访问
		//		if (CollectionUtils.isNotEmpty(node.children))
		if (node.children != null)
		{
			for (Node child : node.children)
			{
				postorder(child, list);
			}
		}

		// 先访问
		list.add(node.val);

	}

}
