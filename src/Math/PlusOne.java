package Math;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
         int[] result = new int[digits.length + 1];
         for (int i = digits.length; i > 0; i--) {
        	 result[i] = digits[i - 1];
         }
         
         result[0] = 1;
         
         for (int i = digits.length -1; i >= 0; i--) {
        	 if (digits[i] < 9) {
        		 digits[i]++;
        		 break;
        	 } else {
        		 digits[i] = 0;
        		 if (i == 0) {
        	         for (int j = digits.length; j > 0; j--) {
        	        	 result[j] = digits[j - 1];
        	         }
        	         
        			 return result;
        		 }
        	 }
         }
        
         return digits;
    }
    public static void printCharArray(int[] chs) {
    	for (int i = 0; i < chs.length; i++)
    		System.out.println(chs[i]);
    		
    }
    
    public static void main(String[] args) {
    	int[] digits = {2, 8, 9 ,1};
    	printCharArray(plusOne(digits));
    }

}
