public class RunningMedian{
    private double median;
    private MyHeap minHeap;
    private MyHeap maxHeap;
    public RunningMedian(){
	median = 0;
	minHeap = new MyHeap(false);
	maxHeap = new MyHeap(true);
    }
    
    public void add(int toAdd){
	if (toAdd > median){
	    minHeap.add(toAdd);
	}
	else{
	    maxHeap.add(toAdd);
	}
	if (minHeap.getSize() == maxHeap.getSize()){
	    median = (minHeap.peek() + maxHeap.peek())/2.;
	}
	else if (minHeap.getSize() - maxHeap.getSize() == 1){
	    median = minHeap.peek();
	}
	else if (maxHeap.getSize() - minHeap.getSize() == 1){
	    median = maxHeap.peek();
	}
	else if (minHeap.getSize() - maxHeap.getSize() > 2){
	    maxHeap.add(minHeap.remove());
	    median = minHeap.peek();
	}
	else if (maxHeap.getSize() - minHeap.getSize() > 2){
	    minHeap.add(maxHeap.remove());
	    median = maxHeap.peek();
	}
    }
    
    public double getMedian(){
	return median;
    }



    public static void main(String[] args){
	int[] list = {14, 12, 19, 20, 124, 124, 56, 23, 123, 575, 7};
	RunningMedian med = new RunningMedian();
	for (int i = 0; i < list.length; i++){
	    med.add(list[i]);
	    System.out.println(med.getMedian());
	}
    }
}
