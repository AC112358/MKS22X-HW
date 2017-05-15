public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location prev, int dToS, int dToG, boolean a){
	row = r;
	col = c;
	distToGoal = dToG;
	distToStart = dToS;
	aStar = a;
    }

    public int getDistToStart(){
	return distToStart;
    }

    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }
    

    public int compareTo(Location other){
	if (aStar){
	    return (distToStart + distToGoal) - (other.distToStart + other.distToGoal);
	}
	return distToGoal - other.distToGoal;
    }
}
