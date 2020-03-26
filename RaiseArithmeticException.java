/* @author: mrinal-pandey
 * Write a Java program to read two integers a and b.
 * Compute a/b and print, when b is not zero. Raise an exception when b is equal to zero.
 * */

import java.util.*;

class RaiseArithmeticException
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int a, b;
		System.out.print("Enter a:");
		a=in.nextInt();
		System.out.print("Enter b:");
		b=in.nextInt();
		try
		{
			int result=a/b;
			System.out.println("Result="+result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception produced:\n"+e.toString());
		}
	}
}
