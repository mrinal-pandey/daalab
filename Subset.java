/* @author: mrinal-pandey
 * Design and implement in Java to find a subset of a given set S = {Sl, S2,.....,Sn} of n positive integers
 * whose SUM is equal to a given positive integer d. For example, if S = {1, 2, 5, 6, 8} and d= 9,
 * there are two solutions {1,2,6} and {1,8}. Display a suitable message,
 * if the given problem instance doesn't have a solution.
 * */

import java.util.*;
class Subset{

	static boolean flag = false;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Subset obj = new Subset();
		System.out.print("Enter the size of set : ");
		int N = in.nextInt();
		int[] set = new int[N];
		int[] mark = new int[N];
		int sumEle = 0;
		System.out.print("Enter elements in non decreasing order:\n");
		for(int i = 0; i < N ; ++i){
			set[i] = in.nextInt();
			sumEle += set[i];
		}
		System.out.print("Enter sum value : ");
		int sum = in.nextInt();
		for(int i = 0; i < N; ++i){
			mark[i] = -1;
		}
		obj.findSubset(0, 0, sumEle, sum, N, mark, set);
		if(!flag){
			System.out.println("Sorry! No Subsets found!");
		}
	}

	void findSubset(int s, int k, int sumEle, int sum, int N, int[] mark, int[] set){	
		mark[k] = 1;
		if(s + set[k] == sum){
			flag = true;
			System.out.print("{");
			for(int i = 0; i < N; ++i){
				if(mark[i] == 1){
					System.out.print(set[i] + ", ");
				}
			}
			System.out.println("\b\b}");
		}
		if(k < N - 1){
			if((s + set[k] + set[k + 1]) <= sum ){
				findSubset(s + set[k], k + 1, sumEle - set[k], sum, N, mark, set);
			}
			if((s + sumEle - set[k] >= sum) && (s + set[k + 1] <= sum)){
				mark[k] = 0;
				findSubset(s, k + 1, sumEle - set[k], sum, N, mark, set);
			}
		}
		mark[k] = 0;
	}
}
