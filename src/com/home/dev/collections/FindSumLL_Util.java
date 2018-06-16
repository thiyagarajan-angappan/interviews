package com.home.dev.collections;

import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Find the sum of 2 numbers represented by java linked list
 * [1,0,1] + [0,1,0,1] = 202
 * 
 * @author tj_12
 *
 */
public class FindSumLL_Util
{
	public static void main(String[] args)
	{
		LinkedList<Integer> intList1 = new LinkedList<Integer>();
		LinkedList<Integer> intList2 = new LinkedList<Integer>();
		
		intList1.add(1);
		intList1.add(0);
		intList1.add(1);
		
		intList2.add(1);
		intList2.add(0);
		intList2.add(1);
		
		try
		{
			System.out.println(convertToInt(intList1) + convertToInt(intList2));
		}
		catch(Exception e)
		{
			System.err.println("Error while finding sum : " + e.getMessage());
		}
	}
    
	/**
	 * a simple replace method call to convert the linked list number to int
	 * 
	 * @param intList
	 * @return int
	 */
	private static int convertToInt(LinkedList<Integer> intList) throws Exception
	{
		// pattern with regex for [ ] , and space
		// note : using replace all repeatedly will call pattern.compile and regex repeatedly
		Pattern p = Pattern.compile("[\\[\\], ]+");
		return Integer.parseInt(p.matcher(intList.toString()).replaceAll(""));
	}
}
