package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;
//ĞıÂİ¾ØÕó                                                        Í¨¹ı
public class Q_54 {

	public static void main(String[] args) {
		int[][] matrix= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
//				{13,14,15,16},
//				{17,18,19,20}
		};
		spiralOrder(matrix);

	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		int min_x = 0;
		int min_y = 0;
        if(matrix.length == 0)
            return ans;
		int max_x = matrix.length - 1;
		int max_y = matrix[0].length - 1;
		while(min_x <= max_x && min_y <= max_y) {
			for(int i = min_y; i <= max_y; i++) {
				ans.add(matrix[min_x][i]);
			}
			System.out.println("after first round is " + ans);
			min_x += 1;
			if(!(min_x <= max_x && min_y <= max_y))
				break;
			for(int j = min_x; j <= max_x; j++) {
				ans.add(matrix[j][max_y]);
			}
			System.out.println("after second round is " + ans);
			max_y -= 1;
			if(!(min_x <= max_x && min_y <= max_y))
				break;
			for(int i = max_y; i >= min_y; i--) {
				ans.add(matrix[max_x][i]);
			}
			System.out.println("after third round is " + ans);
			max_x -= 1;
			if(!(min_x <= max_x && min_y <= max_y))
				break;
			for(int j = max_x; j >= min_x; j--) {
				ans.add(matrix[j][min_y]);
			}
			System.out.println("after fourth round is " + ans);
			min_y += 1;
			System.out.println();
			System.out.println();
		}
		return ans;
	}

}
