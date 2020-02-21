package 其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyr
 * @Description https://leetcode-cn.com/problems/spiral-matrix/
 * @Date 2020/2/19
 */
public class _54_螺旋矩阵
{
	/**
	 * 这种方法处理起来比较复杂
	 *
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder2(int[][] matrix)
	{
		List ans = new ArrayList();
		if (matrix.length == 0)
			return ans;
		int R = matrix.length, C = matrix[0].length;
		boolean[][] seen = new boolean[R][C];
		// 这个数组和di是为了确定顺时针转的
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int r = 0, c = 0, di = 0;
		for (int i = 0; i < R * C; i++)
		{
			ans.add(matrix[r][c]);
			seen[r][c] = true;
			int cr = r + dr[di];
			int cc = c + dc[di];
			if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc])
			{
				r = cr;
				c = cc;
			}
			else
			{
				di = (di + 1) % 4;
				r += dr[di];
				c += dc[di];
			}
		}
		return ans;
	}

	/**
	 * 采用1层1层往下剥离
	 *
	 * @param matrix
	 * @return
	 */
	// 总结:这个逻辑是按照1层1层的进去 然后进行遍历
	public List<Integer> spiralOrder(int[][] matrix)
	{
		ArrayList<Integer> result = new ArrayList<>();
		if (matrix.length < 1)
			return result;

		// 行
		int r1 = 0;
		// 列
		int c1 = 0;

		int r2 = matrix.length-1;
		int c2 = matrix[0].length -1;
		while (r1 <= r2 && c1 <= c2)
		{
			// 顶层
			// 列的增加 行在起点
			for (int c = c1; c <= c2; c++)result.add(matrix[r1][c]);
			// 右边
			// 行的增加 但是列已经到达尽头
			for (int r = r1+1; r <= r2; r++)result.add(matrix[r][c2]);
			if (r1 < r2 && c1 < c2) {
				// 底层
				// 列的减少 行在尽头
				for (int c = c2-1; c > c1; c--)result.add(matrix[r2][c]);
				// 左边
				// 行的减少 列在起点
				for (int r = r2; r > r1; r--)result.add(matrix[r][c1]);
			}
			r1++;
			r2--;
			c1++;
			c2--;
		}

		return result;

	}

	public static void main(String[] args)
	{
		// 3*2
		int[][] arr = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		_54_螺旋矩阵 obj = new _54_螺旋矩阵();
		List<Integer> list = obj.spiralOrder(arr);
		System.out.println(list);

	}

}
