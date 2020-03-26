/* @author: mrinal-pandey
 * Design a superclass called Staff with details as StaffId, Name, Phone, Salary. 
 * Extend this class by writing three subclasses namely Teaching (domain, publications), Technical (skills),
 * and Contract (period). Write a Java program to read and display at least 3 staff objects of all three categories.
 * */

import java.util.*;

class Staff
{
	static Scanner in=new Scanner(System.in);
	String staffId, name, phone, salary;

	public void getInput()
	{
		System.out.println("Enter Staff Id, Name, Phone and Salary");
		staffId=in.nextLine();
		name=in.nextLine();
		phone=in.nextLine();
		salary=in.nextLine();
	}	

	public void display()
	{
		System.out.println("\nStaff ID:"+staffId+"\nName:"+name+"\nPhone:"+phone+"\nSalary:"+salary);
	}

	public static void main(String args[])
	{
		
		System.out.println("\nEnter the number of Teaching, Technical and Contract objects");
		
		int numberOfTeachingObjects=Integer.valueOf(in.nextLine());
		int numberOfTechnicalObjects=Integer.valueOf(in.nextLine());
		int numberOfContractObjects=Integer.valueOf(in.nextLine());
		
		Teaching teachingObject[]=new Teaching[numberOfTeachingObjects];
		Technical technicalObject[]=new Technical[numberOfTechnicalObjects];
		Contract contractObject[]=new Contract[numberOfContractObjects];

		for(int i=0; i<numberOfTeachingObjects; i++)
		{
			System.out.println("\nEnter Teaching Object Details no."+(i+1));		
			teachingObject[i]=new Teaching();
			teachingObject[i].getInput();
		}
		
		for(int i=0; i<numberOfTechnicalObjects; i++)
		{
			System.out.println("\nEnter Technical Object Details no."+(i+1));		
			technicalObject[i]=new Technical();
			technicalObject[i].getInput();
		}

		for(int i=0; i<numberOfContractObjects; i++)
		{
			System.out.println("\nEnter Contract Object Details no."+(i+1));		
			contractObject[i]=new Contract();
			contractObject[i].getInput();
		}
		
		System.out.println("\n**********************************OUTPUT************************************\n");
		
		for(int i=0; i<numberOfTeachingObjects; i++)
		{
			System.out.println("\nDetails of Teaching Object no."+(i+1));
			teachingObject[i].display();
		}

		for(int i=0; i<numberOfTechnicalObjects; i++)
		{
			System.out.println("\nDetails of Technical Object no."+(i+1));
			technicalObject[i].display();
		}

		for(int i=0; i<numberOfContractObjects; i++)
		{
			System.out.println("\nDetails of Contract Object no."+(i+1));
			contractObject[i].display();
		}
	}
}

class Teaching extends Staff
{
	String domain, publications;

	public void getInput()
	{
		super.getInput();
		System.out.println("Enter Domain and publications");
		domain=in.nextLine();
		publications=in.nextLine();
	}	

	public void display()
	{
		super.display();
		System.out.println("Domain:"+domain+"\nPublications:"+publications+"\n");
	}
}

class Technical extends Staff
{
	String skills;

	public void getInput()
	{
		super.getInput();
		System.out.println("Enter Skills");
		skills=in.nextLine();
	}
	
	public void display()
	{
		super.display();
		System.out.println("Skills:"+skills+"\n");
	}
}

class Contract extends Staff
{
	String period;

	public void getInput()
	{
		super.getInput();
		System.out.println("Enter Period");
		period=in.nextLine();
	}	

	public void display()
	{
		super.display();
		System.out.println("Period:"+period+"\n");
	}
}
