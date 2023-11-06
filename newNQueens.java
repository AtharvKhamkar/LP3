import java.util.*;

public class newQueens{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of queens: ");
		int n = sc.nextInt();
		long inputTime = System.currentTimeMillis();
		int[][] board = new int[n][n];
		if(placeQueens(board,0,n)){
			long outputTime = System.currentTimeMillis();
			displayBoard(board);
		}else{
			System.out.println("Queens cannot be placed");
		}
	}
	
	public static boolean isSafe(int[][] board,int row,int col,int n){
		//for checking column of the board
		for(int row = 0;row<n;row++){
			if(board[row][col] == 1){
				return false;
			}
		}
		
		//for checking right upper diagonal
		for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			if(board[row][col] == 1){
				return false;
			}
		}
		
		//for checking left upper diagonal
		for(int i=row,j=col;i>=0 && j<n;i--,j++){
			if(board[row][col] == 1){
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean placeQueens(int[][] board,int row,int n){
		if(row==n){
			return true;
		}
		for(int col=0;col<n;col++){
			if(isSafe(board,row,col,n)){
			board[row][col] = 1;
			
			if(placeQueens(board,row+1,n)){
				return true;
			}
			
			
			board[row][col] = 0;
			}
		
		}
		
		return false;
		
	}
	
	public void displayBoard(int[][] board){
		for(int row=0;row<n;row++){
			for(int col=0;col<n;col++){
				if(board[row][col] == 1){
					System.out.print("Q ");
				}else{
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

