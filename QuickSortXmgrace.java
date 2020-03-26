/* @author: mrinal-pandey
 * Sort a given set of n integer elements using Quick Sort method and compute its time complexity.
 * Run the program for varied values of n > 5000 and record the time taken to sort.
 * Plot a graph of the time taken versus non graph sheet. The elements can be read from a file
 * or can be generated using the random number generator.
 * Demonstrate using Java how the divide-and-conquer method works along with its time complexity analysis: 
 * worst case, average case and best case.
 * */

import java.util.*;
import java.io.*;

class QuickSortXmgrace
{
	public static void main(String args[])throws IOException
	{
		Scanner in=new Scanner(System.in);
		File graphFile=new File("quickSortGrace.txt");
		FileWriter fileWriter=new FileWriter(graphFile);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		//bufferedWriter.write("TitleText: QuickSort Plot\n");
		//bufferedWriter.write("XUnitText: Arraysize\n");
		//bufferedWriter.write("YUnitText: TimeinMillis\n");
	
		//bufferedWriter.write("\n");
		//bufferedWriter.write("\"quicksORT\"\n");
		//bufferedWriter.write("\n");
		for(int i=5000; i<=50000; i+=1000)
		{
			int a[]=new int[i];
			for(int j=0; j<i; j++)
			{
				a[j]=(int)(Math.random()*500+1);
			}
			double startTime=System.currentTimeMillis();
			quickSort(a, 0, i-1);
			double endTime=System.currentTimeMillis();
			bufferedWriter.write(i+"\t"+(endTime-startTime)*Math.pow(10,-3)+"\n");
		}
		bufferedWriter.close();
		try {
	
		Process p=Runtime.getRuntime().exec("xmgrace quickSortGrace.txt");
		p.waitFor();

		}
		catch(Exception e){}
	}

	public static void quickSort(int a[], int l, int r)
	{
		if(l<r)
		{
			int p=partition(a, l, r);
			quickSort(a, l, p-1);
			quickSort(a, p+1, r);
		}
	}

	public static int partition(int a[], int l, int r)
	{
		int pivot=a[r], temp;
		int i=l-1, j;
		for(j=l; j<r; j++)
		{
			if(a[j]<=pivot)
			{
				i++;
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		temp=a[i+1];
		a[i+1]=a[r];
		a[r]=temp;
		return (i+1);
	}
}
