/* @author: mrinal-pandey
 * Write Java programs to Implement Travelling Sales Person problem using Dynamic programming.
 * */

import java.util.*;
class Element{
	int src;
	int k;
	int setEle;
	int min;
}
class TSP{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of cities : ");
		int N = in.nextInt();
		int[][] graph = new int[N + 1][N + 1];
		System.out.println("\nEnter graph : ");
		for(int i = 1; i <= N; ++i){
			for(int j = 1; j <= N; ++j){
				graph[i][j] = in.nextInt();
			}
		}
		TSP tsp = new TSP();
		int[] S = new int[N + 1];
		for(int i = 2; i <= N; ++i){
			S[i] = 1;
		}
		ArrayList<Element> element = new ArrayList<Element>();
		System.out.println("\nCost : " + tsp.tspAlgo(1, graph, N, S, element));
		tsp.printPath(element, N);
	}
	void printPath(ArrayList<Element> element, int N){
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(1);
		int[] mark = new int[N + 1];
		mark[0] = mark[1] = 1;
		int source = 1;
		int setEle = N - 1;
		while(allOne(mark, N) == false){
			Element minNode = new Element();
			minNode.min = 9999;
			for(Element e : element){
				if(e.src == source && e.setEle == setEle && e.min < minNode.min && mark[e.k] != 1){
					minNode = e;
				}
			}
			mark[minNode.k] = 1;
			source = minNode.k;
			--setEle;
			path.add(source);
		}
		for(int i = 0; i < path.size(); ++i){
			System.out.print(path.get(i) + " ---> ");
		}
		System.out.println("1");
	}
	boolean allOne(int[] S, int N){
		for(int i = 0; i <= N; ++i){
			if(S[i] != 1){
				return false;
			}
		}
		return true;
	}
	boolean allZero(int[] S, int N){
		for(int i = 0; i <= N; ++i){
			if(S[i] != 0){
				return false;
			}
		}
		return true;
	}
	int tspAlgo(int src, int[][] graph, int N, int[] S, ArrayList<Element> element){
		int min = 9999;
		int pos = 9999;
		if(allZero(S, N) == true){
			return graph[src][1];
		}
		for(int k = 2; k <= N; ++k){
			if(S[k] != 0){
				S[k] = 0;
				int temp = graph[src][k] + tspAlgo(k, graph, N, S, element);
				if(min > temp){
					min = temp;
					pos = k;
				}
				S[k] = 1;
			}
		}
		if(pos != 9999){
			Element temp = new Element();
			temp.src = src;
			temp.k = pos;
			temp.setEle = countOne(S);
			temp.min = min;
			element.add(temp);
		}
		return min;
	}
	int countOne(int[] S){
		int c = 0;
		for(int i : S){
			if(i == 1){
				++c;
			}
		}
		return c;
	}
}
