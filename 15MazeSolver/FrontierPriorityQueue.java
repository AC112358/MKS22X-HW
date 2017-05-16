public class FrontierPriorityQueue implements Frontier{
    MyLocationHeap heap;
    public FrontierPriorityQueue(){
	heap = new MyLocationHeap(true);
    }
    public void add(Location l){
	heap.add(l);
    }
    public Location next(){
	return heap.remove();
    }
    
}
