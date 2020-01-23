package 二叉树;

import java.util.*;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @Date 2020/1/22
 */
public class _144_二叉树的前序遍历
{

	/**
	 * 迭代版前序遍历
	 *
	 * @param root
	 * @return
	 */
	// 总结 核心一直不变 变的是数据结构与模型判断
	public List<Integer> preorderTraversal3(TreeNode root)
	{
		// 矛盾点在于 左边和右边 如果有多层的情况的时候 左边是先进先出 而右边是需要等待 先进后出
		Queue<TreeNode> leftQue = new LinkedList<>();
		Stack<TreeNode> rightStack = new Stack<>();
		Queue<Integer> outque = new LinkedList<>();
		// 结果集转换
		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;

		leftQue.offer(root);

		while (!leftQue.isEmpty())
		{
			TreeNode node = leftQue.poll();

			if (node == null)
				continue;

			outque.offer(node.val);

			if (node.left != null)
				leftQue.offer(node.left);
			if (node.right != null)
				rightStack.push(node.right);

			if (leftQue.isEmpty() && !rightStack.isEmpty())
			{
				leftQue.offer(rightStack.pop());
			}
		}

		while (!outque.isEmpty())
		{
			list.add(outque.poll());
		}

		return list;
	}

	/**
	 * 递归版二叉树前序遍历
	 *
	 * @param root
	 * @return
	 */
	// 总结:递归就是从最简单的情况开始考虑起 然后1步1步往上
	public List<Integer> preorderTraversal2(TreeNode root)
	{
		/**
		 * 思路
		 * 		1.使用递归
		 * 		2.先访问本身 然后是左 然后是右 递归到最后 本 左 右都结束 就是上一层...
		 * 		3.1个List记录保存数据
		 */
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		preorderTraversal(root, list);

		return list;
	}

	/**
	 * 使用迭代方式实现前序遍历
	 *
	 * @param root
	 * @return
	 */
	// 总结 问题的关键在于 在访问完左边的时候 要把右边的数据按照倒序回来
	// 这个数据结构就是栈
	public List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		// 考虑最简单的情况 没有节点
		if (root == null)
			return list;

		// 考虑只有1个节点
		// 考虑含有左节点和右节点的二叉树
		// 考虑稍微复杂1点的情况
		//		list.add(root.val);
		//		list.add(root.left.val);
		//		list.add(root.right.val);

		//		list.add(root.val);
		//		list.add(root.left.val);
		//		list.add(root.left.val);
		//		// 可以简化为
		//		while(root.left!=null){
		//			root = root.left;
		//			list.add(root.val);
		//		}
		// 需要返过来访问右节点了
		// 一直需要考虑左节点和右节点的穿插问题 但是这两个东西是绑定的
		// 也就是有顺序的 并且是符合 先进后出的 这是栈

		// 使用栈来实现
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty())
		{
			TreeNode node = stack.pop();

			if (node == null)
				continue;

			// node需要继续啊 那就是循环
			do
			{
				// 直接访问本身
				list.add(node.val);

				// 存储这个moment的右节点
				stack.push(node.right);

				node = node.left;
			}
			while (node != null);

		}

		return list;

	}

	/**
	 * 递归方法
	 *
	 * @param root
	 * @param list
	 */
	private void preorderTraversal(TreeNode root, List<Integer> list)
	{
		// 这是实质的结束
		if (root == null)
			return;
		list.add(root.val);

		// 左
		preorderTraversal(root.left, list);
		// 右
		preorderTraversal(root.right, list);

	}

}
