public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar;
    private int timeAdded;
    private static int time;

    public Location(int r, int c, Location prev, int dToS, int dToG, boolean a){
	row = r;
	col = c;
	distToGoal = dToG;
	distToStart = dToS;
	aStar = a;
	timeAdded = time + 1;
	time++;
    }

    public static void initTime(){
        time = 0;
    }

    public int getDistToStart(){
	return distToStart;
    }
    public Location prev(){
	return previous;
    }

    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }
    

    public int compareTo(Location other){
	int total = 0;
	if (aStar){
	    total = (distToStart + distToGoal) - (other.distToStart + other.distToGoal);
	}else{
	    total = distToGoal - other.distToGoal;
	}
	if (total != 0){
	    return total;
	}
	return other.timeAdded - timeAdded; // > 0 if your time added is less (added first)
    }
}
