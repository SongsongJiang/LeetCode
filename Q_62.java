package leetcode;

import java.util.Arrays;

public class Q_62 {
//²»Í¬Â·¾¶                                                                                                        pass
	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 2));

	}
	public static int uniquePaths(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
//		if(m==2 || n == 2)
		int[][] nums = new int[m][n];
		for(int[] each : nums)
			Arrays.fill(each, 1);
		for(int i = m - 2; i >= 0; i--) {
			int temp_count = 1;
			for(int j = n - 2; j >= 0; j--) {
				nums[i][j] = temp_count + nums[i + 1][j];
				temp_count = nums[i][j];
//				System.out.println("temp count is " + temp_count);
			}
		}
		return nums[0][0];
	}

}
