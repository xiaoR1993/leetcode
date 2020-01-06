package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author 张业荣
 * @Title 两数之和
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * @Date 2019-12-28
 */
public class _1_两数之和 {

    public static void main(String[] args) {

        //调用
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = _1_两数之和.twoSum2(nums, target);
        System.out.println(Arrays.toString(result));

    }

    //效率是n^2 不太好啊
    public static int[] twoSum(int[] nums, int target) {
        /**
         * 思路：
         *      1.从数组从左到右遍历 然后获取target-每个元素 然后
         *      2.抛开优化角度 先实现
         *          1.我喜欢用集合
         *          2.对集合进行遍历 然后获取目标数值 然后判断是否存在 即可找到2个索引
         * 关键点：
         *      1.2个元素的相加 只有2个元素相加
         *      2.存在性
         */
        //转换为数组
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        int[] result = new int[2];

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int other = target - num;
            int otherIndex = list.indexOf(other);
            if (otherIndex != -1) {
                result[0] = i;
                result[1] = otherIndex;
                break;
            }
        }
        return result;
    }

    //时间复杂度为O(n)
    public static int[] twoSum2(int[] nums, int target) {
        /**
         * 思路：
         *  方法三：一遍哈希表
         * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
         *
         *
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * 关键点：
         */
        //构建Hash表 key是值 value是索引
        HashMap<Integer, Integer> map = new HashMap<>();

        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int targetValue = target - value;
            //获取是否存在值 有则返回
            if (map.containsKey(targetValue)) {
                return new int[]{i, map.get(targetValue)};
            } else {
                //没有则存入
                map.put(value, i);
            }
        }
        throw new IllegalArgumentException("没有2数解");

    }

}
