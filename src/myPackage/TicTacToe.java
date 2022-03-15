package myPackage;


public class TicTacToe {

	public static void main(String[] args) {
		//Variable declaration
		char [][] board = {{'_','_','_'},
				           {'_','_','_'},
		                   {'_','_','_'}
		                  };
		int turn = 0;
		int [] rowCol = new int[2];
		boolean isResult = false;
		
		System.out.println("::::********************::::");
		System.out.println("   Welcomr to Tic Tac Toe   ");
		System.out.println("::::********************::::");
		Operations.printBoard(board);
		System.out.println("Lets Play!");
		
			do {
				boolean change = Operations.takeInput(rowCol,turn);
				if((rowCol[0]>=0 && rowCol[0] < 3)&&( rowCol[1]>=0 && rowCol[1] < 3)) {
				boolean changeTurn = Operations.modifyBoard(board,rowCol[0],rowCol[1],turn,change);
				Operations.printBoard(board);
				int result =Operations.checkResult(board);
				if(result == 3) {
					System.out.println("X win");
					isResult = true;
					break;
				}
				if(result == -3) {
					System.out.println("O win");
					isResult = true;
					break;
				}
				if(changeTurn)
					turn++;
				}
				else
					System.out.println("Enter row and coloumn in range 0 to 2.");
		
		}while(turn < 9);	
			
			if(!isResult)
				System.out.println("It's tie");
	}

}
