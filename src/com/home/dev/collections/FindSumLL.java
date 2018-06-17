package com.home.dev.collections;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find the sum of two numbers represented by linked list
 * 1->2->3 and 4->5->6 = 579
 * 
 * @author tj_12
 *
 */
public class FindSumLL
{
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		// input from command line =  1 2 3 | 4 5 6
		// find the delimiter and construct the two number arrays
		int position = findIndexOfDelimiter(Arrays.asList(args).toString());
		
		String[] num1 = Arrays.copyOfRange(args, 0, position);
		String[] num2 = Arrays.copyOfRange(args, position+1, args.length);
		
		// construct linked list to represent the two numbers
		LinkedList numList1 = createLinkedList(num1);
		LinkedList numList2 = createLinkedList(num2);
		
		findSum(numList1, numList2);
		long endTime = System.nanoTime();
		
		System.out.println("\ntime taken = " + (endTime-startTime) + " ns");
	}
	
	/**
	 * replace [ ] , and space with empty string and get the position of the | delimiter
	 * 
	 * @param input
	 * @return int
	 */
	private static int findIndexOfDelimiter(String input)
	{
		int index = 0;
		Pattern p = Pattern.compile("[\\[\\], ]+");
		String numList = p.matcher(input).replaceAll("");
		p = Pattern.compile("\\|");
		
		Matcher m = p.matcher(numList);
		
		if (m.find())
		{
			index = m.start();
		}
		
		return index;
	}

	/**
	 * construct a linked list representing the number in input array
	 * ['1', '2', '3'] to 1->2->3
	 * 
	 * @param stringArray
	 * @return linkedlist
	 */
	private static LinkedList createLinkedList(String[] stringArray)
	{
		Node newNode = new Node(Integer.parseInt(stringArray[0]));
		
		// create the linked list with first digit
		LinkedList intList = new LinkedList(newNode);
		
		// iterate through the remaining digits and add to the linked list
		for (int i=1; i<stringArray.length; i++)
		{
			intList.addToTail(new Node(Integer.parseInt(stringArray[i])));
		}
		
		return intList;
	}
	
	/**
	 * get each digit from the linked list and calculate sum
	 * 
	 * @param list1
	 * @param list2
	 */
	private static void findSum(LinkedList list1, LinkedList list2)
	{
		// identify which number has more digits
		int difference = list1.size() - list2.size();
		
		// set total number of digits to second number assuming it is has more digits
		int totalDigits = list2.size();
		boolean isList1Larger = false;
		boolean isList2Larger = true;
		
		// if difference is greater than 0 then set total number of digits to go through to first number
		if (difference > 0)
		{
			totalDigits = list1.size();
			isList1Larger = true;
			isList2Larger = false;
		}
		
		Stack<Integer> sumStack = new Stack<Integer>();
		int carryOver = 0;
		int index = totalDigits-1; // number of times to loop through starting at 0
		
		while (index >= 0)
		{
			// get the digit from the linked list for a particular index position, counting down
			// from the size of the number with more digits
			int num1 = getNumberFromList(list1, isList1Larger, index, difference);
			int num2 = getNumberFromList(list2, isList2Larger, index, difference);
			int sum = num1 + num2 + carryOver;
			
			// if sum is greater than 9 then we consider total-10 as the total and carry over 1
			// to be summed up with the addition of the next digit
			if (sum > 9)
			{
				sum = sum-10;
				carryOver = 1;
			}
			else
			{
				carryOver = 0;
			}
			
			sumStack.add(sum);
			
			index--;
		}
		
		// after summing up if there is a carry over, add it to the stack
		if (carryOver > 0)
		{
			sumStack.add(carryOver);
		}
		
		// iterate the stack and pop to print total
		int sumLenght = sumStack.size();
		for (int i=1; i<=sumLenght; i++)
		{
			System.out.print(sumStack.pop());
		}
		
	}
	
	/**
	 * get the number from the linked list at a particular position
	 * if digit is not there return zero
	 * 
	 * @param list - linked list representing number
	 * @param isListLarger - is this linked list has more digits than the other number
	 * @param index - position of the digit to get
	 * @param difference - difference of number of digits between the two numbers
	 * @return int
	 */
	private static int getNumberFromList(LinkedList list, boolean isListLarger, int index, int difference)
	{
		int num = 0;
		
		/* if this list is larger than the other, use the index to get the number
		 * else - this is the number with lesser number of digits
		 * 		check if position we are looking for does not exist, i.e
		 * 			if larger number1 is 5 digits and number2 is 3 digits we start at digits  5 and 3
		 * 			and after iteration 3 we do not have digits to get in number2 and hence return 0
		 * 
		 */
		if (isListLarger)
		{
			num = list.getNodeAtPosition(index).getNum();
		}
		else
		{
			if ((index-difference) >= 0)
			{
				num = list.getNodeAtPosition(index-difference).getNum();
			}
		}
		
		return num;
	}
}