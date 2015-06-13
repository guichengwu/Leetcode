package Graph;

public class CourseSchedule {
	
	public class Node {
		int val;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	public class Edge {
		Node start;
		Node end;
		
		public Edge(Node start, Node end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public class Graph {
		Edge[] edges;
		int edgeCount = 0;
		//Edge nums to initlize graph
		public Graph (int edgeNum) {
			edges = new Edge[edgeNum];
		}
		public void addEdge(Edge e) {
			if (edgeCount >= edges.length) {
				return;
			}
			
			edges[edgeCount++] = e;
		}
	}
    //build directed graph, and find cycle
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph graph = new Graph(prerequisites.length);
        int course = 0;
        int coursePre = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < 2; j++) {
                course = prerequisites[i][0];
                coursePre = prerequisites[i][1];
                Node start = new Node(coursePre);
                Node end = new Node(course);
                Edge edge = new Edge(start, end);
                
                graph.addEdge(edge);
            }
        }
        
        return false;
    }
    

}
