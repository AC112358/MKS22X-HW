import java.util.Scanner;
import java.io.*;

public class BronzeMar08{
    static int[][] field;
    static int E;

    public static void stomp(int row, int col, int dep){
	int max = field[row][col];
	for (int i = row; i < row + 3; i++){
	    for (int j = col; j < col+3; j++){
		if (i < field.length && j < field[0].length &&
		    max < field[i][j]){
		    max = field[i][j];
		}
	    }
	}
	max = max - dep;
	for (int i = row; i < row + 3; i++){
	    for (int j = col; j < col+3; j++){
		if (i < field.length && j < field[0].length){
		    if( max < field[i][j]){
		    field[i][j] = max;
		    }
		}
	    }
	}
    }

    public static int runBronze(String filename) throws FileNotFoundException{
	int R, C, N;
	Scanner in = new Scanner(new File(filename));
	String[] temp = in.nextLine().split(" ");
	R = Integer.parseInt(temp[0]);
	C = Integer.parseInt(temp[1]);
	field = new int[R][C];
	E = Integer.parseInt(temp[2]);
	N = Integer.parseInt(temp[3]);
	int i = 1;
	while (i < R+1){
	    String[] line = in.nextLine().split(" ");
	    for(int index = 0; index < C; index++){
		field[i - 1][index] = Integer.parseInt(line[index]);
	    }
	    i++;
	}
        for(int j = R + 2; j < R + N + 2; j++){
	    String[] instr = in.nextLine().split(" ");
	    int row = Integer.parseInt(instr[0]), col = Integer.parseInt(instr[1]), dep = Integer.parseInt(instr[2]);
	    stomp(row-1, col-1, dep);
	}
	int total = 0;
	for (int r =0; r < R; r++){
	    for (int j = 0; j < C; j++){
		if (field[r][j] >= E){
		    field[r][j] = 0;
		    //System.out.print("_");
		}else{
		    field[r][j] = E-field[r][j];
		    //System.out.print(field[r][j] + " ");
		    total += field[r][j];
		}
      
	    }
	    //System.out.println();
	}
	return total * 72 * 72;
    }
}
