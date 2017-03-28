public class MyLinkedList{
    class LNode{
	LNode next;
	int data;
	LNode(){
	    next = null;
	    data = 0;
	}
	LNode(LNode n, int d){
	    next = n;
	    data = d;

	}
	LNode copy(){
	    LNode n = new LNode();
	    n.next = next;
	    n.data = data;
	    return n;
	}
    }
    LNode start;
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
	    return true;
	}
	LNode temp = start;
	while (temp.next != null){
	    temp = temp.next;
	}
	temp.next = l;
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
    public LNode getH(int index){
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
	//	System.out.println("NEXT: " + prev.next);
	prev.next = toAdd;
	//	System.out.println("PREV: " + prev.data);
	size++;
    }

    public int remove(int index){
	if (index == 0){
	    int t = start.data;
	    start = start.next;
	    size--;
	    return t;
	}
	if (index == size-1){
	    LNode p = getH(index-1);
	    int t = p.data;
	    p.next = null;
	    size--;
	    return t;
	}
	LNode prev = getH(index-1);
	int toRemove = prev.next.data;
	prev.next = prev.next.next;
	size--;
	return toRemove;
    }

    /*  public static void main(String[] args){
	MyLinkedList list = new MyLinkedList();
	System.out.println(list);
	list.add(5);
	System.out.println(list);
	list.add(7);
	System.out.println(list);
	list.add(9);
	System.out.println(list);
	list.set(2, 90);
	System.out.println(list);
	list.add(0, 100);
	System.out.println(list + " " + list.size);
	list.add(4, 45);
	System.out.println(list);
	list.add(1, -1);
	for (int i = 0; i < list.size; i++){
	    System.out.println(i + " vs " + list.indexOf(list.get(i)));
	}
	System.out.println(list);
	System.out.println(list.size);
	System.out.println(list.remove(0));
	System.out.println(list);
	System.out.println(list.remove(3));
	System.out.println(list);
	System.out.println(list.remove(1));
	System.out.println(list);
	}*/

}
