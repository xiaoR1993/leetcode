package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Date 2020/1/22
 */
public class _94_二叉树的中序遍历
{

	/**
	 * 使用递归的方式完成中序遍历
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal1(TreeNode root)
	{

		List<Integer> list = new ArrayList<>();

		inorderTraversal(root, list);

		return list;
	}

	/**
	 * 使用迭代的方式完成中序遍历
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal3(TreeNode root)
	{
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;

		TreeNode node = root;

		while (node != null || !stack.isEmpty())
		{

			// 往左走
			while (node != null)
			{
				stack.push(node);
				node = node.left;
			}

			// 最终node会为null 然后从栈中弹出
			node = stack.pop();

			list.add(node.val);

			node = node.right;
		}

		return list;
	}

	/**
	 * 使用迭代的方式完成中序遍历
	 *
	 * @param root
	 * @return
	 */
	// 感觉有点绕吧 一下子可能接受不了
	// 总结 要点在于左中右遍历方式 然后使用迭代模拟这个过程
	// 一直往左 然后左为空则访问本身 然后是右边 然后访问右边有可能结束了迭代
	public List<Integer> inorderTraversal(TreeNode root)
	{

		List<Integer> list = new ArrayList<>();

		// 这个也是蛮简单的 也是使用栈
		// 因为这个也是先左边 然后中间 右边
		// 痛点在于 右边可以通过中间获取
		if (root == null)
			return list;

		// 总结 要点在于左中右遍历方式 然后使用迭代模拟这个过程
		// 一直往左 然后左为空则访问本身 然后是右边 然后访问右边有可能结束了迭代
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;

		while (node != null || !stack.isEmpty())
		{

			// 一直往左
			while (node != null)
			{
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			list.add(node.val);
			node = node.right;

		}

		return list;
	}

	private void inorderTraversal(TreeNode root, List<Integer> list)
	{
		if (root == null)
			return;
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
	}

	private static List<Integer> list;
	private static TreeNode node;

	static
	{
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node = node1;
		node1.right = node2;
		node2.right = node3;

	}

	public static void main(String[] args)
	{
		_94_二叉树的中序遍历 obj = new _94_二叉树的中序遍历();
		System.out.println(obj.inorderTraversal(node));

	}

}
