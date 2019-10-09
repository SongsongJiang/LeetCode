package leetcode;

public class Q_70 {
// clim stairs(ÅÀÂ¥ÌÝ)               pass
	public static void main(String[] args) {
		System.out.println("the ans is " + climStares(5));

	}
	public static int climStares(int n) {
		int last = 1;
		int beforeLast = 1;
		for(int i = n - 2; i >= 0; i--) {
			int temp = beforeLast;
			beforeLast = temp + last;
			last = temp;
//			System.out.println("i is " + i);
		}
		return beforeLast;
	}

}
