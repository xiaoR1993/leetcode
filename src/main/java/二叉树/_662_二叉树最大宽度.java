package 二叉树;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 * @Date 2020/1/26
 */
public class _662_二叉树最大宽度
{
	/**
	 * 使用迭代的方式完成
	 *
	 * @param root
	 * @return
	 */
	// 总结:模拟层序遍历方式 主要是遍历过程中对节点补充数据pos 然后在后面对标记上的节点 按层次计算宽度
	// 然后求出最大值
	public int widthOfBinaryTree(TreeNode root)
	{
		/**
		 * 思路：
		 * 		1.层序遍历
		 * 		2.需要给结点进行编号 然后才能进行计算
		 * 		3.需要的东西是每一层的数据 然后每一层进行操作
		 * 		4.[ [1,2,4] ,[...]  ]
		 * 		5.然后在数组里面继续你想要的计算是比较好的
		 * 		6.节点的值不重要 重要的是他的编号
		 */
		if (root == null)
			return 0;

		List<AnnotatedNode> list = new ArrayList<>();

		Queue<AnnotatedNode> queue = new LinkedList<>();

		queue.offer(new AnnotatedNode(root, 1, 1));

		while (!queue.isEmpty())
		{
			AnnotatedNode node = queue.poll();

			// 操作
			list.add(node);

			// 入队
			if (node.left != null)
			{
				queue.offer(new AnnotatedNode(node.left, node.depth + 1, node.pos * 2));
			}

			if (node.right != null)
			{
				queue.offer(new AnnotatedNode(node.right, node.depth + 1, node.pos * 2 + 1));
			}

		}

		// 变为同为深度的List
		Map<Integer, List<AnnotatedNode>> depthList = list.stream()
				.collect(Collectors.groupingBy(AnnotatedNode::getDepth));

		// 宽度
		List<Integer> breathList = new ArrayList<>();

		for (List<AnnotatedNode> values : depthList.values())
		{
			List<Integer> nums = values.stream().map(AnnotatedNode::getPos).collect(Collectors.toList());
			Integer max = Collections.max(nums);
			Integer min = Collections.min(nums);
			breathList.add(max - min + 1);
		}

		return Collections.max(breathList);

	}

	class AnnotatedNode extends TreeNode
	{
		int depth; // 深度
		int pos; // 位置序号

		public int getDepth()
		{
			return depth;
		}

		public void setDepth(int depth)
		{
			this.depth = depth;
		}

		public int getPos()
		{
			return pos;
		}

		public void setPos(int pos)
		{
			this.pos = pos;
		}

		public AnnotatedNode(TreeNode node, int depth, int pos)
		{
			super(node.val);
			super.left = node.left;
			super.right = node.right;
			this.depth = depth;
			this.pos = pos;
		}

	}

}
