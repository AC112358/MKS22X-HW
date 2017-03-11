import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACOMar08Silver7 {

	static char[][] maze;
	static int[][][] numPaths; //numPaths[R][C][2]
	static int T;
	static int R1;
	static int R2;
	static int C1;
	static int C2;
	public static int numPaths(){
		numPaths[R1][C1][0] = 1;
		int index = 1;
		for (int t = 1; t <= T; t++){
			for (int r = 0; r < numPaths.length; r++){
				for (int c = 0; c < numPaths[0].length; c++){
					for (int i = -1; i <= 1; i++){
						for (int j = -1; j <= 1; j++){
							if (isNeighbor(r, i, c, j)){
								numPaths[r][c][index] += numPaths[r+i][c+j][1-index];
							}
						}
					}
				}
			}
			index++;
			index %= 2;
		}
		return numPaths[R2][C2][1-index];
	}
	
	public static boolean isNeighbor(int r, int dr, int c, int dc){
		if (!((Math.abs(dr) == 1 && dc == 0) || (Math.abs(dc) == 1 && dr == 0))){
			return false;
		}
		if (!((r + dr >= 0 && r + dr < numPaths.length) && (c + dc >= 0 && c + dc < numPaths[0].length))){
			return false;
		}
		//System.out.println((r+dr) + " " + (c + dc));
		return maze[r+dr][c+dc] == '.';
	}
	public static int runSilver(String filename) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File(filename));
		int R = in.nextInt();
		int C = in.nextInt();
		T = in.nextInt();
		maze = new char[R][];
		numPaths = new int[R][C][2];
		//System.out.println(R + " " + C);
		String temp = in.nextLine();
		for (int i = 0; i < R; i++){
			maze[i] = in.nextLine().toCharArray();
			//System.out.println(maze[i].length);
			/*for (char m : maze[i]){
				System.out.print(m);
			}
			System.out.println();*/
		}
		R1 = in.nextInt()-1;
		C1 = in.nextInt()-1;
		R2 = in.nextInt()-1;
		C2 = in.nextInt()-1;
		return numPaths();
	}

}
