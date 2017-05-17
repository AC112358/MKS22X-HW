public class Driver{
    public static void main(String[] args){
	MazeSolver m = new MazeSolver(args[0], Boolean.parseBoolean(args[1]));
	m.solve(Integer.parseInt(args[2]));
    }
}
