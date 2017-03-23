public class Merge{
    public static void mergesort(int[] ary){
	mergesort(ary, 0, ary.length-1);
    }
    public static void mergesort(int[] ary, int start, int end){ //[s,e]
	int avg = (start+end)/2;
	if (start != end){
	    mergesort(ary, start, avg);
	    mergesort(ary, avg+1, end);
	}
	interleave(ary, start, avg, end);
    }

    public static void interleave(int[] ary, int start, int mid, int end){
	int s = start;
	int avg = mid+1;
	while (start <= mid && avg <= end){
	   
	    if (ary[start] > ary[avg]){
		int temp = ary[start];
		ary[start] = ary[avg];
		ary[avg] = temp;
		 if (start + 1 == avg){
		    start++;
		    avg++;
		 }
	    }
	    else if (ary[start] < ary[avg]){
		start++;
	    }  
	    
	    printArray(ary, s, end);
	    System.out.println("\t" + start + " " + avg);
	}
    }


    public static void printArray(int[] ary, int s, int e){
	for (int i = s; i <= e; i++){
	    System.out.print(ary[i] + " ");
	}
	System.out.println();
    }
    public static void printArray(int[] ary){
	for (int a : ary){
	    System.out.print(a + " ");
	}
	System.out.println();
    }
    public static void main(String[] args){
	int[] a = {1, 3, 8, 0, 4, 5, 7, 8, 9};
	mergesort(a);
	printArray(a);
    }
}
