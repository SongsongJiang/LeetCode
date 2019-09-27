package leetcode;

import java.util.Arrays;

public class Q_60 {
//µÚk¸öÅÅÁĞ     pass
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
//		System.out.println(getPermutation1(nums, 25));
		System.out.println(getPermutation(2, 1));
		System.out.println();
		System.out.println(getPermutation(4, 9));
		System.out.println(getPermutation(3, 2));
	}
	public static String getPermutation(int n, int k) {
		if(n==2){
			if(k ==1)
				return "12";
			return "21";
		}
		int[] nums = new int[n];
		int number = 1;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = number;
			number += 1;
		}
		int[] judge = new int[n];
		number = 1;
		for (int i = 0; i < nums.length; i++) {
			judge[i] = number;
			number += 1;
		}
	 
		return getPermutation1(nums, judge,k, n);
	}
	static int count = 1;
	public static String getPermutation1(int[] nums, int[] judge,int k,int n) {
		
		if(nums.length == 1){
			
			count += 1;
			return "" + nums[0];
		}
		String temp_s = "";
		for(int i = 0; i < nums.length; i++) {
			
			if(count == k + 1) {
				if(nums.length == judge.length)
					count = 1;
				return ""  + temp_s;
			}else{
				int[] temp_nums = getSubNums(nums, i);
//				for (int j = 0; j < temp_nums.length; j++) {
//					System.out.print("#" + temp_nums[j]);
//				}
//				System.out.println();
				
				temp_s = "" + nums[i] + getPermutation1(temp_nums, judge,k,temp_nums.length);
//				System.out.println("count is " + count);
//				System.out.println("temp_s is " + temp_s);
			}
			
		}
		return "" + temp_s;
	}
	public static int[] getSubNums(int[] nums, int index) {
		int[] subNums = new int[nums.length - 1];
		for(int k = 0; k < nums.length; k++) {
			if(k < index){
				subNums[k] = nums[k];
			}else if(k > index){
				subNums[k -1] = nums[k];
			}
		}
		return subNums;
	}

}
