public class MyHeap{
    private ArrayList<String> data;
    private int minConst;
    public MyHeap(){
	data = new ArrayList<String>();
	minConst = 1;
    }
    public MyHeap(boolean b){
	data = new ArrayList<String>();
	minConst = -1;
	if (b){
	    minConst = 1;
	}
    }

    public void add (String s){
	data.add(s);
	pushUp(data.size()-1);
    }
    private int pushUp(int i){
	while (getParent(i) != i && getdata.get(i) < data.get(getParent(i)){
	        i = getParent(i);
	    }
	    return i;
    }
	private int getParent(int i){
	    return (i/2);
	} 

}
