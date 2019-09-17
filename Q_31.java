package leetcode;

import java.util.Arrays;

public class Q_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,5,1};
		nextPermutation(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}

	}
	
	public static void nextPermutation(int[] nums){
		int numsLength = nums.length;
		if(isTrue(nums, 0) == true){
			Arrays.sort(nums);
			return;
		}
		for(int j = 0; j < nums.length - 1; j++){
			System.out.println(isTrue(nums, j + 1));
			if(isTrue(nums, j + 1) == false){
				continue;
			}else{
				int index = j;
				for(int k = j + 1; k < numsLength; k++){
					if(nums[j] >= nums[k]){
						break;
					}else{
						index = k;
					}
				}
				System.out.println("the j and k are " + j + " " + index);
				int temp = nums[j];
				nums[j] = nums[index];
				nums[index] = temp;
				Arrays.sort(nums,j + 1,numsLength);
				break;
			}
		}
		
	}
	
	public static boolean isTrue(int[] list, int index){
		if(index == list.length)
			return true;
		for(int i = index; i < list.length - 1; i++){
			if(list[i] < list[i + 1])
				return false;
		}
		return true;
	}

}
