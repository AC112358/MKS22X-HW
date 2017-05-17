public class MazeSolver{
    Maze maze;
    static final char WALL = '#';
    static final char VISITED = '@';
   
    public MazeSolver(String filename){
	this(filename, false);
    }
    public MazeSolver(String filename, boolean animate){
	maze = new Maze(filename, animate);
    }

    public void solve(){
	solve(1);
    }

    public static int dist(int r1, int c1, int r2, int c2){
	return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public void solve(int style){
	boolean aStar = false;
	if (style == 3){
	    aStar = true;
	} 
	Frontier[] f = {new FrontierStack(), new FrontierQueue(), new FrontierPriorityQueue(), new FrontierPriorityQueue()};
        Frontier frontier = f[style - 1];
	int startRow = maze.start.getRow();
	int startCol = maze.start.getCol();
	int endRow = maze.end.getRow();
	int endCol = maze.end.getCol();
	Location start = new Location(startRow, startCol, null, 0, dist(startRow, startCol, endRow, endCol), aStar);
	Location end = new Location(endRow, endCol, null, 0, 0, aStar);
	frontier.add(start);
	Location node = start;
	while (frontier.hasNext() && !(node.getRow() == endRow && node.getCol() == endCol)){
	    node = frontier.next();
	    for (int i = -1; i <= 1; i++){ //check node's neighbors & visit them and add them to frontier
		for (int j = -1; j <= 1; j++){
		    if ((i == 0 || j == 0) && i != 0){ //check if one of the 4 immediate neighbors
			int row = i + node.getRow();
			int col = j + node.getCol();
			if (row <= maze.maxRow() && col <= maze.maxCol()){ //check if on board
			    char c = maze.getCharAt(row, col);
			    if (c != WALL && c != VISITED){
				frontier.add(new Location(row, col, node, node.getDistToStart() + 1, dist(row, col, endRow, endCol), aStar));
				maze.setChar(row, col, VISITED);
				
			    }
			}
		    }
		}
	    }
	    // System.out.println(maze);
	}
    }

    public String toString(){
	return maze.toString();
    }

}
