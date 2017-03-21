
public class QuickSelect {
	
	public static int kthsmallest(int[] ary, int k){
		int start = 0;
		int end = ary.length-1;
		while (true){
			int index = part(ary, start, end);
			if (index > k){
				end = index-1;
			}
			else if(index < k){
				start = index+1;
			}
			else{
				return ary[index];
				 }
			       
			}
	}
	
	public static int part(int[] ary, int start, int end){
		int random = start + (int)(Math.random()*(end-start+1));
		int s = start + 1;
		int e = end;
		int pivot = ary[random];
		//System.out.println(pivot + ": " + "START: " + start + " END: " + end);
		ary[random] = ary[start];
		ary[start] = pivot;
		int total = 0;
		for (int i = start; i <= end; i++){
			//System.out.print(ary[i] + " ");
			if (ary[i] < pivot){
				total++;
			}
		}
		//System.out.println();
		while (s < e){
			while (s < ary.length && ary[s] < pivot){
				s++;
			}
			while (e >= 0 && ary[e] > pivot){
				e--;
			}
			if (s < e){
				int temp = ary[s];
				ary[s] = ary[e];
				ary[e] = temp;
			}
		}
		ary[start] = ary[start+total];
		ary[start+total] = pivot;
		//System.out.println(makeString(ary, start, end) + "- " + s + "," + e + " " + (start+total));
		return start+total;
	}
	public static String makeString(int[] ary, int start, int end){
		String total = "";
		for (int i = start; i <= end; i++){
		    total += ary[i] + " ";
		}
		return total;
	    }
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 2, 5, 4, 0};
		System.out.println(kthsmallest(arr, 1));
	}*/

}
