package com.zyr.leetcode;

/**
 * @author 张业荣
 * @Title 大O表示法对冒泡排序
 * @Description
 * @Date 2020/1/1
 */
public class lovestru {

    public static void main(String[] args) {

    }

    /**
     * 冒牌排序
     *
     * @param arr
     * @return
     */
    //使用大O表示法获取时间复杂度
    public int[] bubbleSort(int[] arr) {
        //1+2n+n(1+2n) = 1+3n+4n^2 因此初略为n^2
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    //斐波那契
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        // 2^(n-1) -1 = 2^(n-1)=0.5*2^n=2^n

        return fib(n - 1) * fib(n - 2);

    }





}
