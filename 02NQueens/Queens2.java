public class Queens2 {
	public static int NQueens(boolean[][] board, int index){
		if (index < 0){
			return 1;
		}
		int total = 0;
		for (int i = 0; i < board[index].length; i++){
			if (!board[index][i]){
				total += NQueens(updateBoard(board, index, i), index-1);
			}
		}
		return total;
	}
	public static boolean[][] updateBoard(boolean[][] board, int r, int c){
		boolean[][] temp = new boolean[board.length][board.length];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				temp[i][j] = board[i][j];
			}
		}
		for (int x = -1; x <= 1; x++){
			for (int y = -1; y <= 1; y++){
				if (!(x==0 && y==0)){
					int i = r; int j = c;
					while (i >= 0 && i < board.length && j >= 0 && j < board.length){
						temp[i][j] = true;
						i += x;
						j += y;
					}
				}
			}
		}
		return temp;
	}
	public static String boardString(boolean[][] board){
		String total = "";
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				if (board[i][j]){
					total += "Q";
				}else{
					total += "-";
				}
			}
			total += "\n";
		}
		return total;
	}
	public static void main(String[] args){
	    /*	final int LEN = 8;
		boolean[][] hi = new boolean[LEN][LEN];
		//System.out.println(boardString(hi));
		//System.out.println(boardString(updateBoard(hi, 2, 2)));
		System.out.println(NQueens(hi, hi.length-1));*/
	    for (int i = 2; i < 16; i++){
		boolean[][] hi = new boolean[i][i];
		double start = System.nanoTime();
	        int queens = NQueens(hi, hi.length-1);
		double end = System.nanoTime();
		System.out.println(i + ": "+ queens + " " + (end - start));
	    }
   
	}
}
