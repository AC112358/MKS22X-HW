import java.io.*;

public class USACO{
    public USACO(){}

    public static int bronze(String filename) throws FileNotFoundException{
		return BronzeMar08.runBronze(filename);
    }

	public static int silver(String filename) throws FileNotFoundException{
		return USACOMar08Silver7.runSilver(filename);
	}
   /* public static void main(String[] args) throws FileNotFoundException{
	for(int num = 1; num < 11; num++){
	    System.out.println(bronze("makelake." + num + ".in"));
	}
    }*/
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println(silver("ctravel.txt"));
	}
}
