package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class Q_77 {
//组合。求出所有组合                                pass
	public static void main(String[] args) {
		System.out.println(combine(1,4,3));

	}
	public static List<List<Integer>> combine(int m, int n, int k) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(k == 1) {
			for(int i = m; i <= n; i++) {
				List<Integer> oneList = new ArrayList<Integer>(i);
				oneList.add(i);
				ans.add(oneList);
			}
			return ans;
		}
		for(int i = m; i <= n - k + 1; i++) {
			for(List<Integer> each : combine(i + 1, n, k - 1)) {
				List<Integer> oneList = new ArrayList<Integer>();
				oneList.add(i);
				oneList.addAll(each);
				ans.add(oneList);
			}
		}
		return ans;
	}

}
