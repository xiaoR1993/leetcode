package 二叉树;

import java.util.*;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @Date 2020/1/26
 */
public class _107_二叉树的层次遍历2
{

	/**
	 * 使用迭代方式获取
	 *
	 * @param root
	 * @return
	 */
	// 总结:模拟正序层次遍历 然后进行倒叙输出而已
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		/**
		 * 思路：
		 * 		1.默写层序遍历
		 * 		2.最后集合反序
		 */
		List<List<Integer>> list = new ArrayList<>();

		if (root == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();

		List<Integer> levelList = new ArrayList<>();

		int levelNum = 1;

		queue.offer(root);

		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();

			// 操作
			levelList.add(node.val);
			levelNum--;

			// 入队
			if (node.left != null)
			{
				queue.add(node.left);
			}
			if (node.right != null)
			{
				queue.add(node.right);
			}

			if (levelNum == 0)
			{

				list.add(levelList);
				levelList = new ArrayList<>();
				levelNum = queue.size();

			}
		}

		// 倒叙
		Collections.reverse(list);
		return list;
	}

}
