package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Date 2020/1/26
 */
public class _104_二叉树的最大深度
{

	/**
	 * 使用递归方式得到树的高度
	 *
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root)
	{
		/**
		 * 思路：
		 * 		1.递归方式
		 * 		2.需要有个东西来记录高度
		 * 		3.那其实就是左树的高度和右树高度的大值
		 */
		if (root == null)
			return 0;
		return height(root);

	}

	public int height(TreeNode node)
	{
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));

	}

	/**
	 * 使用迭代方式的层序遍历方式 算出深度
	 *
	 * @param root
	 * @return
	 */
	// 总结 默写层序遍历 然后记录考虑记录每层的个数 标记到每一层是关键
	public int maxDepth2(TreeNode root)
	{
		/**
		 * 思路：
		 * 		1.默写层序遍历
		 * 		2.找到最大深度
		 */
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		int height = 0;
		int levelNum = 1;

		queue.offer(root);

		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();

			// 操作
			levelNum--;

			// 入队
			if (node.left != null)
			{
				queue.offer(node.left);
			}

			if (node.right != null)
			{
				queue.offer(node.right);
			}

			// 检测levelNum是否为0
			if (levelNum == 0)
			{
				height++;
				levelNum = queue.size();

			}

		}

		return height;
	}

}
