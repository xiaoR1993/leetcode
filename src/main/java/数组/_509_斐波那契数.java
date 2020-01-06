package 数组;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * @author 张业荣
 * @Title 509.斐波那契数
 * @Description 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 2Date 2020/1/1
 */
public class _509_斐波那契数 {

    public static void main(String[] args) {
        //测试 使用Assert

        System.out.println(_509_斐波那契数.fib(60));

//        Assert.isTrue(Fib.fib(5)==5,"斐波那契是否正确");
    }


    public static int fib(int N) {

        /**
         * 思路:
         *      1.规律是 索引: 0 1 2 3 4 5 6 ...
         *                   0 1 1 2 3 5 8
         *      2.只要知道前2个数 就能知道下1个数 那就轮换就好
         */
        // F(0)和 F(1)直接返回
        if (N < 2) return N;

        //保存初始的F(0)和F(1)
        int first = 0;
        int second = 1;

        //这是计算的次数
        for (int i = 0; i < N - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;

    }

}
