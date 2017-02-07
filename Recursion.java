public class Recursion{
	public static String name(){
		return "Caplin,Ann";
	};
	public static double sqrt(double n){
		if (n < 0){
			throw new IllegalArgumentException();
		}
		return sqrt(n, 1);
	}
	private static double sqrt(double n, double guess){
		if (approx(n, guess * guess)){
			return guess;
		}
		guess = (n/guess + guess)/2.;
		return sqrt(n, guess);
	}
	private static boolean approx(double a, double b){
		if (a == 0 && b == 0){
			return true;
		}
		return (Math.abs(a-b))/(a+b) < Math.pow(10, -9);
	}
	/*public static void main(String[] args){
		System.out.println(approx(4, 5));
		System.out.println(approx(4, 4));
		System.out.println(approx(-4, 4));
		System.out.println(approx(4, 400000));
		System.out.println(approx(4000000000., 4000000001.));
		System.out.println(approx(80.000000000000000, 80.000000000000001));
		//System.out.println(sqrt(-45));
		System.out.println(sqrt(45));
		System.out.println(sqrt(9));
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));
	}*/
}