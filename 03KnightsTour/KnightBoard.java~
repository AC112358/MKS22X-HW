public class KnightBoard{
    int[][] board;
    boolean solveCalled = false;
    public KnightBoard(int rows, int columns){
	board = new int[rows][columns];
    }

    public void solve(){
	boolean solveH = false;
	int index = 0;
	while (!solveH && index < board.length*board[0].length){
	    //  System.out.println(index/board[0].length + "," +  (index - (index/board.length)*board[0].length));
	    solveH = solveH(index/board[0].length, index - (index/board.length)*board[0].length, 1);
	    index++;
	}
	solveCalled = solveH;
    }

    private boolean solveH(int row, int col, int level){
	board[row][col] = level;
	if (level >= board.length*board[0].length){
	    return true;
	}
	for (int i = -2; i <= 2; i++){
	    for (int j = -2; j <= 2; j++){
		if ((Math.abs(i) == 2 && Math.abs(j) == 1) || 
		    (Math.abs(i) == 1 && Math.abs(j) == 2)){
		    if (row + i >= 0 && row + i < board.length &&
			col + j >= 0 && col + j < board[0].length &&
			board[row+i][col+j] == 0){
			if (solveH(row+i, col+j, level+1)){
			    return true;
			}
		    }
		}
	    }
	}
	board[row][col] = 0;
	return false;
    }
    
    public String toString(){
	String total = "";
	if (solveCalled){
	    for (int i = 0; i < board.length; i++){
		for (int j = 0; j < board[0].length; j++){
		    if (board[i][j]/10 == 0){
			total += " ";
		    }
		    total += board[i][j] + " ";
		}
		total += "\n";
	    }
	}else{
	    for (int i = 0; i < board.length; i++){
		for (int j = 0; j < board[0].length; j++){
		    total += "-";
		}
		total += "\n";
	    }
        }
	return total;
    }
   /* public static void main(String[] args){
	KnightBoard k = new KnightBoard(4, 4);
	k.solve();
	System.out.println(k);
	k = new KnightBoard(8, 8);
	k.solve();
	System.out.println(k);
    }*/
}
