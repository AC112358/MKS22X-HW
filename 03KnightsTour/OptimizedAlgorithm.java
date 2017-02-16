public class OptimizedAlgorithm{
    int[][] board;
    int[][][] branchBoard;
    public OptimizedAlgorithm(int rows, int cols){
	board = new int[rows][cols];
	branchBoard = new int[rows][cols];
	initBranches();
    }
    private void initBranches(){
	for (int i = 0; i < branchBoard.length; i++){
	    for (int j = 0; j < branchBoard[0].length; j++){
		int len = 0;
		int[] locns = new int[8];
		for (int x = -2; x <= 2; x++){
		    for (int y = -2; y <= 2; y++){
			if (((Math.abs(x) == 2 && Math.abs(y) == 1) ||
			    (Math.abs(x) == 1 && Math.abs(y) == 2)) &&
			    (i + x < branchBoard.length && i + x >= 0 &&
			     j + y < branchBoard[0].length && j + y >= 0)){
			    locns[len] = (i+x)*board[0].length + (j+y);
			    len++;
			}
		    }
		}
		int[] temp = new int[len];
		branchBoard[i][j] = temp;
	    }
	}
    }

    public class MyComparator implements Comparator<Integer>{
	@Override
	public int compare(int i1, int i2){
	    return branchBoard[getXVal(i1)][getYVal(i1)].length - branchBoard[getXVal(i2)][getYVal(i2)].length;
	}
    }

    public int getXVal(int i1){
	return i1/board[0].length;
    }

    public int getYVal(int i1){
	return i1 % board[0].length;
    }


    public void solve(int row, int col, int level){
	board[row][col] = level;
	if (level >= board.length * board[0].length){
	    return true;
	}
        Arrays.sort(branchBoard[row][col], new MyComparator());
	for (int i : branchBoard[row][col]){
	    if (solve(getXVal(i), getYVal(i), level+1){
		    return true;
		}
	}
	    board[row][col] = 0;
	    return false;
    }
}
