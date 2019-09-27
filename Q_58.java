package leetcode;

public class Q_58 {
                                         // Í¨¹ı
	public static void main(String[] args) {
		String s = "a ";
		System.out.println(lengthOfLastWord(s));

	}
	public static int lengthOfLastWord(String s) {
		int last = -1;
		int start = -1;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(' ' == s.charAt(i))
				continue;
			last = i;
			System.out.println("last is " + last);
			break;
		}
		for(int i = last; i >= 0; i--) {
			if(s.charAt(i) != ' ')
				continue;
			start = i;
			System.out.println("start is " + start);
			break;
		}
		return last - start;
	}

}
