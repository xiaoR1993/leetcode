package 栈;

import java.util.Stack;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/score-of-parentheses/
 * @Date 2020/1/20
 */

/**
 * 总结:利用栈的后进先出特性 以及深度和分数的统计 找到规律
 */
public class _856_括号的分数
{

	public int scoreOfParentheses(String S)
	{
		/**
		 * 思路
		 * ()得1分
		 * 栈配合深度和分数
		 */
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (char c : S.toCharArray())
		{
			if ('(' == c)
			{
				stack.push(0);
			}

			if (')' == c)
			{
				// ()计1分 否则当前深度分数*2提交到上1层
				int v = stack.pop();
				// 精髓在于最小是1
				int w = stack.pop() + Math.max(v * 2, 1);
				stack.push(w);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args)
	{
		String str = "(())";
		_856_括号的分数 obj = new _856_括号的分数();
		System.out.println(obj.scoreOfParentheses(str));
	}

}
