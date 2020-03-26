/* @author: mrinal-pandey
 * Sort a given set of n integer elements using Merge Sort method and compute its time complexity.
 * Run the program for varied values of n > 5000, and record the time taken to sort.
 * Plot a graph of the time taken versus non graph sheet. The elements can be read from a file
 * or can be generated using the random number generator.
 * Demonstrate using Java how the divide-and-conquer method works along with its time complexity analysis: 
 * worst case, average case and best case.
 * */

import java.util.*;
import java.io.*;
class MergeSortXmgrace
{
	public static void main(String args[])throws IOException
	{
		Scanner in=new Scanner(System.in);
		File graphFile=new File("mergeSortGrace.txt");
		FileWriter fileWriter=new FileWriter(graphFile);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

		//bufferedWriter.write("TitleText: MergeSort Plot\n");
		//bufferedWriter.write("XUnitText: Arraysize\n");
		//bufferedWriter.write("YUnitText: TimeinMillis\n");
	
		//bufferedWriter.write("\n");
		//bufferedWriter.write("\"MERGEsORT\"\n");
		//bufferedWriter.write("\n");
		for(int i=5000; i<=50000; i+=1000)
		{
			int array[]=new int[i];
			for(int j=0; j<i; j++)
			{
				int random = (int)(Math.random() * 500 + 1);
				array[j]=random;
			}
			double start=System.currentTimeMillis();
			mergeSort(array, i);
			double end=System.currentTimeMillis();

			bufferedWriter.write(i+"\t"+(end-start)*Math.pow(10,-3)+"\n");
		}

		bufferedWriter.close();
		try {
	
		Process p=Runtime.getRuntime().exec("xmgrace mergeSortGrace.txt");
		p.waitFor();

		}
		catch(Exception e){}
	}

	public static void mergeSort(int a[], int n)
	{
		if(n>1)
		{
			int floorValue=(int)Math.floor((double)n/2);
			int ceilValue=(int)Math.ceil((double)n/2);
			int[] b=new int[floorValue];
			int[] c=new int[ceilValue];
			int k=0;
			for(int i=0; i<=floorValue-1; i++)
			{
				b[k]=a[i];
				k++;
			}
			k=0;
			for(int i=floorValue; i<n; i++)
			{
				c[k]=a[i];
				k++;
			}
			mergeSort(b, floorValue);
			mergeSort(c, ceilValue);
			merge(b, floorValue, c, ceilValue, a, floorValue+ceilValue);
		}

	}

	public static void merge(int b[], int p, int c[], int q, int a[], int r)
	{
		int i=0, j=0, k=0;
		while(i<p && j<q)
		{
			if(b[i]<=c[j])
			{
				a[k]=b[i];
				i++;
			}
			else
			{
				a[k]=c[j];
				j++;
			}
			k++;
		}

		if(i==p)
		{
			for(int g=k; g<r && j<q; g++)
			{
				a[g]=c[j];
				j++;
			}
		}
		else
		{
			for(int g=k; g<r && i<p; g++)
			{
				a[g]=b[i];
				i++;
			}
		}
	}

}
