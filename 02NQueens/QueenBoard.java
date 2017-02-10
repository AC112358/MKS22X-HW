public class QueenBoard{
    private int[] posns;
    private int solutionCount;
    public QueenBoard(int size){
	posns = new int[size];
    }
    
    public void solve(){
    }

    public void countSolutions(){
	//	System.out.println(posns.length);
	solutionCount = countSolutions(posns.length-1);
    }

    private int countSolutions(int index){
	if (index <= 0){
	    for (int i = 0; i < posns.length; i++){
		System.out.print(i + "," + posns[i] + " "); 
	    }
	    return 1;
	}
        int total = 0;

	System.out.println();
	for (int i = 0; i < posns.length; i++){
	    // System.out.println("queenFits");
	    if (queenFits(index, i)){
		//	System.out.println("posns");
		posns[index] = i;
		total += countSolutions(index-1);
	    }
	}
	return total;
    }

    private boolean queenFits(int col, int row){
	for (int i = posns.length-1; i > col; i--){
	    System.out.println(i + "," + posns[i] + " vs " + col + "," + row);
	    if (posns[i] == row || (col-i) == (row-posns[i]) || (i-col) == (row-posns[i])){
		return false;
	    }
	}
	System.out.println("\t" + col + "," + row + " fits!"); 
	return true;
    }

    public static void main(String[] args){
	QueenBoard qb = new QueenBoard(4);
        qb.countSolutions();
	System.out.println(qb.solutionCount);
    }
}
