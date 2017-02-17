import java.util.Arrays;
import java.util.Comparator;

public class OptimizedAlgorithm{
    int[][] board;
    int[][][] branchBoard;
    boolean solveCalled = false;
    public OptimizedAlgorithm(int rows, int cols){
	board = new int[rows][cols];
	branchBoard = new int[rows][cols][];
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
				//System.out.println(getXVal(locns[len]) + "," + getYVal(locns[len]));
			    len++;
			}
		    }
		}
		int[] temp = new int[len];
		for (int x = 0; x < len; x++){
			temp[x] = locns[x];
		}
		branchBoard[i][j] = temp;
	    }
	}
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
    
    class MyComparator implements Comparator<Integer>{
	public int compare(Integer i1,  Integer i2){
	    return branchBoard[getXVal(i1)][getYVal(i1)].length - branchBoard[getXVal(i2)][getYVal(i2)].length;
	}
    }

    public int getXVal(int i1){
	return i1/board[0].length;
    }

    public int getYVal(int i1){
	return i1 % board[0].length;
    }


    public void solve(){
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		if (solve(i, j, 1)){
			solveCalled = true;
		    return;
		}
	    }
	}
    }
    
    public boolean solve(int row, int col, int level){
	board[row][col] = level;
	if (level >= board.length * board[0].length){
	    return true;
	}
        //Arrays.sort(branchBoard[row][col], new MyComparator());
		sort(branchBoard[row][col]);
	for (int i : branchBoard[row][col]){
		//System.out.println(getXVal(i) + " " + getYVal(i));
	    if (board[getXVal(i)][getYVal(i)] == 0 && solve(getXVal(i), getYVal(i), level+1)){
		    return true;
		}
	}
	    board[row][col] = 0;
	    return false;
    }

	public void sort(int[] arr){
		int mindex = 0;
		int index = 0;
		while (index < arr.length){
			mindex = index;
			for (int i = index; i < arr.length; i++){
				if (branchBoard[getXVal(arr[i])][getYVal(arr[i])].length <
					branchBoard[getXVal(arr[mindex])][getYVal(arr[mindex])].length){
					mindex = i;
				}
			}
			int temp = arr[mindex];
			arr[mindex] = arr[index];
			arr[index] = temp;
			index++;
		}
	}
	
	public static void main(String[] args){
	    OptimizedAlgorithm oa = new OptimizedAlgorithm(8, 8);
	    oa.solve();
	    System.out.println(oa);
	}
}
