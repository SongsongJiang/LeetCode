package leetcode;
public class Q_38 {
//                                                                (ͨ����ʹ�õݹ麯��)
//�������������һ����
	public static void main(String[] args) {
		String s = countAndSay(5);
		System.out.println(s);

	}
	public static String countAndSay(int n) {
		if(n == 1)
			return "1";
		String lastString = countAndSay(n-1);
//		System.out.println("the last which is " + (n -1) + "   is " + lastString);
		String result = "";
		int index1 = 0;
		while(index1 < lastString.length()){
			char tempChar = lastString.charAt(index1);
			int count = 0;
			while(index1 < lastString.length() &&lastString.charAt(index1) == tempChar){
				index1 += 1;
				count += 1;
			}
			result =result + "" + Integer.toString(count) + tempChar;
//			System.out.println(result);
		}
		return result;
	}
	

}
