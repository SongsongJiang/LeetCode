package leetcode;

import java.util.Arrays;

public class Q_63 {
//²»Í¬Â·¾¶  2                                        pass
	public static void main(String[] args) {
		int[][] test = {
				{0,1},
				{0,0},
		};
		System.out.println(uniquePathsWithObstacles(test));

	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] nums = new int[m][n];
		int index1 = -1;
		for(int i = 0; i < n; i++) {
			if(obstacleGrid[m - 1][i] == 1)
				index1 = i;
		}
		
		for(int i = 0; i < n; i++){
			if(i <= index1){
				nums[m-1][i] = 0;
			}else{
				nums[m-1][i] = 1;
			}
		}
		
		
		int index2 = -1;
		for(int i = 0; i < m; i++) {
			if(obstacleGrid[i][n - 1] == 1)
				index2 = i;
		}
		
		for(int i = 0; i < m; i++){
			if(i <= index2){
				nums[i][n - 1] = 0;
			}else{
				nums[i][n - 1] = 1;
			}
		}
		for(int i = m - 2; i >= 0; i--) {
			int temp_count = nums[i][n - 1];
			for(int j = n - 2; j >= 0; j--) {
				if(obstacleGrid[i][j] == 1){
					
					temp_count = 0;
				}else{
					nums[i][j] = temp_count + nums[i + 1][j];
					temp_count = nums[i][j];
					System.out.println("temp count is " + temp_count);
				}
				
			}
		}
		return nums[0][0];
	}

}
