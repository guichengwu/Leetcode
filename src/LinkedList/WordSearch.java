package LinkedList;

public class WordSearch {
	private boolean solution = false;
	private boolean[][] mark;

	public boolean exist(char[][] board, String word) {
	    //find first match & do backtracking
	    solution = false;
	    int sizey = board.length;
	    int sizex = board[0].length;
	    mark = new boolean[sizey][sizex];

	    for(int x = 0; x < sizex; x++) {
	        for (int y = 0; y < sizey; y++) {
	            if (board[y][x] == word.charAt(0)) backtrack(board, new Point(x,y), 0 , word);
	            if(solution) return true;
	        }
	    }
	    return false ;  
	}

	private void backtrack(char[][] board, Point p, int k, String word ) {
	    if (k == word.length()) { 
	        solution = true;
	    }
	    else {
	        if(p.getX() < 0 || p.getX() >= board[0].length || 
	                p.getY() < 0 || p.getY() >= board.length) return; //out of bound
	        if (board[p.getY()][p.getX()] != word.charAt(k)) return; //terminate
	        if (mark[p.getY()][p.getX()] == true) return;
	        mark[p.getY()][p.getX()] = true;

	        for(int i = 0; i < 4; i++) { //for all direction
	            Point nextPoint = p.getNext(i);
	            backtrack(board, nextPoint, k+1, word);
	            if(solution)return;
	        }

	        mark[p.getY()][p.getX()] = false;
	    }
	}

	private class Point {
	    private int x;
	    private int y;

	    public Point (int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    public int getX() {return this.x;}
	    public int getY() {return this.y;}

	    public Point getNext(int dir) {
	        Point newPoint = new Point(this.x, this.y);
	        switch(dir) {
	            case 0: newPoint.y--;break;
	            case 1: newPoint.x++;break;
	            case 2: newPoint.y++;break;
	            case 3: newPoint.x--;break;
	        }
	        return newPoint;
	    }
	}

}
