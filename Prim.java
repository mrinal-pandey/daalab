/* @author: mrinal-pandey
 * Find Minimum Cost Spanning Tree of a given connected undirected graph using Prim's algorithm.
 * */

import java.util.*;

class Prim{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Prim primObj = new Prim();
		System.out.print("Enter the number of vertices:");
		int V = in.nextInt();
		System.out.print("\nEnter graph:\n");
		int[][] graph = new int[V][V];
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				graph[i][j] = in.nextInt();
			}
		}
		primObj.primsAlgo(graph, V);
	}

	int minValue(int keys[], boolean taken[], int V){
		int min = Integer.MAX_VALUE;
		int minPos = -1;
		for(int i = 0; i < V; i++){
			if(keys[i] < min && taken[i] != true){
				min = keys[i];
				minPos = i;
			}
		}
		return minPos;
	}

	void primsAlgo(int graph[][], int V){
		int[] keys = new int[V];
		int[] selected = new int[V];
		boolean[] taken = new boolean[V];
		for(int i = 0; i < V; i++){
			keys[i] = Integer.MAX_VALUE;
			taken[i] = false;
		}
		keys[0] = 0;
		selected[0] = -1;
		for(int i = 0; i < V - 1; i++){
			int minPos = minValue(keys, taken, V);
			taken[minPos] = true;
			for(int j = 0; j < V; j++){
				if((graph[minPos][j] != 0) && (taken[j] == false) && (graph[minPos][j] < keys[j])){
					selected[j] = minPos;
					keys[j] = graph[minPos][j];
				}
			}
		}
		displaySoln(selected, V, graph);
	}

	void displaySoln(int selected[], int V, int graph[][]){
		System.out.print("\nEdges selected:\n");
		for(int i = 1; i < V; i++){
			System.out.println(selected[i] + "---" + i + "\t" + graph[i][selected[i]]);
		}
	}
}
