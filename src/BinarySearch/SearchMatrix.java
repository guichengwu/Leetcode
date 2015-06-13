package BinarySearch;

public class SearchMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
	        for (int i = 0; i < matrix.length; i++) {
	            if (binarySearchRow(matrix, target, i, 0, matrix[0].length - 1)) {
	                return true;
	            }
	        }
	        
	        return false;   
	    }
	 
	 public boolean searchMatrix2(int[][] matrix, int target) {
         int possibleRow = 0;
	        for (int i = 0; i < matrix.length; i++) {
	            if (matrix[i][0] == target) {
	                return true;
	            }
	            if (matrix[i][0] > target) {
	                possibleRow = i;
	                break;
	            }
	            if (i == matrix.length - 1) {
	                possibleRow = matrix.length;
	            }
	        }
	        
	        for (int i = 0; i < possibleRow; i++) {
	            if (binarySearchRow(matrix, target, i, 0, matrix[0].length - 1)) {
	                return true;
	            }
	        }
	        
	        return false;   
	 }
	    
	    public boolean binarySearchRow(int[][] matrix, int target, int row, int start, int end) {
	        
	        if (start > end) {
	        	return false;
	        }
	        
	        int midIndex = (start + end) / 2;
	        int midValue = matrix[row][midIndex];
	        
	        
	        if (midValue == target) {
	            return true;
	        }
	        
	        if (midValue < target) {
	            return binarySearchRow(matrix, target, row, midIndex+1, end);
	        } else {
	            return binarySearchRow(matrix, target, row, start, midIndex-1);
	        }
	    }

}
