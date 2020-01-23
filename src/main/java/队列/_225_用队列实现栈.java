package 队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @Date 2020/1/21
 */

/**
 * 使用双端队列的力量完成
 */
public class _225_用队列实现栈
{
	/**
	 * 思路使用双端队列实现
	 */
	private Deque<Integer> deque;

	/**
	 * Initialize your data structure here.
	 */
	public _225_用队列实现栈()
	{
		deque = new LinkedList<>();
	}

	/**
	 * Push element x onto stack.
	 */
	public void push(int x)
	{
		deque.offer(x);
	}

	/**
	 * Removes the element on top of  the stack and returns that element.
	 */
	public int pop()
	{
		return deque.pollLast();
	}

	/**
	 * Get the top element.
	 */
	public int top()
	{
		return deque.peekLast();
	}

	/**
	 * Returns whether the stack is empty.
	 */
	public boolean empty()
	{
		return deque.isEmpty();
	}

}
