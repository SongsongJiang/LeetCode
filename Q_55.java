package leetcode;

public class Q_55 {
//ÌøÔ¾ÓÎÏ·(jump game)              pass
	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(canJump(nums));

	}
	public static boolean canJump(int[] nums) {
		int index = nums.length - 1;
		for(int i = nums.length - 2; i >= 0; i--) {
			if(i + nums[i] >= index) {
				index = i;
			}
		}
		return index == 0 ? true : false;
	}

}
