/* @author: mrinal-pandey
 * Write a Java program that implements a multi-thread application that has three threads.
 * First thread generates a random integer for every 1 second;
 * second thread computes the square of the number and prints;
 * third thread will print the value of cube of the number.
 * */

import java.util.*;

class MultiThreading
{
	public static void main(String args[])
	{
		Thread random=new Thread(new RandomNumberGenerator());
		random.start();
		Square square=new Square();
		square.start();
		Cube cube=new Cube();
		cube.start();
	}
}

class Square extends Thread
{
	public int x[]={2, 4, 6};
	public void run()
	{
		try
		{
			for(int i=1; i<=3; i++)
			{
				System.out.println("Square="+(x[i-1]*x[i-1])+"\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class Cube extends Thread
{
	public int x[]={2, 4, 6};
	public void run()
	{
		try
		{
			for(int i=1; i<=3; i++)
			{
				System.out.println("Cube="+(x[i-1]*x[i-1]*x[i-1])+"\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class RandomNumberGenerator implements Runnable
{
	public int random;
	public void run()
	{
		try
		{
			for(int i=1; i<=3; i++)
			{
				Thread.sleep(1000);
				random = (int)(Math.random() * 50 + 1);
				System.out.println("Random="+random+"\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
