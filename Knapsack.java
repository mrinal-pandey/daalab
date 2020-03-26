/* @author: mrinal-pandey
 * Implement in Java, the 0/1 Knapsack problem using
 * (a) Dynamic Programming method
 * (b) Greedy method.
 * */

import java.util.*;

class Details
{
	int weight;
	int value;
}

class Knapsack
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int capacity, n, stolen;
		System.out.print("Enter the capacity of knapsack : ");
		capacity = in.nextInt();
		System.out.print("Enter the number of elements : ");
		n = in.nextInt();
		int[][] table = new int[n+1][n+2];
		Details items[]=new Details[n];
		for(int i=0; i<n; i++)
		{
			items[i] = new Details();
			System.out.print("\nEnter the weight of item "+(i+1)+" : ");
			items[i].weight = in.nextInt();
			System.out.print("Enter the value of item "+(i+1)+" : ");
			items[i].value = in.nextInt();
		}
		System.out.println();

		System.out.println("\nItems available:");
		for(int i=0; i<n; i++)
		{
			System.out.print("Weight = "+items[i].weight+"\tValue = "+items[i].value+"\n");
		}

		for(int i = 0; i < n+1; ++i)
		{
			for(int j = 0; j < n+2; j++)
			{
				if(i == 0 || j == 0)
				{
					table[i][j] = 0;
				}
				else
				{
					table[i][j] = -1;
				}
			}
		}

		stolen = greedy(items, capacity, n);
		System.out.print("Profit : "+stolen+"\n");

		stolen = dynamic(items, capacity, n);
		System.out.print("Profit : "+stolen+"\n");
		
		System.out.println("\nPicked values[Dynamic using Memory Function]:");
		System.out.println("Weight\tValue");
		stolen = MFKnapsack(items, table, n, n+1);
		picked(table, items, n);
		System.out.print("Profit : "+stolen+"\n");

	}

	public static int MFKnapsack(Details[] items, int[][] table, int i, int j)
	{
		if(table[i][j] < 0)
		{
			if(j < items[i-1].weight)
			{
				table[i][j] = MFKnapsack(items, table, i-1, j);
			}
			else
			{
				int value = max(MFKnapsack(items, table, i-1, j), items[i-1].value + MFKnapsack(items, table, i-1, j-items[i-1].weight));
				table[i][j] = value;
			}
		}
		return table[i][j];
	}

	public static int max(int a, int b)
	{
		if(a > b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	
	public static int dynamic(Details items[], int capacity, int n)
	{
		int[][] table = new int[n+1][n+2];
		
		for(int i = 1; i < n+1; i++)
		{
			for(int j = 1; j < n+2; j++)
			{
				if(items[i-1].weight <= j)
				{
					if((table[i-1][j-items[i-1].weight]+items[i-1].value) > table[i-1][j])
					{
						table[i][j] = table[i-1][j-items[i-1].weight]+items[i-1].value;
					}
					else
					{
						table[i][j] = table[i-1][j];
					}
				}
				else
				{
					table[i][j] = table[i-1][j];
				}
			}
		}

		System.out.println("\nPicked values[Dynamic]:");
		System.out.println("Weight\tValue");
		picked(table, items, n);
		return table[n][n+1];
	}

	public static void picked(int[][] table, Details[] items, int n)
	{
		int i = n;
		int j = n + 1;
		while(i > 0 && j > 0)
		{
			if(table[i][j]>table[i-1][j])
			{
				System.out.print(items[i-1].weight + "\t" + items[i-1].value + "\n");
				j = j - items[i-1].weight;
				--i;
			}
			else
			{
				--i;
			}
		}
	}

	public static int greedy(Details items[], int capacity, int n)
	{
		int pos = 0, steal = 0, noOfTimes = n;
		
		int itemsPicked[] = new int[n];
		
		while((noOfTimes--) != 0)
		{
			pos = 0;
			int max = -1;
			for(int i=0; i<n; i++)
			{
				if(itemsPicked[i] != 1 && itemsPicked[i] != -1)
				{
					if(items[i].value > max)
					{	
						max = items[i].value;
						pos = i;
					}
				}
			}
			if(items[pos].weight <= capacity)
			{
				itemsPicked[pos] = 1;
				steal+= items[pos].value;
				capacity-= items[pos].weight;
			}
			else
			{
				itemsPicked[pos] = -1;
			}
		}
		
		System.out.println("\nPicked values[Greedy]:");
		System.out.println("Weight\tValue");
		
		for(int i = 0; i < n; i++)
		{
			if(itemsPicked[i] == 1)
			{
				System.out.print(items[i].weight+"\t"+items[i].value+"\n");
			}
		}
		return steal;

	}
}
