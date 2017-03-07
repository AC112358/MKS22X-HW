import java.io.*;

public class USACO{
    public USACO(){}

    public static int bronze(String filename) throws FileNotFoundException{
	return BronzeMar08.runBronze(filename);
    }

   /* public static void main(String[] args) throws FileNotFoundException{
	for(int num = 1; num < 11; num++){
	    System.out.println(bronze("makelake." + num + ".in"));
	}
    }*/
}
