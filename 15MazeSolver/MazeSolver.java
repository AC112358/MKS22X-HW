public class MazeSolver{
    Maze maze;
    static final char WALL = '#';
    static final char VISITED = '.';
    static final char END = 'E';
    static final char ON_FRONTIER = '?';
    static final char ON_PATH = '@';
    static final char NEW_SPACE = ' ';
   
    public MazeSolver(String filename){
	this(filename, false);
    }
    public MazeSolver(String filename, boolean animate){
	maze = new Maze(filename, animate);
    }

    public void solve() throws InterruptedException{
	solve(1);
    }

    public static int dist(int r1, int c1, int r2, int c2){
	return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public void solve(int style) throws InterruptedException{
	boolean aStar = false;
	if (style == 3){
	    aStar = true;
	} 
	Frontier[] f = {new FrontierStack(), new FrontierQueue(), new FrontierPriorityQueue(), new FrontierPriorityQueue()};
        Frontier frontier = f[style];
	int startRow = maze.start.getRow();
	int startCol = maze.start.getCol();
	int endRow = maze.end.getRow();
	int endCol = maze.end.getCol();
	Location start = new Location(startRow, startCol, null, 0, dist(startRow, startCol, endRow, endCol), aStar);
	Location end = new Location(endRow, endCol, null, 0, 0, aStar);
	frontier.add(start);
	Location node = start;
	boolean endFound = false;
	while (!endFound && frontier.hasNext()){
	    node = frontier.next();
	    maze.setChar(node.getRow(), node.getCol(), VISITED);
	    for (int i = -1; i <= 1; i++){ //check node's neighbors & visit them and add them to frontier
		for (int j = -1; j <= 1; j++){
		    if (!endFound && (i == 0 || j == 0) && i != j){ //check if one of the 4 immediate neighbors
			int row = i + node.getRow();
			int col = j + node.getCol();
			if (row <= maze.maxRow() && col <= maze.maxCol()){ //check if on board
			    char c = maze.getCharAt(row, col);
			    if (c == END){
				endFound = true;
				break;
			    }
			    if (!endFound && c == NEW_SPACE){
				frontier.add(new Location(row, col, node, node.getDistToStart() + 1, dist(row, col, endRow, endCol), aStar));
				maze.setChar(row, col, ON_FRONTIER);
				
			    }
			   
			}
		    }
		}
	    }
	    if (maze.animate()){
		//System.out.println(Maze.colorize(maze.toString()));
		System.out.println(maze);
		maze.clearTerminal();
		try{
		    Thread.sleep(150);
		    }
		catch(InterruptedException e){
		    e.printStackTrace();
		    System.exit(0);
		}
	    }
	}
	//System.out.println("done");
	if (endFound && maze.animate()){
	    while (node.prev() != null){
		maze.setChar(node.getRow(), node.getCol(), VISITED);
		maze.clearTerminal();
			try{
		    Thread.sleep(100);
		    }
		catch(InterruptedException e){
		}
			//	System.out.println(Maze.colorize(maze.toString()));
			System.out.println(maze.toString();
	    }
	}
	
    }

    public String toString(){
	return maze.toString();
    }

    public String toString(int i){
	return Maze.colorize(maze.toString());
    }

}
