package data_structure.arrays;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(ReverseString.reverse("sarath"));
		System.out.println(ReverseString.recursiveReversal("sarath"));
	}
	
	private static String reverse(String input) {
		char[] charArray = input.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = charArray.length- 1; i >=0 ;i--) {
			sb.append(charArray[i]);
		}
		return sb.toString();
		
	}
	
	
	  public static String recursiveReversal (String str) {
	    if (str.length() == 0)  //breakpoint for recursion
	       return "";
	    return recursiveReversal(str.substring(1)) + str.charAt(0);
	  }

}

