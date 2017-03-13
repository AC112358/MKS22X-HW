public class QuickSelect{

    public static int kthsmall(int[] ary, int k){
	int start = 0;
	int end = ary.length-1;
	while (true){
	    int index = part(ary, start, end);
	    if (index > k){
		end = index;
	    }else if(index < k){
		start = index;
	    }else{
		return ary[index];
	    }
       
	}
	//return -1;
    }
    public static int part(int[] ary, int start, int end){
	System.out.println("START: " + start + " END: " + end);
	System.out.println(makeString(ary));
	int random = start + (int)(Math.random()*(end-start+1));
	int pivot = ary[random];
	int t = ary[start];
	ary[start] = pivot;
	ary[random] = t;
	int s = start+1;
	int e = end;
	//	System.out.println(makeString(ary));
	while (e > s){
	    while (e >= 0 && ary[e] > pivot){
		e--;
	    }
	    while (s < ary.length && ary[s] < pivot){
		s++;
	    }
	    if (s < e){
	    int temp = ary[s];
	    ary[s] = ary[e];
	    ary[e] = temp;
	    
	   System.out.println("start: " + s + " end: " + e + "::" + makeString(ary));
	    }
	}
	//ary[s] = pivot;
	System.out.println(makeString(ary));
	int t2 = ary[s-1];
	ary[s-1] = ary[start];
	ary[start] = t2;
	System.out.println("\t" + pivot + ": " + makeString(ary));
	//ary[s-1] = pivot;
	return s-1;
    }
   
    public static String makeString(int[] ary){
	String total = "";
	for (int a : ary){
	    total += a + " ";
	}
	return total;
    }

    public static void main(String[] args){
	int[] arr = {1, 3, 2, 5, 4, 0};
	System.out.println(kthsmall(arr, 5));
	//should be 3
    }
}
