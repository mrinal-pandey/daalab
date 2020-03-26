/* @author: mrinal-pandey
 * Design and implement in Java to find all Hamiltonian Cycles in a connected undirected Graph G
 * of n vertices using backtracking principle.
 * */

import java.util.*;
class Hamiltonian{
	static boolean flag = false;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Hamiltonian obj = new Hamiltonian();
		System.out.print("Enter the number of vertices : ");
		int V = in.nextInt();
		int[][] graph = new int[V + 1][V + 1];
		System.out.println("\nEnter graph:");
		for(int i = 1; i <= V; ++i){
			for(int j = 1; j <= V; ++j){
				graph[i][j] = in.nextInt();
			}
		}
		boolean[] mark = new boolean[V + 1];
		mark[0] = mark[1] = true;
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(1);
		System.out.println();
		obj.findHamiltonianCycle(graph, V, mark, 1, path);
		if(flag == false){
			System.out.println("No hamiltonian cycle found");
		}
	}
	void findHamiltonianCycle(int[][] graph, int V, boolean[] mark, int vertex, ArrayList<Integer> path){
		if(allOne(mark) == true){
			if(graph[vertex][1] == 1){
				display(path);
				flag = true;
			}
		}
		for(int i = 1; i <= V; ++i){
			if(graph[vertex][i] == 1 && mark[i] == false){
				mark[i] = true;
				path.add(i);
				findHamiltonianCycle(graph, V, mark, i, path);
				mark[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}
	void display(ArrayList<Integer> path){
		for(int i = 0; i < path.size(); ++i){
			System.out.print(path.get(i) + " ---> ");
		}
		System.out.println("1\n");
	}
	boolean allOne(boolean[] mark){
		for(boolean i : mark){
			if(i == false){
				return false;
			}
		}
		return true;
	}
}
