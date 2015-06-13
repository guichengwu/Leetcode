package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak140 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();

        
        return result;
    }
    
    List<HashSet<String>> list = new ArrayList<HashSet<String>>();
    HashSet<String> oneSolution = new HashSet<String>();
    public boolean wordBreakHelp(String s, Set<String> wordDict) {
    	HashSet<String> oneSolution = new HashSet<String>();
    	if (s == "") {
    		return true;
    	}
    	
    	for (int i = 0; i < s.length(); i++) {
    		String firstPart = s.substring(0, i+1);
    		
    		if (wordDict.contains(firstPart)) {
    			boolean result = wordBreakHelp(s.substring(i+1), wordDict);
    			
    			if (result) {
    				oneSolution.add(firstPart);
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }

}
