package String;

public class AddBinary {

	public static String addBinary2(String a, String b) {
		char[] chs1 = a.toCharArray();
		char[] chs2 = b.toCharArray();
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;
		int carry = 0;
		String result = "";
		while (indexA >=0 || indexB >= 0) {
			int tempA = 0, tempB = 0; 
			if (indexA >= 0) {
				tempA = chs1[indexA--] - '0';
			}
			if (indexB >= 0) {
				tempB = chs2[indexB--] - '0';
			}
			
			int tempR = tempA + tempB + carry;
			if (tempR > 1) {
				carry = 1;
			} else {
				carry = 0;
			}
			result = (tempR % 2) + result;
		}
		
		if (carry == 1) {
			result = '1' + result;
		}
			
		return result;
	}
    public static String addBinary(String a, String b) {
    	int integer1 = transferStringToInt(a);
    	int integer2 = transferStringToInt(b);
    	int result = integer1 + integer2;
        return Integer.toBinaryString(result);
    }
    
    public static int transferStringToInt(String s) {
    	int result = 0;
    	for (int i = 0; i < s.length(); i++) {
    		result = result * 2;
    		char c = s.charAt(i);
    		result += c - '0';
    	}
    	
    	return result;
    }
    
    public static String transferIntToBinaryString(int x) {
    	String s = null;
    	if (x == 0) {
    		return "0";
    	}
    	
    	while (x > 0) {
    		int c = x % 2 + '0';
    		s = c + s;
    		x = x / 2;
    	}
    	
    	return s;
    }
    
    public static void main(String[] args) {
        System.out.println(addBinary2("1010010", "0111"));
    }
    
}
