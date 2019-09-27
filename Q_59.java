package leetcode;

public class Q_59 {
    //Ğı×ª¾ØÕó2 £¨54ÎªĞı×ª¾ØÕó1£©                                //pass
	public static void main(String[] args) {
		int[][] matrix = generateMatrix(4);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}

	}
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int min_x = 0;
		int min_y = 0;
		int max_x = n - 1;
		int max_y = n - 1;
		int count = 1;
		while(min_x <= max_x && min_y <= max_y) {
			for(int i = min_y; i <= max_y; i++) {
				matrix[min_x][i] = count;
				count += 1;
			}
			min_x += 1;
			if(!(min_x <= max_x && min_y <= max_y))
				break;
			for(int j = min_x; j <= max_x; j++) {
				matrix[j][max_y] = count;
				count += 1;
			}
			max_y -= 1;
			if(!(min_x <= max_x && min_y <= max_y))
				break;
			for(int i = max_y; i >= min_y; i--) {
				matrix[max_x][i] = count;
				count += 1;
			}
			max_x -= 1;
			if(!(min_x <= max_x && min_y <= max_y))
				break;
			for(int j = max_x; j >= min_x; j--) {
				matrix[j][min_y] = count;
				count += 1;
			}
			min_y += 1;

		}
		return matrix;
	}

}
