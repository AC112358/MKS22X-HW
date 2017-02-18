import java.util.Arrays;
import java.util.Comparator;

public class KnightBoard{
    int[][] board;
    int[][][] branchBoard;
	int[][] branchNums;
    boolean solveCalled = false;
    public KnightBoard(int rows, int cols){
	board = new int[rows][cols];
	branchBoard = new int[rows][cols][];
	branchNums = new int[rows][cols];
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
				//System.out.print(getXVal(locns[len]) + "," + getYVal(locns[len]) + " ");
			    len++;
			}
		    }
		}
		//System.out.println();
		branchNums[i][j] = len;
		//System.out.println(i + "," + j + ": " + len);
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


    public void solveFast(){
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		if (solve(i, j, 1)){
			solveCalled = true;
		    return;
		}
	    }
	}
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
	
    public boolean solve(int row, int col, int level){
		board[row][col] = level;
		addTo(row, col, -1);
		if (level >= board.length * board[0].length){
			return true;
		}
			//Arrays.sort(branchBoard[row][col], new MyComparator());
			sort2(branchBoard[row][col]);
			/*for (int i : branchBoard[row][col]){
				System.out.print(branchNums[getXVal(i)][getYVal(i)] + " ");
			}
			System.out.println();*/
		for (int i : branchBoard[row][col]){
			//System.out.println(getXVal(i) + " " + getYVal(i));
			if (board[getXVal(i)][getYVal(i)] == 0 && solve(getXVal(i), getYVal(i), level+1)){
				return true;
			}
		}
			board[row][col] = 0;
			addTo(row, col, 1);
			return false;
    }

	
	/*public void addTo(int row, int col, int add){
		for (int b : branchBoard[row][col]){
			if (board[getXVal(b)][getYVal(b)] == 0){
				branchBoard[getXVal(b)][getYVal(b)] += add;
			}
				}
	}*/
	
	public void addTo(int row, int col, int add){
		for (int b : branchBoard[row][col]){
			if (board[getXVal(b)][getYVal(b)] == 0){
				branchNums[getXVal(b)][getYVal(b)] += add;
			}
		}
	}
	
	
	public void sort(int[] arr){
		int mindex = 0;
		int index = 0;
		int minLen = 0;
		int len = 0;
		while (index < arr.length){
			mindex = index;
			len = 0;
			for (int i = index; i < arr.length; i++){
				len = 0;
				for (int b : branchBoard[getXVal(arr[i])][getYVal(arr[i])]){
					if (board[getXVal(b)][getYVal(b)] == 0){
						len++;
					}
				}
				if (minLen > len){
					minLen = len;
					mindex = index;
				}
				/*if (branchBoard[getXVal(arr[i])][getYVal(arr[i])].length <
					branchBoard[getXVal(arr[mindex])][getYVal(arr[mindex])].length){
					mindex = i;
				}*/
			}
			int temp = arr[mindex];
			arr[mindex] = arr[index];
			arr[index] = temp;
			index++;
		}
	}
	
	public void sort2(int[] arr){
		int mindex = 0;
		int index = 0;
		int minLen = 0;
		int len = 0;
		while (index < arr.length){
			mindex = index;
			len = 0;
			for (int i = index; i < arr.length; i++){
				len = 0;
				if (branchNums[getXVal(arr[i])][getYVal(arr[i])] <
					branchNums[getXVal(arr[mindex])][getYVal(arr[mindex])]){
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
	    KnightBoard oa = new KnightBoard(60, 60);
	    oa.solveFast();
	    System.out.println(oa);
	}
}
