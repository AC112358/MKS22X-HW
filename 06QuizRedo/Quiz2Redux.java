import java.util.*;
public class Quiz2Redux{
	/*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help( words , s, 0);
      Collections.sort(words);
      return words;
  }
  
  private static void help( ArrayList<String> words, 
                              String s, int index){
	if (index == 0){
		words.add("");
	}
	if (index >= s.length()){
		return;
	}
	ArrayList<String> temp = new ArrayList<String>();
	for (int i = 0; i < words.size(); i++){
		temp.add(words.get(i) + "" + s.charAt(index));
	}
	help(temp, s, index+1);
	help(words, s, index+1);
	for (int i = 0; i < temp.size(); i++){
		words.add(temp.get(i));
	}
							  }
  public static void main(String[] args){
		System.out.println(combinations(args[0]));
	}
  }