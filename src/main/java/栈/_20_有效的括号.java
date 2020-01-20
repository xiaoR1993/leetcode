package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/valid-parentheses/
 * @Date 2020/1/20
 */
/**
 * 总结 使用栈和Map可以实现匹配的关系 先进后出 后进先出 就是符合对称的关系
 */
public class _20_有效的括号
{

	public static Map<Character, Character> map;

	static
	{
		map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	}

	public boolean isValid(String s)
	{
		//		"()" 有效括号
		/**
		 * 使用栈来解决 入栈出栈
		 */
		Stack<Character> stack = new Stack<>();

		//"()"
		for (char c : s.toCharArray())
		{
			// 不是左字符就是右字符
			if (map.containsKey(c))
			{
				stack.push(map.get(c));
			}
			else
			{
				char topElement = stack.isEmpty() ? '#' : stack.pop();
				if (topElement != c)
				{
					return false;
				}
			}
		}

		return stack.isEmpty();

	}

	public static void main(String[] args)
	{
		_20_有效的括号 obj = new _20_有效的括号();
		System.out.println(obj.isValid("()"));

	}

}
