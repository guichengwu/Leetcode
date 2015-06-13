package String;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
	    
        char[] charArray = s.trim().toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                count++;
            }  else {
            count = 0;
            	}
        }
        
        return count;
    }
    
	public static int lengthOfLastWord2(String s) {
		s = s.trim();
		int lastIndexOfSpace = s.lastIndexOf(" ");
		
		//no space
		if (lastIndexOfSpace < 0) {
			return s.length();
		} else {
			String lastWord = s.substring(lastIndexOfSpace + 1);
			return lastWord.length();
		}
		
		
	}
    public static void main(String[] args) {
    	System.out.println(lengthOfLastWord2("   s s ss   "));
    }
}
