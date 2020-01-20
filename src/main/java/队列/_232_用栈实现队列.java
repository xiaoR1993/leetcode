package 队列;

import java.util.Stack;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @Date 2020/1/20
 */

/**
 * 总结:使用2个栈实现队列的功能 精髓在于2个栈
 */
public class _232_用栈实现队列
{
	private Stack<Integer> inStack;// 入栈
	private Stack<Integer> outStack;// 出栈

	/**
	 * Initialize your data structure here.
	 */
	public _232_用栈实现队列()
	{
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x)
	{
		inStack.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop()
	{
		if (outStack.empty())
		{
			while (!inStack.empty())
			{
				outStack.push(inStack.pop());
			}
		}

		return outStack.pop();

	}

	/**
	 * Get the front element.
	 */
	public int peek()
	{
		if (outStack.empty())
		{
			while (!inStack.empty())
			{
				outStack.push(inStack.pop());
			}
		}
		return outStack.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty()
	{
		return inStack.empty() && outStack.empty();
	}

	public static void main(String[] args)
	{
		_232_用栈实现队列 obj =new _232_用栈实现队列();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.pop());
		System.out.println(obj.peek());
		System.out.println(obj.empty());
		System.out.println(obj.pop());
		System.out.println(obj.empty());

	}

}
