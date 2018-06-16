package com.home.dev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given a string array and a number k at the end of string array output all the
 * pairs that sum up to k
 * 
 * {"3","-2","6","9","0","-2","8","-1","5","1","6"} 
 * (0,6)(-2,8)(1,5)
 * 
 * @author tj
 *
 */
public class FindPairsToSum
{
	public static void main(String[] args)
	{
		if (args != null && args.length > 0)
		{
			try
			{
				// consider last argument in input as the number to sum up to
				String[] arrayToSearch = Arrays.copyOf(args, args.length - 1);
				int sum = Integer.parseInt(args[args.length - 1]);
	
				findPairs(arrayToSearch, sum);
			}
			catch(Exception e)
			{
				System.err.println("unable to find sum\n" + e.getMessage());
			}
		}
	}

	/**
	 * iterate through the array for each number find the reminder that would give
	 * the sum if it is in the set , print the pairs and remove the item from the
	 * set
	 * 
	 * @param numberArray
	 * @param num
	 */
	private static void findPairs(String[] numberArray, int num) throws Exception
	{
		Arrays.sort(numberArray);
		Set<String> stringSet = new HashSet<String>(Arrays.asList(numberArray));

		Iterator<String> stringIter = stringSet.iterator();

		while (stringIter.hasNext())
		{
			int i = Integer.parseInt(stringIter.next());
			int reminder = num - i;

			if (stringSet.contains(Integer.toString(reminder)))
			{
				System.out.print("(" + i + "," + reminder + ")");
				stringIter.remove();
			}
		}
	}
}