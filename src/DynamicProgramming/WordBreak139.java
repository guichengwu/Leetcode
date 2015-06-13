package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak139 {
	
	public Map<String, Boolean> stringMap = 
		new HashMap<String, Boolean>();
    public boolean wordBreak(String s, Set<String> wordDict) {
    	
    	if (stringMap.containsKey(s)) 
    		return stringMap.get(s);
    	
    	if (s.isEmpty())
    		return true;
    	
    	int l = s.length();
    	
    	for (int i = 0; i < l; i++) {
    		if (wordDict.contains(s.substring(0, i+1))) {
    			String newString = s.substring(i+1);
    			boolean breakNewString = wordBreak(s.substring(i+1), wordDict);
    			
    			stringMap.put(newString, breakNewString);
    			if(breakNewString)
    				return true;
    		}
    	}
    	
    	return false;
    }
    
    public static boolean wordBreak2(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++)
            for (int j=0; j<i; j++)
                if (f[j] && wordDict.contains(s.substring(j,i)))
                {
                    f[i] = true;
                    break;
                }
        return f[len];
    }
    
    Map<String, Boolean> map = new HashMap<String, Boolean>();
    public boolean wordBreak3(String s, Set<String> wordDict) {
        if (map.containsKey(s))
            return map.get(s);

        if (s.isEmpty())
            return true;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                String newString = s.substring(i + 1);
                boolean breakNewString = wordBreak3(s.substring(i + 1), wordDict);
                map.put(newString, breakNewString);
                if (breakNewString)
                    return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	Set<String> set = new HashSet<String>();
    	WordBreak139 w = new WordBreak139();
    	set.add("pie");
    	set.add("pear");
    	set.add("apple");
    	set.add("peach");
    	String s = "applepie";
    	System.out.println(w.wordBreak(s, set));
    }

}
