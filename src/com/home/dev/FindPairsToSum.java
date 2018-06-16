package com.home.dev;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a string array and a number k at the end of string array output all the
 * pairs that sum up to k
 * 
 * {"3","-2","6","9","0","-2","8","-1","5","1","6"} (0,6)(-2,8)(1,5)
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
			// consider last argument in input as the number to sum up to
			String[] arrayToSearch = Arrays.copyOf(args, args.length - 1);
			int sum = Integer.parseInt(args[args.length - 1]);

			// convert to map to remove duplicate numbers
			Map<Integer, String> intMap = convertToMap(arrayToSearch);

			// find pairs
			findSumNums(intMap, sum);
		}
	}

	/**
	 * Sort the array add elements to map eliminating duplicates
	 * 
	 * @param numberArray
	 * @return Map<Integer, String>
	 */
	private static Map<Integer, String> convertToMap(String[] numberArray)
	{
		Arrays.sort(numberArray);
		Map<Integer, String> intMap = new HashMap<Integer, String>();
		for (String i : numberArray)
		{
			intMap.put(Integer.parseInt(i), i);
		}

		return intMap;
	}

	/**
	 * iterate map and print out pairs
	 * 
	 * @param intMap
	 * @param num
	 */
	private static void findSumNums(Map<Integer, String> intMap, int num)
	{
		for (Entry<Integer, String> entry : intMap.entrySet())
		{
			// will be empty when the number has already been identified as pair
			if (entry.getValue() != "")
			{
				// calculate reminder that would add with the key to resulting in sum number
				int reminder = num - entry.getKey();

				// find the reminder in map excluding itself
				// print it out and set the value to empty
				if (intMap.get(reminder) != null && entry.getKey() != reminder)
				{
					System.out.print("(");
					System.out.print(entry.getKey());
					System.out.print(",");
					System.out.print(intMap.get(reminder));
					System.out.print(")");
					intMap.put(reminder, "");
				}
			}
		}
	}
}