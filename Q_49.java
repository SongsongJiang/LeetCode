package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//字母异位词分组                                                                                                       通过
public class Q_49 {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));

	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String,List<String>> map = new HashMap<>();
		int[] count = new int[26];
		for(String s : strs) {
			Arrays.fill(count, 0);
			for(char c : s.toCharArray()) {
				count[c - 'a'] += 1;
			}
			String s1 = "";
			for(int i : count) {
				s1 += "#" + i;
			}
//			System.out.println("the s is " + s1);
			if(!map.containsKey(s1)) {
//				System.out.println("not yet");
				List<String> temp_list = new ArrayList<String>();
				temp_list.add(s);
				map.put(s1, temp_list);
			}else {
//				List<String> temp_list= map.get(s1);
//				temp_list.add(s);
//				System.out.println(temp_list);
//				map.put(s1, temp_list);
				map.get(s1).add(s);
			}
		}
		List<List<String>> answer = new ArrayList<>(map.values());
		return answer;
	}

	

}
