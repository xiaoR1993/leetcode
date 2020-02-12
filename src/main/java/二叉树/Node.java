package 二叉树;

import java.util.List;

/**
 * @author 张业荣
 * @Description
 * @Date 2020/1/26
 */
public class Node
{

	public int val;
	public List<Node> children;

	public Node()
	{
	}

	public Node(int _val)
	{
		val = _val;
	}

	public Node(int _val, List<Node> _children)
	{
		val = _val;
		children = _children;
	}
}
