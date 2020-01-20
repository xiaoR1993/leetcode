package 栈;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @Date 2020/1/20
 */

/**
 * 总结:利用栈的后进先出 其实就是选出2个数进行运算
 */
public class _150_逆波兰表达式求值
{

	private static Map<String, BiFunction<Integer, Integer, Integer>> map;

	static
	{
		map = new HashMap<>();
		map.put("+", Math::addExact);
		map.put("-", Math::subtractExact);
		map.put("*", Math::multiplyExact);

		// 定义除法
		// lambda表达式 先声明 后使用
		BiFunction<Integer, Integer, Integer> biFunction = (v1, v2) -> v1 / v2;

		map.put("/", biFunction);
	}

	public int evalRPN(String[] tokens)
	{
		/**
		 * 思路 使用栈来实现 后进先出 然后碰到运算符就取2个数进行运算 然后放进去
		 */
		Stack<Integer> stack = new Stack<>();
		for (String c : tokens)
		{
			if (map.containsKey(c))
			{
				int v1 = stack.pop();
				int v2 = stack.pop();
				stack.push(map.get(c).apply(v2, v1));
			}
			else
			{
				stack.push(Integer.parseInt(c));
			}

		}

		return stack.pop();
	}

	public static void main(String[] args)
	{
		String[] strs = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		_150_逆波兰表达式求值 obj = new _150_逆波兰表达式求值();
		System.out.println(obj.evalRPN(strs));

	}

}
