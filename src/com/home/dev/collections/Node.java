package com.home.dev.collections;

/**
 * Node for linked lists
 * 
 * @author tj_12
 *
 */
public class Node
{
	private int num;
	private Node next;

	public Node(int num)
	{
		this.num = num;
	}
	
	public Node getNext()
	{
		return next;
	}

	public int getNum()
	{
		return num;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public void setNum(int num)
	{
		this.num = num;
	}
	
	/**
	 * used to pring the node
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("[");
		sb.append(this.num);
		sb.append("|");
		sb.append(this.next);
		sb.append("]");
		
		return sb.toString();
	}
}