import java.util.Stack;
import java.util.ArrayDeque;

public class PostFix{
    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for (String t : tokens){
	    if (isOp(t)){
		values.push(apply(t, values.pop(), values.pop()));
	    }
	    else{
	    values.push(Double.parseDouble(t));
	    }
        }
	return values.pop();
    }
    public static boolean isOp(String s){
        return "+-*/%".indexOf(s) >= 0;
    }
    public static double apply(String op, double b, double a){
	int index = "+-*/%".indexOf(op);
	switch(index){
	case 0:
	    return a + b;
	case 1:
	    return a - b;
	case 2:
	    return a*b;
	case 3:
	    return a/b;
	case 4:
	    return a%b;
	}
	return 0;
    }

    public static void main(String[] args){
	System.out.println(eval("10 2.0 +"));// is 12.0
	System.out.println(eval("11 3 - 4 + 2.5 *"));// is 30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));// is 893.0
    }
    
}
