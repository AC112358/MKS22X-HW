public class QueenBoard{
    private int[] posns;
    private int solutionCount;
    private boolean runSolver = false;
    private boolean runSolve = false;
    public QueenBoard(int size){
	posns = new int[size];
    }
    
    public void solve(){
	int[] temp = new int[posns.length];
	solveH(posns.length-1, temp);
	/* for (int i = 0; i < posns.length; i++){
		System.out.print(i + "," + posns[i] + " "); 
		}*/
	//System.out.println();
	posns = temp;
	runSolve = true;
    }

    private boolean solveH(int index, int[] temp){
	if (index < 0){
	    for (int i = 0; i < temp.length; i++){
		temp[i] = posns[i];
	    }
	    return true;
	}
	//	System.out.println();
	//	boolean total = false;
	for (int i = 0; i < posns.length; i++){
	    // System.out.println("queenFits");
	    if (queenFits(index, i)){
		//	System.out.println("posns");
		posns[index] = i;
	        if (solveH(index-1, temp)){
		    return true;
		}
	    }
	}
	//	return total;
	return false;
    }

    public int getSolutionCount(){
	if (runSolver){
	    return solutionCount;
	}
	return -1;
    }
    

    public void countSolutions(){
	//	System.out.println(posns.length);
	solutionCount = countSolutions(posns.length-1);
	runSolver = true;
    }

    private int countSolutions(int index){
	if (index < 0){
	    /*  for (int i = 0; i < posns.length; i++){
		System.out.print(i + "," + posns[i] + " "); 
	    }
	    System.out.println();*/
	    // System.out.println(this);
	    return 1;
	}
        int total = 0;

	//	System.out.println();
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
	    // System.out.println(i + "," + posns[i] + " vs " + col + "," + row);
	    if (posns[i] == row || (col-i) == (row-posns[i]) || (i-col) == (row-posns[i])){
		return false;
	    }
	}
	//	System.out.println("\t" + col + "," + row + " fits!"); 
	return true;
    }

    public String toString(){
	String total = "";
	for (int i = 0; i < posns.length; i++){
	    for (int j = 0; j < posns.length; j++){
		if (posns[j] == i && runSolve){
		    total += "Q";
		}else{
		    total += "-";
		}
	    }
	    total += "\n";
	}
	return total;
    }

    /* public static void main(String[] args){
	/*int[] solns = {0, 0, 2, 10, 4, 40, 92, 352, 724};
	for (int i = 0; i < solns.length; i++){
	    QueenBoard qb = new QueenBoard(i+2);
	    qb.countSolutions();
	    System.out.println(qb.solutionCount + " ?= " + solns[i]);
	}
	 QueenBoard qb = new QueenBoard(15);
	    qb.countSolutions();
	    System.out.println(qb.solutionCount);
	    }*/
    /*  public static void main(String[] args){
	QueenBoard qb = new QueenBoard(10);
		qb.solve();
		//	System.out.println(qb.getCount());
		//qb.countSolutions();
	//System.out.println(qb.getCount());
	//	qb.countSolutions();
	System.out.println(qb);
	qb.countSolutions();
	System.out.println(qb.getSolutionCount());
	}*/
}
