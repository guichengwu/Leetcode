package DataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddAndSearchWord {
	public static List<String> wordList = new ArrayList<String>();
	
	public static void addWord(String word) {
		wordList.add(word);
		
	}
	
	public static boolean search(String word) {
		Iterator<String> wordIterator = wordList.iterator();
		
		while (wordIterator.hasNext()) {
			String w1 = wordIterator.next();
			if (wordCompare(word, w1)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean wordCompare(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}
		
		for (int i = 0; i < word1.length(); i++) {
			char c1 = word1.charAt(i);
			char c2 = word2.charAt(i);
			
			if ((c1 != '.') && (c2 != '.') &&(c1 != c2)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		addWord("bad");
		addWord("dad");
		addWord("mad");
		addWord("a");
		System.out.println(search("pad")); // -> false
		System.out.println(search("bad")); //-> true
		System.out.println(search(".ad")); //-> true
		System.out.println(search("a")); //-> true
	}
	
	

}
