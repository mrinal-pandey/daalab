/* @author: mrinal-pandey
 * Write Java program to Implement All-Pairs Shortest Paths problem using Floyd's algorithm.
 * */

import java.util.*;

class Floyd{
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args){
		System.out.print("Enter the number of vertices : ");
		int n = in.nextInt();
		int[][] graph = new int[n][n];
		Floyd obj = new Floyd();
		obj.readGraph(graph, n);
		obj.floyd(graph, n);
		obj.display(graph, n);
	}

	void readGraph(int[][] graph, int n)
	{
		System.out.println("\nEnter graph:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				graph[i][j] = in.nextInt();
			}
		}
	}

	void floyd(int[][] graph, int n){
		for(int k = 0; k < n; ++k){
			for(int i = 0; i < n; ++i){
				for(int j = 0; j < n; ++j){
					if((graph[i][k] + graph[k][j]) < graph[i][j]){
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}

	void display(int[][] graph, int n){
		System.out.println("\nResult:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(graph[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
