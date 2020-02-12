package 二叉树;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * @Date 2020/1/31
 */
public class _450_删除二叉搜索树中的节点
{

	/**
	 * 实质是删除的写法
	 *
	 * @param root
	 * @param key
	 * @return
	 */
	// 放弃
	public TreeNode deleteNode(TreeNode root, int key)
	{
		if (root == null)
			return root;

		/**
		 * 思路:
		 * 		1.首先应该找到需要删除的节点
		 * 		2.找到后,删除它
		 */
		TreeNode node = node(root, key);

		// 如果删除的是度为2的节点
		// 是找到后继节点 后继节点1定是度为1或者0的节点
		if (node.left != null && node.right != null)
		{
			TreeNode succ = successor(node);
			// 使用后继来替换它 逻辑是 值替换 然后删除节点
			// 变为这个后继节点
			node.val = succ.val;
			node = succ;
		}

		// 到这里 就是 删除度为1或者度为0的节点
		if (node.left != null || node.right != null)
		{
			// 删除度为1的节点
			if (node.left != null)
			{

			}
		}
		return null;
	}

	/**
	 * 查看节点的后继
	 *
	 * @param node
	 * @return
	 */
	public TreeNode successor(TreeNode node)
	{
		if (node == null)
			return null;

		// 在右节点的左子树中 node.right.left.left...
		if (node.right != null)
		{
			node = node.right;
			while (node.left != null)
			{
				node = node.left;
			}
			return node;
		}

		return null;
	}

	/**
	 * 通知key 找到该节点
	 *
	 * @param key
	 * @return
	 */
	private TreeNode node(TreeNode root, int key)
	{
		if (root == null)
			return null;

		// 通过比较来判断node在左边还是右边
		while (root != null)
		{
			int cmp = compare(root.val, key);

			if (cmp > 0)
			{
				// 在左子树
				root = root.left;
			}
			else if (cmp < 0)
			{
				// 在右子树
				root = root.right;
			}
			else
			{
				// 相等
				return root;
			}
		}

		return null;

	}

	/**
	 * 比较方法
	 *
	 * @param val1
	 * @param val2
	 * @return
	 */
	private int compare(int val1, int val2)
	{
		return val1 - val2;

	}

}
