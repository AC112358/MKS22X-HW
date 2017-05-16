import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyLocationHeap{
    private ArrayList<Location> data;
    private int minConst;
    private int size;

    public int getSize(){
	return size;
    }
    public MyLocationHeap(){
    	data = new ArrayList<Location>();
    	data.add(0);
    	minConst = 1;
	size = 0;
    }
    public MyLocationHeap(boolean b){
    	this();
	size = 0;
    	if (!b){
    		minConst = -1;
    	}
    }
    
    public void add(int s){
    	data.add(s);
    	pushUp(data.size()-1);
	size++;
    }
    
    //precondition: i < data.size()
    private void pushUp(int i){
    	//System.out.println(data.get(i));
    	while (i > 1 && minConst*data.get(i).compareTo(data.get(getParent(i))) > 0){
    		//System.out.println("\t Swapping " + i + " and " + getParent(i));
    		Location temp = data.get(getParent(i));
    		data.set(getParent(i), data.get(i));
    		data.set(i, temp);
    		i = getParent(i);
    	}
    }
    
    public int peek(){
    	if (data.size() <= 1){
	    throw new NoSuchElementException();
    	}
    	return data.get(1);
    }
    
    public int remove(){
    	if (data.size() <= 1){
	    throw new NoSuchElementException();
    	}
    	if (data.size() == 2){
    		return data.remove(1);
    	}
        int temp = data.get(1);
    	data.set(1,  data.remove(data.size()-1));
    	pushDown(1);
	size--;
    	return temp;
    }
    
    private void pushDown(int i){
    	while ((largerChild(i) != -1) && (minConst*data.get(i).compareTo(data.get(largerChild(i))) < 0)){
	    //	System.out.println("Swapping " + data.get(i) + " and " + data.get(largerChild(i)));
    		Location temp = data.get(largerChild(i));
    		data.set(largerChild(i), data.get(i));
    		data.set(i, temp);
		i = largerChild(i);
    	}
	//System.out.println("\t" + (minConst*data.get(i).compareTo(data.get(largerChild(i)))));
    	//System.out.println(data.get(oldI) + " larger child " + largerChild(oldI));
    }
    
    private int largerChild(int i){
    	if (getLeft(i) >= data.size()){
    		if (getRight(i) >= data.size()){
    			return -1;
    		}
    		return getRight(i);
    	}
    	else{
	    if (getRight(i) >= data.size() || minConst*(data.get(getLeft(i)).compareTo(data.get(getRight(i)))) > 0){
    			return getLeft(i);
    		}
    		return getRight(i);
    	}
    }
    
    private static int getParent(int i){
    	return i/2;
    }
    private static int getLeft(int i){
    	return 2*i;
    }
    private static int getRight(int i){
    	return 2*i + 1;
    }
    
    /*public static void main(String[] args){
    	boolean b = false;
    	String[] stuff = {"ab2", "cd6", "ac3", "ba4", "bg5", "ef7", "gh8", "aa1"};
    	String[] sorted = new String[stuff.length];
    	for (int i = 0; i < stuff.length; i++){
    		sorted[i] = stuff[i];
    	}
    	Arrays.sort(sorted);
    	ArrayList<String> removed = new ArrayList<String>();
    	for (int i = 0; i <= 1; i++){
	    System.out.println("\n\n");
    		b = !b;
		removed.clear();
    		MyHeap h = new MyHeap(b);
    		for (int j = 0; j < stuff.length; j++){
    			h.add(stuff[j]);
    		}
		//	System.out.println(h.data);
    		//System.out.println(h.data.get(getLeft(1)) + " vs " + h.data.get(getRight(1)));
    		//System.out.println(h.data.get(getParent(h.data.size()-1)));
    		
			for (int j = 0; j < stuff.length; j++){
    			System.out.println(h.remove() + " :: " + sorted[j]);
			if (j == 0){
			    System.out.println(h.data.get(2) + " " + h.data.get(getRight(2)) + " " + getRight(2) + " vs "
					       + h.data.get(getLeft(2)) + " " + getLeft(2) + " --> " + 
					       h.data.get(h.largerChild(2)));
			    System.out.println(h.data.get(2).compareTo(h.data.get(h.largerChild(2))));
			    }
    			System.out.println(h.data);
    		}
    		
    		for (int j = 0; j < stuff.length; j++){
    			removed.add(h.remove());
    		}
    		for (String str : removed)
    			System.out.print(str + " ");
    		System.out.println();
    		for (String str : sorted)
    			System.out.print(str + " ");
		System.out.println();
    		
    	}*/
}
