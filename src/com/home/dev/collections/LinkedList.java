package com.home.dev.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * linked list from scratch
 * 
 * @author tj_12
 *
 */
public class LinkedList
{
	private Node head;
	private Node tail;
	private List<Node> list;
	
	public LinkedList(Node node)
	{
		this.list = new ArrayList<Node>(); 
		this.head = node;
		this.tail = node;
		list.add(node);
	}
	
	public Node getHead()
	{
		return this.head;
	}
	
	public Node getTail()
	{
		return this.tail;
	}
	
	/**
	 * check and return of list is empty
	 * @return
	 */
	public boolean isEmpty()
	{
		if(this.list == null || this.list.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	/**
	 * add the input node to the end of the list
	 * 
	 * @param node
	 */
	public void addToTail(Node node)
	{
		this.tail.setNext(node);
		this.tail = node;
		this.list.add(node);
		node.setNext(null);
	}
	
	/**
	 * add input node at the beginning of the list and make
	 * 
	 * this node as head
	 * @param node
	 */
	public void addBeforeAndMakeHead(Node node)
	{
		node.setNext(this.head);
		this.head = node;
	}
	
	/**
	 * add input node after the index position provided
	 * 
	 * @param node
	 * @param i
	 * @throws Exception
	 */
	public void addAfter(Node node, int i) throws Exception
	{
		if (this.list.size()-1 == i)
		{
			throw new Exception("trying to add as tail, use addToTail()");
		}
		node.setNext(this.list.get(i).getNext());
		this.list.get(i).setNext(node);
	}
	
	/**
	 * add input node before the index position provided
	 * 
	 * @param node
	 * @param i
	 * @throws Exception
	 */
	public void addBefore(Node node, int i) throws Exception
	{
		if(this.list.size() == 1)
		{
			throw new Exception("Linked list has one element as head. try addBeforeAndMakeHead()");
		}
		this.addBefore(node, i-1);
	}
	
	/**
	 * get the position of the input node in the linked list
	 * @param node
	 * @return
	 */
	public int getNodePosition(Node node)
	{
		int position = 0;
		
		for (Node nodeFromList : this.list)
		{
			if (node.getNum() == nodeFromList.getNum())
			{
				break;
			}
			else
			{
				position++;
			}
		}
		
		return position;
	}
	
	/**
	 * get the node at the input position
	 * 
	 * @param i
	 * @return
	 */
	public Node getNodeAtPosition(int i)
	{
		return this.list.get(i);
	}
	
	/**
	 * get the size of the linked list
	 * @return
	 */
	public int size()
	{
		return this.list.size();
	}
	
	/**
	 * used for printing the linked list
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for (Node node : this.list)
		{
			sb.append(node.toString());
		}
		return sb.toString();
	}
}
