public class MyLinkedList{
    class LNode{
	LNode next;
	int data;
	LNode copy(){
	    Lnode n = new Lnode();
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
    public void addToStart(LNode l){
	l.next = start.copy();
	start = l;
    }

    public String toString(){
	String total = "";
	LNode curr = start;
	while (curr != null){
	    total += curr.data + " ";
	    curr = curr.next();
	}
    }
    
    public MyLinkedList(LNode l){
	start = l;
	size = 0;
    }

}
