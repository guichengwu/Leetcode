package String;

import java.math.BigInteger;

public class MultipyString {
    public static String multiply(String num1, String num2) {
    	BigInteger b1 = new BigInteger(num1);
    	BigInteger b2 = new BigInteger(num2);
        
    	BigInteger result = b1.multiply(b2);
    	
    	return result.toString();
        
    }
    
    public static void main(String[] args) {
    	System.out.println(multiply("1234567834567345678989456", "4523543333333346788763456765"));
    }

}
