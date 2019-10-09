package leetcode;

import java.util.Stack;

public class Q_71 {
// ¼ò»¯Â·¾¶£¨simplify the path£©                          pass
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans = simplifyPath("/../");
		System.out.println("ans is " + ans);
	}
	public static String simplifyPath(String path) {
		Stack<String> sta = new Stack<>();
//		System.out.println(sta.isEmpty());
		char[] ch = path.toCharArray();
		String[] s = path.split("/");
		for (int i = 0; i < s.length; i++) {
			if(!s[i].equals("")) {
				if(s[i].equals("..") && !sta.isEmpty()){
					sta.pop();
				}if(!s[i].equals(".") && !s[i].equals("..")){
					sta.push(s[i]);
				}
			}
		}
		int num = sta.size();
		if(num == 0)
			return "/";
		String[] s1 = new String[num];
		while(!sta.isEmpty()){
			num -= 1;
//			System.out.println(sta.peek());
			s1[num] = sta.pop();
		}
		String ans = "";
		for (int i = 0; i < s1.length; i++) {
//			System.out.print("  " + s1[i]);
			ans += "/" + s1[i];
		}
		return ans;
	}

}
