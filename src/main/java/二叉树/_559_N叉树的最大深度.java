package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * @Date 2020/1/26
 */
public class _559_N叉树的最大深度
{

	/**
	 * 使用迭代方法
	 *
	 * @param root
	 * @return
	 */
	// 总结：模拟2叉树的最大高度来计算
	public int maxDepth(Node root)
	{
		if (root == null)
			return 0;
		Queue<Node> queue = new LinkedList<>();
		int height = 0;
		int levelNum = 1;

		queue.offer(root);

		while (!queue.isEmpty())
		{
			Node node = queue.poll();

			// 操作
			levelNum--;

			// 入队
			List<Node> children = node.children;
			if (children != null && children.size() > 0)
			{
				for (Node child : children)
				{
					queue.offer(child);
				}
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
