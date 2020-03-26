/* @author: mrinal-pandey
 * From a given vertex in a weighted connected graph, find shortest paths to other vertices
 * using Dijkstra's algorithm. Write the program in Java.
 * */

import java.util.*;

class Dijkstra{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Dijkstra dijkstraObj = new Dijkstra();
		System.out.print("Enter the number of vertices:");
		int V = in.nextInt();
		System.out.print("\nEnter graph:\n");
		int[][] graph = new int[V][V];
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				graph[i][j] = in.nextInt();
			}
		}
		dijkstraObj.dijkstraAlgo(graph, V);
	}

	int minValue(int keys[], boolean taken[], int V){
		int min = Integer.MAX_VALUE;
		int minPos = -1;
		for(int i = 0; i < V; i++){
			if(taken[i] == false && keys[i] <= min){
				min = keys[i];
				minPos = i;
			}
		}
		return minPos;
	}

	void dijkstraAlgo(int graph[][], int V){
		int[] keys = new int[V];
		int[] parent = new int[V];
		boolean[] taken = new boolean[V];
		for(int i = 0; i < V; i++){
			keys[i] = Integer.MAX_VALUE;
			taken[i] = false;
		}
		keys[0] = 0;
		parent[0] = -1;
		for(int i = 0; i < V - 1; i++){
			int minPos = minValue(keys, taken, V);
			taken[minPos] = true;
			for(int j = 0; j < V; j++){
				if((taken[j] == false) && (graph[minPos][j] != 0) 
					&& (keys[minPos] != Integer.MAX_VALUE) && 
					(graph[minPos][j] + keys[minPos] < keys[j])){
						keys[j] = graph[minPos][j] + keys[minPos];
						parent[j] = minPos;
					}
				}
			}

		displaySoln(V, keys, parent);
	}

	void displaySoln(int V, int keys[], int[] parent){
		System.out.print("\nVertex\tDistance from 0\n");
		for(int i = V - 1; i > 0; --i){
			String path = String.valueOf(i);
			int j = i;
			while(parent[j] != 0){
				path = path + " <- " + String.valueOf(parent[j]);
				j = parent[j];
			}
			path = path + " <- 0";
			System.out.print(i + "\t" + keys[i] + " [" + path + "]" + "\n");
		}
	}
}
