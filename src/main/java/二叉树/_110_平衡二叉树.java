package 二叉树;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/balanced-binary-tree/
 * @Date 2020/2/5
 */
public class _110_平衡二叉树
{

	/**
	 * 也是遍历1钟 使用前序遍历 然后需要高度 然后随时判断是否有出现问题
	 *
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root)
	{
		if (root == null)
			return true;

		return depth(root) != -1;

	}

	private int depth(TreeNode node)
	{
		if (node == null)
			return 0;

		int left = depth(node.left);
		// 这个是发现错误的直接返回
		if (left == -1)
			return -1;
		int right = depth(node.right);
		// 这个是发现错误的直接返回
		if (right == -1)
			return -1;
		// 正常返回与错误返回
		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;

	}

}
