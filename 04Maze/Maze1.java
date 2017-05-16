import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Maze1{
    char[][] maze;
	int startRow = 0;
	int startCol = 0;
    public Maze1(String file){
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
			System.out.println("File not found!");
			System.exit(0);
		}
		//System.out.println(mazeString);
		char[] maze2 = mazeString.toCharArray();
		int len = 0;
		while (len < maze2.length && maze2[len] != '\n'){
			len++;
		}
		//len--;
		maze = new char[numRows][len];
		/*System.out.println("numRows: " + numRows + ", len: " + len + " vs " + 
		"###################################".length());*/
		for (int i = 0; i < numRows; i++){
			/*if (i%(len) == 0){
				System.out.println();
			}*/
			/*System.out.println(i/maze[0].length + "," + i%maze[0].length + ": " + maze2[i]);
			maze[i/maze[0].length][i%maze[0].length] = maze2[i];*/
			for (int j = 0; j < len; j++){
				maze[i][j] = maze2[i*(maze[0].length+1) + j];
				if (maze[i][j] == 'S'){
					startRow = i;
					startCol = j;
				}
			}
			//System.out.print(maze2[i]);
		}
		/*for (int i = 0; i < maze.length; i++){
			for (int j = 0; j < maze[0].length; j++){
			System.out.print(maze[i][j]);
			}
			System.out.println();
		}*/
    }
	public void solve(){
		solve(startRow, startCol);
	}
	
	
	private boolean solve(int row, int col){
		if (maze[row][col] == 'E'){
			return true;
		}
		System.out.println(this + "\n");
		if (maze[row][col] != 'S'){
			maze[row][col] = 'X';
		}
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
			maze[row][col] = '*';
		}
		return false;
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
		Maze m = new Maze1("mazeString.txt");
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
}
