package leetcode;

public class Q_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,7,7,8,8,10};
		int[] array = searchRange(nums, 8);
		System.out.println(array[0]);
		System.out.println(array[1]);
		
		

	}
	public static int[] searchRange(int[] nums, int target){
		int leftIndex = 0;
		int rightIndex = nums.length - 1;
		int index1, index2 = -1;
		int[] result = {-1, -1};
		while(leftIndex + 1 !=  rightIndex) {
			int temp_halfIndex = (leftIndex + rightIndex) / 2;
			System.out.println("the half index is " + temp_halfIndex);
			if(nums[temp_halfIndex] < target) {
				leftIndex = temp_halfIndex;
			}else if(nums[temp_halfIndex] > target) {
				rightIndex = temp_halfIndex;
			}else {
				System.out.println("the index where equals is " + temp_halfIndex);
				index1 = temp_halfIndex;
				index2 = temp_halfIndex;
				for(int i = temp_halfIndex; i >= 0; i--) {
					if(nums[i] == target){
						index1 = i;
					}else{
						break;
					}
				}
				for(int i = temp_halfIndex; i < nums.length; i++){
					if(nums[i] == target){
						index2 = i;
					}else{
						break;
					}
				}
				result[0] = index1;
				result[1] = index2;
				System.out.println("the indexs are " + index1 + " " + index2);
				break;
			}
			
		}
		
		return result;
	}

}
