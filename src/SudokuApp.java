import java.util.Random;

public class SudokuApp {

	public static void main(String[] args) {
		

		
//		Sudoku mySudoku = new Sudoku(100000);	
//		Sudoku mySudoku = new Sudoku();
		Sudoku mySudoku = new Sudoku(100);
 		System.out.println(mySudoku.toString());
		
//		mySudoku.randomPermutation(10000000);
//		mySudoku.transpose();
//		mySudoku.permutateStack();
//		mySudoku.permutateBand();	
//		mySudoku.permutateBand(1,2);
//		mySudoku.permutateStack(1,2);	
//		mySudoku.permutateColumns(0,1);	
//		mySudoku.permutateRows(3, 4);
		System.out.println(mySudoku.toString());
//		
		int[] randRow = Sudoku.randomRow2(5);
		for (int i=0; i<randRow.length;i++) System.out.print(randRow[i]+" ");
		System.out.println();
	}

}
