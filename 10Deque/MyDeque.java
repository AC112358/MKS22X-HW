import java.util.NoSuchElementException;

public class MyDeque{
    String[] data;
    int first;
    int last;
    int size;
    public MyDeque(){
	data = new String[3];
	first = 1;
	last = 0;
	size = 0;
    }
    public void addFirst(String toAdd){
	if (toAdd == null){
	    throw new NullPointerException();
	}
	if (size >= data.length - 1){
	    grow();
	}
	first = (first-1+data.length)%data.length;
	data[first] = toAdd;
	size++;
    }
    public void grow(){
	String[] newArr = new String[data.length*2];
	for (int i = first; i < size+first; i++){
	    newArr[i-first] = data[i%data.length];
	}
	data = newArr;
    }
    public void addLast(String toAdd){
       if (toAdd == null){
	    throw new NullPointerException();
	}
	if (size >= data.length-1){
	    grow();
	}
	last = (last+1)%data.length;
	data[last] = toAdd;
	size++;
    }
    
    public String removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String temp = data[first];
	first = (first+1)%data.length;
	size--;
	return temp;
    }
    public String removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String temp = data[last];
	last = (last-1+data.length)%data.length;
	size--;
	return temp;
    }
    public String getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[first];
    }
    public String getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[last];
    }
    public String toString(){
	String total = "";
	/*for (int i = 0; i < data.length; i++){
	    System.out.print(data[i] + " ");
	}
	System.out.println();*/
	for (int i = first; i < size + first; i++){
	    total += data[i % data.length] + " ";
	}
	return total;
    }
    
    /*public static void main(String[] args){
	MyDeque d = new MyDeque();
	d.addFirst("a");
	System.out.println("Add a to front: " + d);
	d.addLast("b");
	System.out.println("Add b to back: " + d);
	d.addFirst("c");
	System.out.println("Add c to front: " + d);
	System.out.println("First element: " + d.getFirst());
	System.out.println("Last element: " + d.getLast());
	d.removeLast();
	System.out.println("Remove last: " + d);
	System.out.println("First element: " + d.getFirst());
	System.out.println("Last element: " + d.getLast());
       	d.removeFirst();
	System.out.println("Remove first: " + d);
	System.out.println("First element: " + d.getFirst());
	System.out.println("Last element: " + d.getLast());
	System.out.println("\n"+d.removeFirst());
	System.out.println("Remove first: " + d);
	System.out.println("First element: " + d.getFirst());
	System.out.println("Last element: " + d.getLast());
	System.out.println("\n" + d.removeLast());
	System.out.println("Remove last: " + d);
	System.out.println("First element: " + d.getFirst());
	System.out.println("Last element: " + d.getLast());
	}*/
}
