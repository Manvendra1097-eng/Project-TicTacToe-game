package myPackage;

import java.util.Scanner;

public class Operations {

	static Scanner scan = new Scanner(System.in);
	public static void printBoard(char[][] board) {

		for(int i=0;i < 3;i++) {
			System.out.println("\t"+board[i][0]+"  "+board[i][1]+"  "+board[i][2]+"\n");
		}

	}
	
	public static boolean takeInput(int[] rowCol,int turn) {
		boolean change = true;
		try {
			if(turn%2==0) {
				System.out.println("Turn:X choose row and column OR enter 100 to exit application");
				rowCol[0] = scan.nextInt()-1;
				if(rowCol[0] == 100) {
					System.exit(0);
				}
				rowCol[1] = scan.nextInt()-1;
			}
			else
			{
				System.out.println("Turn:O choose row and column OR enter 100 to exit application");
				rowCol[0] = scan.nextInt();
				if(rowCol[0] == 100) {
					System.exit(0);
				}
				rowCol[1] = scan.nextInt();
			}
		}
		catch (Exception e) {
			System.out.println("## Enter integer in range 1 to 3 only ##\n");
			change = false;
			scan.next();
		}
		return change;
	}

	public static boolean modifyBoard(char[][] board, int row, int column,int turn,boolean change) {
        boolean sameTurn = false;
        if(change) {
        	if(board[row][column] == '_') {
        		if(turn % 2 ==0)
        			board[row][column] = 'X';
        		else
        			board[row][column] = 'O';
        		sameTurn = true;
        	}
        	else {
        		System.out.println("Already spot occupied");
        	}
        }
			
		return sameTurn;
	}

	public static int checkResult(char[][] board) {
		int count=0;
		//for straight row
		for(int i = 0;i < 3;i++) {
			count = 0;
			for(int j = 0;j <3;j++) {
				if(board[i][j] == 'X') {
					count++;
				}
				if(board[i][j] == 'O') {
					count--;
				}
			}
			if(count == 3 || count == -3) {
				return count;
			}
		}

			// for straight column
			for(int i = 0;i < 3;i++) {
				count = 0;
				for(int j = 0;j <3;j++) {
					if(board[j][i] == 'X') {
						count++;
					}
					if(board[j][i] == 'O') {
						count--;
					}
				}
				if(count == 3 || count == -3)
					return count;
			}

			// for right diagonal
			count = 0;
			for(int i = 0;i < 3;i++) {
				if(board[i][i] == 'X') {
					count++;
				}
				if(board[i][i] == 'O') {
					count--;
				}
				if(count == 3 || count == -3)
					return count;
			}

			// for left diagonal
			count = 0;
			for(int i = 0;i < 3;i++) {
				if(board[i][2-i] == 'X') {
					count++;
				}
				if(board[i][2-i] == 'O') {
					count--;
				}
				if(count == 3 || count == -3)
					return count;
			}
		return -15;
	}
}
