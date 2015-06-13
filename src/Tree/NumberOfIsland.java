package Tree;

public class NumberOfIsland {

    //One island means one tree, the question is equal to find how many trees in the 2D grids.
    public int numIslands(char[][] grid) {
    	if (grid == null) {
    		return 0;
    	}
    	int count = 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
    	
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (!marked[i][j] && grid[i][j] == '1') {
        			dfs(grid, marked, i, j);
        			count++;
        		}
        	}
        }
    	
    	return count;
        
    }
    //depth first search
    public void dfs(char[][] grid, boolean[][] marked, int i, int j) {
    	//out of bound
    	if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
    		return;
    	}
    	//visited return
    	if (marked[i][j]) {
    		return;
    	}
    	
    	//1 mark, 0 return
    	if (grid[i][j] == '1') {
    	   marked[i][j] = true;
    	} else {
    		return;
    	}
    	
    	//left 
    	dfs(grid, marked, i-1, j);
    	
    	//right
    	dfs(grid, marked, i+1, j);
    	
    	//up
    	dfs(grid, marked, i, j-1);
    	//down
    	dfs(grid, marked, i, j+1);
    }

}
