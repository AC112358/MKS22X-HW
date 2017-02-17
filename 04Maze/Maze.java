import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Maze{
    char[][] maze;
    public Maze(String file){
	int numRows = 0;
	String mazeString = "";
	File f = new File(file);
	Scanner sc = new Scanner(file);
	while (sc.hasNextLine()){
	    mazeString += sc.nextLine();
	    mazeString += "\n";
	    numRows++;
	}
	System.out.println(mazeString);
	char[] maze2 = mazeString.toCharArray();
	int len = 0;
	while (len < maze2.length && maze2[len] != '\n'){
	    len++;
	}
	maze = new char[len-1][numRows];
	for (int i = 0; i < maze2.length; i++){
	    System.out.println(i/maze[0].length + "," + i%maze[0].length);
	    maze[i/maze[0].length][i%maze[0].length] = maze2[i];
	}
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[0].length; j++){
		System.out.println(maze[i][j]);
	    }
	    System.out.println();
	}
    }
    public static void main(String[] args){
	Maze m = new Maze("mazeString.txt");
    }
}
