/* @author: mrinal-pandey
 * Write a Java class called Customer to store their name and date_of_birth. 
 * The date_of_birth format should be dd/mm/yyyy. Write methods to read customer data as 
 * <name, dd/mm/yyyy> and display as <name, dd, mm, yyyy> using StringTokenizer class 
 * considering the delimiter character as “/”.
 * */

import java.util.*;

class Customer
{
	static Scanner in=new Scanner(System.in);
	String name, dob;

	public void getInput()
	{
		System.out.print("Enter Name:	");
		name=in.nextLine();
		System.out.print("Enter DOB:	");
		dob=in.nextLine();
		System.out.println();
	}	

	public void display(String name, String dd, String mm, String yyyy)
	{
		System.out.println("Name:	"+name+"\nDD:	"+dd+"\nMM:	"+mm+"\nYYYY:	"+yyyy+"\n");
	}

	public static void main(String args[])
	{
		System.out.print("Enter the number of customers:");
		String N=in.nextLine();
		int n=Integer.parseInt(N);
		System.out.println();
		Customer customer[]=new Customer[n];

		for(int i=0; i<n; i++)
		{
			System.out.println("Enter details of customer no."+(i+1));
			customer[i]=new Customer();
			customer[i].getInput();
		}

		for(int i=0; i<n; i++)
		{
			int index=0;
			String tokens[]=new String[3];
			StringTokenizer token=new StringTokenizer(customer[i].dob, "/");
		
			while(token.hasMoreTokens())
			{
				tokens[index]=token.nextToken();
				index++;
			}
		
			customer[i].display(customer[i].name, tokens[0], tokens[1], tokens[2]);
		}
	}
}
