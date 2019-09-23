package leetcode;

import java.util.ArrayList;
import java.util.List;
//找出全排列                                                                 通过
public class Q_46 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(permute(nums));


	}
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		if(nums.length == 1) {
			List<Integer> temp_list = new ArrayList<Integer>();
			temp_list.add(nums[0]);
			answer.add(temp_list);
		}else {
			for(int i = 0; i < nums.length; i++) {
				List<List<Integer>> sub_List = permute(getSubArray(nums, i));
				for(int j = 0; j < sub_List.size(); j++) {
					List<Integer> temp_list = new ArrayList<Integer>();
					temp_list.add(nums[i]);
					temp_list.addAll(sub_List.get(j));
//					System.out.println("temp_list is " + temp_list);
					answer.add(temp_list);
					
				}
			}
		}
		return answer;
	}
	public static int[] getSubArray(int[] array, int index1) {
		int[] subArray = new int[array.length - 1];
		for(int index = 0; index < array.length; index++) {
			if(index < index1) {
				subArray[index] = array[index];
			}else if(index > index1) {
				subArray[index - 1] = array[index];
			}
		}
		return subArray;
	}

}
