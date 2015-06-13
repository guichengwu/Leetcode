package Math;

public class TitleToNumber {
	   public static int titleToNumber(String s) {
	        
	        char[] chs = s.toUpperCase().toCharArray();
	        int result = 0;
	        for (int i = 1; i < chs.length; i++) {
	             result += Math.pow(26, i);
	        }
	        
	        for (int i = 0; i < chs.length; i++) {
	        	if ( i == chs.length-1) {
	        		result += chs[i] - 'A' + 1;
	        	} else {
	        		result += (chs[i]- 'A')* Math.pow(26, chs.length - i - 1);
	        	}
	        }
	        
	        return result;
	    }
	   
	   public static int titleToNumber2(String s) {
		   int result = 0;
		   for (int i = 0; i < s.length(); i++) {
			   char c = s.charAt(i);
			   int val = c - 'A' + 1;
			   result = (int) (result + (val*Math.pow(26, (s.length() - i - 1))));
		   }
		   
		   return result;
	   }
	   
	   public static void main(String[] args) {
		   System.out.println(titleToNumber("ABCKJ"));
		   System.out.println(titleToNumber2("AAA"));
	   }

}
