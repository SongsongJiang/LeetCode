package leetcode;
import java.util.ArrayList;
import java.util.List;
//                                                            （通过，采用递归思想，但时间复杂度似乎不高）
public class Q_39 {
//求组合的总数，，采用递归算法（回溯？）
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,5,6,8,9};
		System.out.println(combinationSum(candidates, 8));

	}
	public static List<List<Integer>> combinationSum(int[] candidates,int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i < candidates.length; i++){
			int num1 = target / candidates[i];
			//递归时使用的Array
			int[] subArray = new int[candidates.length - i - 1];
			for(int m = 0; m < subArray.length; m++){
				subArray[m] = candidates[m + i + 1];
			}
			for(int j = num1; j > 0; j--){
				List<Integer> temp_list = new ArrayList<Integer>();
				for(int k = 0; k < j; k++){
					temp_list.add(candidates[i]);
				}
				if(j * candidates[i] == target){
					result.add(temp_list);
					continue;
				}
				//开始递归
				int subTarget = target - j * candidates[i];
				List<List<Integer>> subResult = combinationSum(subArray, subTarget);
				if(subResult.isEmpty() == true)
					continue;
				for(int n = 0; n < subResult.size(); n++){
					List<Integer> oneList = subResult.get(n);
					List<Integer> combineList = new ArrayList<Integer>();
					if(oneList.isEmpty() == true)
						continue;
					combineList.addAll(temp_list);
					combineList.addAll(oneList);
					result.add(combineList);
				}
			}
//			break;
		}
		return result;
	}

}
