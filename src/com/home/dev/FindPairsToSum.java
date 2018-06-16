package com.home.dev;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindPairsToSum
{
	public static void main(String[] args)
	{
		if (args != null && args.length > 0) 
		{
			String[] arrayToSearch = Arrays.copyOf(args, args.length-1);
			int num = Integer.parseInt(args[args.length-1]);
			
			Map<Integer, String> intMap = convertToMap(arrayToSearch);
			findSumNums(intMap, num);
		}
	}
	
	private static Map<Integer, String> convertToMap(String[]  numberArray)
	{
		Arrays.sort(numberArray);
		Map<Integer, String> intMap = new HashMap<Integer, String>();
		for (String i : numberArray)
		{
			intMap.put(Integer.parseInt(i), i);
		}
		
		return intMap;
	}
	
	private static void findSumNums(Map<Integer, String> intMap, int num)
	{
		for (Entry<Integer, String> entry : intMap.entrySet())
		{
			if (entry.getValue() != "")
			{
				int reminder = num - entry.getKey();
				
				if (intMap.get(reminder) != null)
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