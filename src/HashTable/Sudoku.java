package HashTable;

import java.util.*;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
    	
    	int rows = board.length;
    	int cols = board[0].length;
    	
    	Set<Character> set = new HashSet<Character>();
    	//check each row
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    		    if (board[i][j] != '.') {
    		    	if (!set.add(board[i][j])) {
    		    		return false;
    		    	}
    		    }
    		}
    		set.clear();
    	}
    	
    	//check every col
    	for (int i = 0; i < cols; i++) {
    		for (int j = 0; j < rows; j++) {
    			if (board[j][i] != '.') {
    				if (!set.add(board[j][i])) {
    					return false;
    				}
    			}
    		}
    		set.clear();
    	}
    	
		// check 9 boxs
		for (int i = 0; i < rows / 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < cols / 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (board[i * 3 + k][j * 3 + l] != '.') {
							if (!set.add(board[i * 3 + k][j * 3 + l])) {
								return false;
							}
						}
					}
				}
				set.clear();
			}
		}
		
		return true;
        
    }

}
