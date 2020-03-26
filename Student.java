/* @author: mrinal-pandey
 * Create a Java class called Student with the following details as variables within it.
	(i) USN
	(ii) Name
	(iii) Branch
	(iv) Phone
   Write a Java program to create n Student objects and print the USN, Name, Branch, and Phone 
   of these objects with suitable headings.
 * */

import java.util.*;

class Student
{

	static Scanner in=new Scanner(System.in);
	String usn, branch, name, phone;

	void getInput()
	{
		System.out.print("Enter USN:	");
		usn=in.nextLine();
		System.out.print("Enter Branch:	");
		branch=in.nextLine();
		System.out.print("Enter Name:	");
		name=in.nextLine();
		System.out.print("Enter Phone:	");
		phone=in.nextLine();
		System.out.println();
	}
	
	void display()
	{
		System.out.format("\nUSN:	%s\nBranch:	%s\nName:	%s\nPhone:	%s\n", usn, branch, name, phone);
	}

	public static void main(String args[])
	{

		String N;
		System.out.println("\nEnter the number of students:");
		N=in.nextLine();
		int n=Integer.valueOf(N);

		Student student[]=new Student[n];
		for(int i=0; i<n; i++)
		{
			student[i]=new Student();	
			student[i].getInput();
		}

		System.out.println("\nThe details entered are:");
		for(int i=0; i<n; i++)
		{
			student[i].display();
		}

	}
}
