package String;

import java.util.*;

public class ReverseString {
    public static String reverseWords(String s) {
    	 s= s.trim();
          List<String> list = new ArrayList<String>();
          int k = 0;
          int index = 0;
          while (index != -1) {
        	  index = s.indexOf(" ", k);
        	  if (index == -1) {
        		  break;
        	  }
        	  String subString = s.substring(0, index);
        	  list.add(subString);
        	  s= s.substring(index + 1).trim();
          }
          
          list.add(s);
          String result = "";
          for (int i = list.size() - 1; i >=0 ; i--) {
        	     result += list.get(i);
        	     if (i == 0) {
        	    	 break;
        	     }
        	     
        	     result += " ";
          }
          
          return result;
    }
    
    public static void main(String[] args) {
    	    System.out.println(reverseWords(" b    a  "));
    }
}
