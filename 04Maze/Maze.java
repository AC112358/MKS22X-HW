import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Maze{
    private char[][] maze;
    private boolean animate;
	int startRow = 0;
	int startCol = 0;
    public Maze(String file){
		int numRows = 0;
		String mazeString = "";
		try{
		File f = new File(file);
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){
			mazeString += sc.nextLine();
			mazeString += "\n";
			//System.out.println(mazeString);
			numRows++;
		}
		}catch(FileNotFoundException f){
			System.out.println("ERROR: File not found!");
			System.exit(0);
		}
		//	System.out.println(mazeString);
		char[] maze2 = mazeString.toCharArray();
		int len = 0;
		while (len < maze2.length && maze2[len] != '\n'){
			len++;
		}
		//	System.out.println(numRows+ " " + len);
		maze = new char[numRows][len];
		int numStarts = 0;
		int numEnds = 0;
		for (int i = 0; i < numRows; i++){
			for (int j = 0; j < len; j++){
				maze[i][j] = maze2[i*(maze[0].length+1) + j];
				//	System.out.println(maze[i][j]);
				if (maze[i][j] == 'S'){
					startRow = i;
					startCol = j;
					numStarts++;
				}
				if (maze[i][j] == 'E'){
				    numEnds++;
				}
			}
		}
		if (numEnds != 1 || numStarts != 1){
		    System.out.println("ERROR: Incorrect number of starts and ends:");
		    System.out.println("\tStarts: " + numStarts+ " \n\tEnds: " + numEnds);
		    System.exit(0);
		}
    }
	public void solve(){
		solve(startRow, startCol);
	}
	
	
	private boolean solve(int row, int col){
	    if (animate){
		System.out.println("\033[2J\033[1;1H"+this);
		try{
		    Thread.sleep(20);
		}catch(InterruptedException e){
		    e.printStackTrace();
		    System.exit(0);
		}
	    }
		if (maze[row][col] == 'E'){
			return true;
		}
		System.out.println(this + "\n");
		maze[row][col] = '@';
		int i = 0;
		int j = 0;
		for (int x = 1; x <= 7; x += 2){
			i = x/3 - 1;
			j = x%3 - 1;
			if (row+i >= 0 && row+i < maze.length &&
				col+j >= 0 && col+j < maze[0].length &&
				(maze[row+i][col+j] == ' ' || maze[row+i][col+j] == 'E')){
				if (solve(row+i, col+j)){
					return true;
				}
			}
		}
		if (maze[row][col] != 'S'){
			maze[row][col] = '.';
		}
		return false;
	}
    
    public void setAnimate(boolean b){
	animate = b;
    }
    
    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

	public String toString(){
		String total = "";
		for (int i = 0; i < maze.length; i++){
			for (int j = 0; j < maze[0].length; j++){
				total += maze[i][j];
			}
			total += "\n";
		}
		return total;
	}
	
    /*public static void main(String[] args){
		Maze m = new Maze("mazeString.txt");
		int i = 0;
		int j = 0;
		for (int x = 1; x <= 7; x += 2){
				i = x/3 - 1;
				j = x%3 - 1;
				System.out.println(i + "," + j);
		}
		//System.out.println(m.solve(1,33));
		m.solve();
		System.out.println(m);
    }*/
    /*public static void main(String[] args){
	Maze f;
        f = new Maze("data3.dat");//true animates the maze.
        
        f.setAnimate(true);
        f.solve();

        System.out.println(f);
    }*/
}
