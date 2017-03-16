import java.util.Arrays;
public class Quick{

    public static int quickselect(int[] ary, int k){
	int start = 0;
	int end = ary.length-1;
	for (int i = 0; i < ary.length; i++){
	    int index = part(ary, start, end);
	    if (index > k){
		end = index-1;
	    }else if(index < k){
		start = index+1;
	    }else{
		return ary[index];
	    }
       
	}
	return -1;
    }
    public static int part(int[] ary, int start, int end){
	//System.out.println("START: " + start + " END: " + end);
	//System.out.println(makeString(ary));
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
	    
	 //  System.out.println("start: " + s + " end: " + e + "::" + makeString(ary));
	    }
	}
	int total = start;
	for (int i = start; i <= end; i++){
	   if (ary[i] < pivot){
		total++;
	}
		
	}
	//ary[s] = pivot;
	//System.out.println(makeString(ary));
	int t2 = ary[total];
	ary[total] = ary[start];
	ary[start] = t2;
	//System.out.println("\t" + pivot + ": " + total + ": " + makeString(ary, start, end));
	//ary[s-1] = pivot;
	return total;
    }
   
    public static String makeString(int[] ary, int s, int e){
	String total = "";
	for (int i = s; i <= e; i++){
	    total += ary[i] + " ";
	}
	return total;
    }

   public static void main(String[] args){
	//int[] arr = {1, 3, 2, 5, 4, 0};
	//System.out.println(kthsmall(arr, 5));
	//should be 3
	/*int[] ary = {2, 10, 15, 23, 0, 5};
	for (int i = 0; i < ary.length; i++){
	   System.out.println(i + " " + quickselect(ary, i));
	}*/
	for (int x = 0; x < 100; x++){
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
	System.out.println(makeString(copyRandom, 0, copyRandom.length-1) + "\n");
	Arrays.sort(randomArr);
	if (randomArr[index] != quickselect(copyRandom, index)){
 	   System.out.println("error");
	}
	}
    }
}
