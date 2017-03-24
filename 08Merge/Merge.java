import java.util.Arrays;
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
	//	System.out.println("**"+mid+ " - " + end + "**");
	while (start < avg && avg <= end){
	   
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
	    }else{
		start++;
		avg++;
	    }  
	    
	    printArray(ary, s, end);
	    //  System.out.println("\t" + start +  " " + avg);
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
    /* public static void main(String[] args){
	int[] a = {1, 3, 8, 0, 4, 5, 7, 8, 9};
	mergesort(a);
	printArray(a);
	}*/
    public static void main(String[] args){
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
	mergesort(copyRandom);
	for (int i = 0; i < randomArr.length; i++){
	    if (randomArr[i] != copyRandom[i]){
		System.out.println("error\n\t");
		//   printArray(copyRandom);
	    }
	}
       }
    }
}
