/* @author: mrinal-pandey
 * Write a Java program to implement the Stack using arrays. Write Push(), Pop(), and Display() 
 * methods to demonstrate its working.
 * */

import java.util.*;

class Stack
{
	static final int MAX=5;
	static int stack[]=new int[MAX];
	static int TOP=-1;

	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int choice, value, proceed;

		do
		{
			System.out.print("\n1.Push\n2.Pop\n3.Display\nEnter your choice:");
			choice=in.nextInt();
			
			switch(choice)
			{
				case 1:
					if(TOP==MAX-1)
					{
						System.out.println("Stack is Full!");
					}
					else
					{
						System.out.print("Enter the value to be pushed:");
						value=in.nextInt();
						push(value);
						display();
					}
					break;
				case 2:
					value=pop();
					if(value!=TOP)
					{
						System.out.println("Value deleted is:"+value);
						display();
					}
					break;
				case 3:
					display();
					break;
				default:
					System.out.println("\nEnter a valid option!\n");
			}
			
			System.out.println("Continue(0/1)?");
			proceed=in.nextInt();

		}while(proceed==1);

	}

	static void push(int value)
	{
		stack[++TOP]=value;
	}

	static int pop()
	{
		if(TOP==-1)
		{
			System.out.println("Stack is empty!");
			return TOP;
		}
		else
		{
			return stack[TOP--];
		}
	}

	static void display()
	{
		for(int i=TOP; i>-1; i--)
		{
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}

}
