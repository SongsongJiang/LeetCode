package leetcode;
import java.util.HashMap;
//                                                                 (通过)
//LeetCode第36道题，判断一个9*9数独是否有效
public class Q_36 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'5','3','.'},{'5','1','.'},{'5','1','.'}};
		System.out.println(isValidSudoku(board));
	}
	public static boolean isValidSudoku(char[][] board) {
		HashMap<Integer,Integer>[] rows = new HashMap[3];
		HashMap<Integer,Integer>[] columns = new HashMap[3];
		HashMap<Integer,Integer>[] boxs = new HashMap[3];
		for(int i = 0; i < 3; i++){
			rows[i] = new HashMap<Integer,Integer>();
			columns[i] = new HashMap<Integer,Integer>();
			boxs[i] = new HashMap<Integer,Integer>();
		}
		for(int index1 = 0; index1 < 3; index1++){
			for(int index2 = 0; index2 < 3; index2++) {
				if(board[index1][index2] == '.')
					continue;
				int temp_value = (int)board[index1][index2] - (int)('0');
				System.out.println("the value is " + temp_value);
				if(!rows[index1].isEmpty() &&rows[index1].containsKey(temp_value) == true)
					return false;
				rows[index1].put(temp_value, 1);
				if(columns[index2].containsKey(temp_value))
					return false;
				columns[index2].put(temp_value, 1);
				int box_index = (index1 / 3) * 3 + index2 / 3;
				if(boxs[box_index].containsKey(temp_value))
					return false;
				boxs[box_index].put(temp_value, 1);
			}
		}
		return true;
	}

}
