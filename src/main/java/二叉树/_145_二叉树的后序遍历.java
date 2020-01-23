package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @Date 2020/1/23
 */
public class _145_二叉树的后序遍历
{

	/**
	 * 使用迭代实现后序遍历
	 *
	 * @param root
	 * @return
	 */
	// 总结:在1个前提下 就是深度搜索下 核心代码是左-右-中 然后分析输出的形式
	// 然后使用对应的数据结构进行模拟
	public List<Integer> postorderTraversal(TreeNode root)
	{
		/**
		 * 思路:
		 * 		1.核心代码与迭代相同 但是要考虑用什么东西来存储
		 * 		2.
		 * 			5
		 * 		  4   7
		 * 		2.入栈顺序是5-4-7 现在要输出顺序为4-7-5 需要更改 2个栈来实现
		 */
		Stack<TreeNode> inStack = new Stack<>();
		Stack<Integer> outStack = new Stack<>();

		if (root == null)
			return outStack;

		inStack.push(root);

		while (!inStack.isEmpty())
		{
			TreeNode node = inStack.pop();

			if (node == null)
				continue;

			// 要符合先进后出性质
			outStack.push(node.val);

			// 然后左树和右树要进inStack 并且是要符合
			// 后进先出性质
			inStack.push(node.left);
			inStack.push(node.right);

		}

		// 结果集转换
		List<Integer> list = new ArrayList<>();

		while(!outStack.isEmpty()){
			list.add(outStack.pop());
		}

		return list;

	}

	/**
	 * 使用递归来完成
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal2(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;

		postorderTraversal(root, list);
		return list;
	}

	public List<Integer> postorderTraversal(TreeNode root, List<Integer> list)
	{
		if (root == null)
			return null;

		postorderTraversal(root.left, list);

		postorderTraversal(root.right, list);

		list.add(root.val);

		return list;
	}
}