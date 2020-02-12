package 排序;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Date 2020/2/9
 */
public class _349_两个数组的交集
{

	/**
	 * 求2个数组的交集
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	// 总结:使用集合能方便搜索,因为这是唯一的,然后搜索方面tree是非常利于搜索的
	// 动态数组的效率是n,双向链表的效率也是n,使用红黑树的treeSet集合搜索效率是logn级别
	public int[] intersection(int[] nums1, int[] nums2)
	{
		/**
		 * 思路:
		 * 		1.使用集合来解决
		 * 		2.将nums1放入1个集合
		 * 		3.检测nums2是否在集合里面 如何在的话就放入1个新的集合里面
		 * 		4.最后集合变为数组进行输出
		 */
		Set<Integer> set1 = new TreeSet<>();
		Set<Integer> set2 = new TreeSet<>();
		for (int num : nums1)
		{
			// n
			set1.add(num);
		}

		for (int num : nums2)
		{
			// m
			if (set1.contains(num))
			{
				set2.add(num);
			}
		}

		int[] result = new int[set2.size()];
		int i = 0;
		for (Integer num : set2)
		{
			result[i] = num;
			i++;
		}

		return result;

	}

}
