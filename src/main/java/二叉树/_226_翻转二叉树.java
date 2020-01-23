package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/invert-binary-tree/
 * @Date 2020/1/22
 */

/**
 * 总结:要点在于遍历二叉树的每个节点
 */
public class _226_翻转二叉树
{

	/**
	 * 迭代方式
	 * 总结: 使用层序遍历获取到所有的节点 然后将左右节点进行换位即可
	 * 要点在于遍历方式以及核心逻辑
	 *
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root)
	{
		/**
		 * 思路
		 * 		1.使用队列来实现 其实是1个遍历问题
		 * 		2.使用层序遍历
		 * 		3.将左右子树交换位置即可
		 * 		3.左子树和右子树入队
		 */

		// 先默写层序遍历方式
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty())
		{

			TreeNode node = queue.poll();

			// 操作
			// 交换左右节点的位置
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;

			// 左节点入队
			if (node.left != null)
			{
				queue.offer(node.left);
			}

			// 右节点入队
			if (node.right != null)
			{
				queue.offer(node.right);
			}

		}
		return root;
	}

	/**
	 * 总结:要点在于遍历节点 然后加上核心代码即可
	 * @param root
	 * @return
	 */
	public TreeNode invertTree1(TreeNode root)
	{
		/**
		 * 思路:
		 * 		1.使用递归方式
		 * 		2.使用前序遍历 尝试效果
		 * 		3.调换位置核心代码
		 */
		if (root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

}
