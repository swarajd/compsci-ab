//Brian Truong
//Period 5

import java.util.Scanner;
import java.util.ArrayList;

public class SuperPrime
{
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static long starttime = System.currentTimeMillis();
	
	static void initList(int input1)
	{
		String input2 = "1", input3 = "9";
		for(int i = input1; i > 0; i--)
		{
			input2 = input2.concat("0");
			input3 = input3.concat("9");
		}
		
		int lowerBound = Integer.parseInt(input2);
		int upperBound = Integer.parseInt(input3);
		
		for(int i = lowerBound; i <= upperBound; i++)
		{
			System.out.println("still putting" + i);
			list.add(i);
		}
	}
	
	static boolean isPrime(int num, int d)
	{
		if(num == 2 || num == 3)
		{
			return true;
		}
		if(num == 1)
		{
			return false;
		}
		if(num % 2 == 0 || num % d == 0)
		{
			return false;
		}
		if(d >= (int)Math.sqrt(num))
		{
			return true;
		}
		return isPrime(num, d + 2);
	}
	
	static boolean isSuperPrime(int num)
	{
		String num1 = "" + num;
		int check = num1.length();
		if(num == 1)
		{
			return false;
		}
		if(check == 1)
		{
			System.out.println("checked the last");
			return isPrime(num, 3);
		}

		num1 = num1.substring(0, check-1);
		int checkNext = Integer.parseInt(num1);
		
		if(isPrime(checkNext, 3))
		{
			return isSuperPrime(checkNext);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner k = new Scanner(System.in);
		
		System.out.print("How many digits? ");
		int digits = k.nextInt();
		
		initList(digits-1);
		
		boolean stop = false;
		int counter = 0;
		
		while(!stop)
		{
			if(!isPrime(list.get(counter), 3))
			{
				list.remove(counter);
				counter--;
			} else
			{
				if(!isSuperPrime(list.get(counter)))
				{
					list.remove(counter);
					counter--;
				}
			}
			counter++;
			if(counter >= list.size()-1)
			{
				stop = true;
			}
		}
		
		for(int i = 0; i < list.size()-1; i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println(starttime);
	}
}
