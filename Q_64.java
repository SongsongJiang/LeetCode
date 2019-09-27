package leetcode;

public class Q_64 {
//最小路径和                                                                                                             pass
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {
				{1,3,1},
				
		};
		System.out.println(minPathSum(test));

	}
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] ansArray = new int[m][n];
		int temp_sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			ansArray[m - 1][i] = grid[m - 1][i] + temp_sum;
			temp_sum = ansArray[m - 1][i];
		}
		temp_sum = 0;
		for (int i = m - 1; i >= 0; i--) {
			ansArray[i][n - 1] = grid[i][n - 1] + temp_sum;
			temp_sum = ansArray[i][n - 1];
		}
		int temp_min;
		for(int i = m - 2; i >= 0; i--) {
			for(int j = n - 2; j >= 0; j--) {
				temp_min = Math.min(ansArray[i][j + 1], ansArray[i + 1][j]);
				ansArray[i][j] = grid[i][j] + temp_min;
			}
		}
		return ansArray[0][0];
	}

}
