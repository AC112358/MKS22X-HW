public class FrontierQueue implements Frontier{
    private Queue<Location> queue;
    public FrontierQueue(){
	queue = new ArrayDeque<Location>();
    }
    public void add(Location l){
	queue.add(l);
    }
    public Location next(){
	return queue.remove();
    }
}
