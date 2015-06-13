package LinkedList;

public class SearchWord {
	private boolean solution = false;
	private boolean[][] visited;

	private class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		/**
		 * 
		 * @param dir
		 *            0 : up; 1 : right; 2 : down; 3 : left
		 * @return
		 */
		public Point getNext(int dir) {
			Point newPoint = new Point(this.x, this.y);
			switch (dir) {
			case 0: {
				newPoint.y--;
				break;
			}
			case 1: {
				newPoint.x++;
				break;
			}
			case 2: {
				newPoint.y++;
				break;
			}
			case 3: {
				newPoint.x--;
			}
			}

			return newPoint;
		}
	}

	public boolean exist(char[][] board, String word) {
		solution = false;
		int columns = board[0].length;
		int rows = board.length;
		visited = new boolean[rows][columns];
		for (int col = 0; col < columns; col++) {
			for (int row = 0; row < rows; row++) {
				if (board[row][col] == word.charAt(0))
					backtrack(board, new Point(col, row), 0, word);
				if (solution) {
					return true;
				}
			}
		}

		return false;
	}

	private void backtrack(char[][] board, Point p, int k, String word) {
		if (k == word.length()) {
			solution = true;
		} else {
			if (p.getX() < 0 || p.getX() >= board[0].length || p.getY() < 0
					|| p.getY() >= board.length) {
				return;
			}
			if (board[p.getY()][p.getX()] != word.charAt(k)) {
				return;
			}

			if (visited[p.getY()][p.getX()] == true) {
				return;
			}
			
			visited[p.getY()][p.getX()] = true;

			for (int i = 0; i < 4; i++) {
				Point nextPoint = p.getNext(i);
				backtrack(board, nextPoint, k + 1, word);
				if (solution) {
					return;
				}
			}

			visited[p.getY()][p.getX()] = false;
		}
	}

}
