import java.util.Arrays;
public class Quick{

	public static int quickselect(int[] ary, int k){
	int start = 0;
	int end = ary.length-1;
	while (true){
	    int[] indices = part(ary, start, end);
		//System.out.println("\t" + start + " " + end + " " + indices[0]);
	    if (indices[0] > k){
	    	end = indices[0]-1;
	    }else if(indices[1] < k){
	    	start = indices[1]+1;
	    }else{
	    	return ary[indices[0]];
	    }
		if (start >= end){
			//System.out.println("\t" + end + " : " + makeString(ary, 0, ary.length-1));
			return ary[end];
		}
       
	}
	//return -1;
    }
	
	public static void quicksort(int[] ary){
		quicksort(ary, 0, ary.length-1);
	}
	
	public static void quicksort(int[] ary, int start, int end){
		if (start <= end){
			int[] indices = part(ary, start, end);
			quicksort(ary, start, indices[0]-1);
			quicksort(ary, indices[1]+1, end);
		}
	}
	
    public static int[] part(int[] ary, int start, int end){
	//System.out.println("START: " + start + " END: " + end);
	//System.out.println(makeString(ary));
    if (start >= end){
		int[] result = {start, end};
    	return result;
    }
	int random = start + (int)(Math.random()*(end-start+1));
	//System.out.println("\tRDM: " + random + " : " + start + " - " + end);
	int pivot = ary[random];
	int t = ary[start];
	ary[start] = pivot;
	ary[random] = t;
	int s = start+1;
	int e = end;
	int lt = start;
	//System.out.println(makeString(ary, start, end));
	//boolean decreaseE = false;
	//System.out.println("PIVOT: " + pivot);
	while (e >= s){
		if (ary[s] > pivot){
			int temp = ary[s];
		    ary[s] = ary[e];
		    ary[e] = temp;
		    //s++;
		    e--;
		  //  decreaseE = true;
		}else if (ary[s] < pivot){
			int temp = ary[s];
			ary[s] = ary[lt];
			ary[lt] = temp;
			lt++;
			s++;
		//	decreaseE = true;
		}else{
			s++;
		}
		//System.out.println("lt: " + lt + " start: " + s + " end: " + e + "::" + makeString(ary, start, end) + "   " + makeString(ary, 0, ary.length-1));
	}
	/*if (!decreaseE){
		e++;
	}*/
	//ary[s] = pivot;
	//System.out.println(makeString(ary));
	/*int t2 = ary[start];
	//System.out.println(e);
	ary[start] = ary[lt];
	ary[lt] = t2;
	System.out.println("Switching " + start + " & " + lt);*/
	//System.out.println("\t" + pivot + ": " + (e) + ": " + makeString(ary, start, end));
	//ary[s-1] = pivot;
	int[] results = new int[2];
	results[0] = lt;
	results[1] = e;
	return results;
    }
   
    public static String makeString(int[] ary, int s, int e){
	String total = "";
	for (int i = s; i <= e; i++){
	    total += ary[i] + " ";
	}
	return total;
    }

   /*public static void main(String[] args){
	//int[] arr = {1, 3, 2, 5, 4, 0};
	//System.out.println(kthsmallest(arr, 5));
	//should be 3
	//int[] ary = {2, 10, 15, 23, 23, 23, 0, 5, 5, 5, 5, 5};
	for (int i = 0; i < ary.length; i++){
	   System.out.println(i + " " + quickselect(ary, i));
	}
	//quicksort(ary);
	//for (int a : ary){
	//	System.out.print(a + " ");
	//}
	//System.out.println(quickselect(ary, 0));
	for (int x = 0; x < 1000; x++){
	int random = (int)(1000*(Math.random()));
	int[] randomArr = new int[random];
	int range = (int)(1000*(Math.random()));
	for (int i = 0; i < randomArr.length; i++){
	   randomArr[i] = (int)(range*Math.random());
	}
	int index = (int)(Math.random()*randomArr.length);
	int elmt = randomArr[index];
	int[] copyRandom = new int[randomArr.length];
	for (int i = 0; i < randomArr.length; i++){
	  copyRandom[i] = randomArr[i];
	}
	//System.out.println(makeString(copyRandom, 0, copyRandom.length-1) + "\n");
	Arrays.sort(randomArr);
	if (randomArr[index] != quickselect(copyRandom, index)){
 	   System.out.println("error");
	}
	}
	//double start = System.currentTimeMillis();
	//int[] test = new int[Integer.MAX_VALUE-10];
	//quicksort(test);
	//double end = System.currentTimeMillis();
	//System.out.println((end-start)/1000);
    }*/
}

