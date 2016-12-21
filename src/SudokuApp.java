import java.util.Random;

public class SudokuApp {

	public static void main(String[] args) {
		Sudoku mySudoku = new Sudoku(5000);
 		System.out.println(mySudoku.toString());		
 		mySudoku.hide(50);
		System.out.println(mySudoku);
		
//		Sudoku mySudoku = new Sudoku(100000);	
//		Sudoku mySudoku = new Sudoku();
//		mySudoku.randomPermutation(10000000);
//		mySudoku.transpose();
//		mySudoku.permutateStack();
//		mySudoku.permutateBand();	
//		mySudoku.permutateBand(1,2);
//		mySudoku.permutateStack(1,2);	
//		mySudoku.permutateColumns(0,1);	
//		mySudoku.permutateRows(3, 4);

//		

	}

}
