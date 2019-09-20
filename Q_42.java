package leetcode;

public class Q_42 {

	public static void main(String[] args) {
//		int[] height = {0,1,0,2,1,0,1,4,3,4,2,1,2,1};
		int[] height = {4,5,2,3};
 		System.out.println(trap(height));

	}
	public static int trap(int[] height) {
		int sum = 0;
		int left = 0;
		while(left < height.length) {
			if(height[left] == 0){
				left += 1;
				continue;
			}
			int right = hasBigger(left, height);
			if(right == -1){
				int third = findTheBiggest(left, height);
				if(third == -1){
					left += 1;
				}else{
					int temp_sum = 0;
					for(int j = left + 1; j < third; j++) {
						temp_sum += height[j];
					}
					sum += height[third] * (third - left - 1) - temp_sum;
					left = third;
				}
			}else {
				int temp_sum = 0;
				for(int j = left + 1; j < right; j++) {
					temp_sum += height[j];
				}
				sum += height[left] * (right - left - 1) - temp_sum;
//				System.out.println(sum);
				left = right;
			}
		}
		return sum;
	}
	public static int hasBigger(int index1, int[] height) {
		for(int index2 = index1 + 1; index2 < height.length; index2++) {
			if(height[index2] < height[index1]) {
				continue;
			}else{
//				System.out.println("the index2 is " + index1 + "   " + index2);
				return index2;
				
			}
		}
		return -1;
	}
	
	public static int findTheBiggest(int index1, int[] height) {
		if(index1 == height.length) 
			return -1;
		int temp_max = -1;
		int temp_index = -1;
		for(int index2 = index1 + 1; index2 < height.length; index2++) {
			if(height[index2] > temp_max) {
				temp_max = height[index2];
				temp_index = index2;
			}
		}
		if(temp_max == 0 || temp_index == index1 + 1)
			return -1;
		
		return temp_index;
	}

}
