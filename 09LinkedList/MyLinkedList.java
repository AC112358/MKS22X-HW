import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList implements Iterable<Integer>{
    public Iterator<Integer> iterator(){
	return new LIterator(start);
    }
    public class LIterator implements Iterator<Integer>{
	LNode curr;
	public LIterator(LNode temp){
	    curr = temp;
	}
	public boolean hasNext(){
	    return (curr != null && curr.next != null);
	}
	public Integer next(){
	    if (!hasNext()){
		throw new NoSuchElementException();
	    }
	    int temp = curr.data;
	    curr = curr.next;
	    return temp;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    class LNode{
	LNode next;
	LNode prev;
	int data;
	LNode(){
	    next = null;
	    data = 0;
	    prev = null;
	}
	LNode(LNode n, int d){
	    next = n;
	    data = d;

	}
	LNode copy(){
	    LNode n = new LNode();
	    n.next = next;
	    n.data = data;
	    n.prev = prev;
	    return n;
	}
    }
    LNode start;
    LNode end;
    int size;
    public MyLinkedList(){
	start = null;
	size = 0;
       
    }
    
    public boolean add(int value){
	size++;
	LNode l = new LNode(null, value);
	if (start == null){
	    start = l;
	    end = l;
	    return true;
	}
	LNode temp = start;
	while (temp.next != null){
	    temp = temp.next;
	}
	temp.next = l;
	l.prev = temp;
	end = l;
	//	System.out.println(start.next);
	return true;
    }

    public String toString(){
	if (start == null){
	    return "[]";
	}
	String total = "[";
	LNode curr = start;
	while (curr != null){
	    total += " " + curr.data + ",";
	    curr = curr.next;
	}
	total = total.substring(0, total.length()-1);
	total += "]";
	return total;
    }

    private String toStringBW(){
	if (start == null){
	    return "[]";
	}
	String total = "[";
	LNode curr = end;
	while (curr != null){
	    total += " " + curr.data + ",";
	    curr = curr.prev;
	}
	total = total.substring(0, total.length()-1);
	total += "]\n";
	return total;
    }
    
    public MyLinkedList(LNode l){
	start = l;
	size = 0;
    }

    public int size(){
	return size;
    }

    public int get(int index){
	return getH(index).data;
    }
    private LNode getH(int index){
	if (index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = start;
	while (index > 0 && temp.next != null){
	    temp = temp.next;
	    index--;
	}
	return temp;
    }

    public int set(int index, int newValue){
	int temp = getH(index).data;
	getH(index).data = newValue;
	return temp;
    }


    public int indexOf(int value){
	LNode temp = start;
	int index = 0;
	while (temp != null){
	    if (temp.data == value){
		return index;
	    }
	    temp = temp.next;
	    index++;
	}
	return -1;
    }

    public void add(int index, int value){
	//	size++;
	if (index == 0){
	    size++;
	    LNode p = new LNode(start, value);
	    if (start != null){
		start.prev = p;
	    }else{
		end = p;
	    }
	    start = p;
	    return;
	}
	if (index == size){
	    size++;
	    add(value);
	    size--;
	    return;
	}
	LNode prev = getH(index-1);
	LNode toAdd = new LNode(prev.next, value);
	toAdd.prev = prev;
	toAdd.next.prev = toAdd;
	//	System.out.println("NEXT: " + prev.next);
	prev.next = toAdd;
	//	System.out.println("PREV: " + prev.data);
	size++;
    }

    public int remove(int index){
	if (index == 0){
	    int t = start.data;
	    start = start.next;
	    if (start != null){
		start.prev = null;
	     }
	    else{
		end = null;
	    }
	    size--;
	    return t;
	}
	if (index == size-1){
	    LNode p = getH(index-1);
	    int t = p.data;
	    p.next = null;
	    end = p;
	    size--;
	    return t;
	}
	LNode prev = getH(index-1);
	int toRemove = prev.next.data;
	prev.next = prev.next.next;
	prev.next.prev = prev;
	size--;
	return toRemove;
    }

    public static void main(String[] args){
	MyLinkedList list = new MyLinkedList();
	System.out.println(list);
	System.out.println(list.toStringBW());
	list.add(5);
	System.out.println(list);
	System.out.println(list.toStringBW());
	list.add(7);
	System.out.println(list);
	System.out.println(list.toStringBW());
	list.add(9);
	System.out.println(list);
	System.out.println(list.toStringBW());
	list.set(2, 90);
	System.out.println(list);
	System.out.println(list.toStringBW());
	list.add(0, 100);
	System.out.println(list + " " + list.size);
	System.out.println(list.toStringBW());
	list.add(4, 45);
	System.out.println(list);
	System.out.println(list.toStringBW());
	list.add(1, -1);
	for (int i = 0; i < list.size; i++){
	    System.out.println(i + " vs " + list.indexOf(list.get(i)));
	}
	System.out.println(list);
	System.out.println(list.toStringBW());
	System.out.println(list.size);
	System.out.println(list.remove(0));
	System.out.println(list);
	System.out.println(list.toStringBW());
	System.out.println(list.remove(3));
	System.out.println(list);
	System.out.println(list.toStringBW());
	System.out.println(list.remove(1));
	System.out.println(list);
	System.out.println(list.toStringBW());
	Iterator<Integer> it = list.iterator();
	while (it.hasNext()){
	    System.out.println(it.next());
	}
	/*	MyLinkedList l2 = new MyLinkedList();
	l2.add(5);
	l2.remove(0);
	System.out.println(l2);
	System.out.println(l2.toStringBW());*/
       
	}
   
}
