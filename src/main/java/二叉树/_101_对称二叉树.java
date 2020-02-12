package 二叉树;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/symmetric-tree/
 * @Date 2020/1/30
 */
public class _101_对称二叉树
{

	/**
	 * 使用递归完成
	 *
	 * @param root
	 * @return
	 */
	// 也是1钟遍历的方式 使用了递归
	public boolean isSymmetric(TreeNode root)
	{

		return isMirror(root, root);

	}

	private boolean isMirror(TreeNode t1, TreeNode t2)
	{
		if (t1 == null && t2 == null)
			return true;

		if (t1 == null || t2 == null)
			return false;
		return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);

	}

}
