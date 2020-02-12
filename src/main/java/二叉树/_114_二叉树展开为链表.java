package 二叉树;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @Date 2020/1/29
 */
public class _114_二叉树展开为链表
{

	/**
	 * 遍历结果像前序遍历 但是实质他要改变整个的指向 还是1个二叉树
	 *
	 * @param root
	 */
	// 总结：核心在于思路 然后 性能较低 是2个遍历 n*(n/2) = n^2 的思路 不太好
	// 思路是找到左子树 然后遍历左子树找到最右的节点 然后把左子树放到右子树
	// 右子树贴到最右节点的右子树上
	public void flatten(TreeNode root)
	{
		// 未完成

		/**
		 * 思路：
		 * 		1.遍历root 然后将左子树 放到右边 然后右边接上
		 * 		2.然后进行到下1个 循环往复 直到右为Null
		 */
		if (root == null)
			return;

		//					1
		//				  /   \
		//			     2     5

		// 左子树和右子树还有东西的时候
		while (root != null)
		{

			if (root.left != null)
			{
				TreeNode leftMaxRight = root.left;
				TreeNode right = root.right;

				// 需要找到左子树的最右节点
				while (leftMaxRight.right != null)
				{
					leftMaxRight = leftMaxRight.right;
				}

				leftMaxRight.right = root.right;

				root.right = root.left;

			}
			root.left = null;
			root = root.right;

		}

	}

}
