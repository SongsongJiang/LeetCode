package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q_47 {
// 全排列，输入可以重复，上一题不能重复                                       通过
	public static void main(String[] args) {
		int[] nums = {1,1,3};
		System.out.println(permuteUnique(nums));

	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		if(nums.length == 1) {
			List<Integer> temp_list = new ArrayList<Integer>();
			temp_list.add(nums[0]);
			answer.add(temp_list);
		}else {
			for(int i = 0; i < nums.length; i++) {
				boolean needContinue = true;
				for(int k = 0; k < i; k++) {
					if(nums[i] == nums[k]) {
						needContinue = false;
						break;
					}
				}
				if(needContinue == false)
					continue;
				List<List<Integer>> sub_List = permuteUnique(getSubArray(nums, i));
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
