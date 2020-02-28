/***************************************************************************
 * FILE: SimpleList.java
 * AUTHOR: Alyssa Lim
 * CLASS ID: 446
 * ASSIGNMENT #: 2
 * DESCRIPTION: This file contains the class definition for SimpleList.
 ***************************************************************************/
package cse360assign2;

import java.util.Arrays;

/**
 * This is the simple list class. Creates an array that stores up 
 * integers. Keeps track of the number of elements.
 * Includes methods for element insertion, deletion, count, search.
 * @author Alyssa Lim
 * 
 */
public class SimpleList
{
	private int[] list;
	private int count;
	private int size;
	
	/**
	 * Creates an array to hold 10 integer elements. 
	 * Sets count to 0.
	 */
	public SimpleList()
	{
		this.size = 10;
		this.list = new int[this.size];
		this.count = 0;
	}
	
	/**
	 * Adds this parameter to the beginning of this list.
	 * The existing list shifts elements over one index. 
	 * Increases size by 50% if full.
	 * Increments count.
	 * 
	 * @param newNum		the integer to add to this list
	 */
	public void add(int newNum)
	{
		if(this.count == 0) // empty
		{
			this.list[0] = newNum;
			this.count++;
		}
		else if (this.count == this.size) // full
		{
			int halfSize = (int) Math.floor(this.size * 0.50);
			this.size += halfSize;
			int[] newArr = Arrays.copyOf(this.list, this.size);
			this.list = newArr;
			
			int index = this.count;
			
			while(index > 0) // shift elements
			{
				this.list[index] = this.list[index - 1];
				index--;
			}
				
			this.list[0] = newNum;
			this.count++;
		}
		else
		{
			int index = this.count;
			
			while(index > 0) // shift elements
			{
				this.list[index] = this.list[index - 1];
				index--;
			}
				
			this.list[0] = newNum;
			this.count++;
		}
	}
	
	/**
	 * If this parameter is in this list, 
	 * removes first instance of it.
	 * Moves elements after this parameter up one index. 
	 * Decrements count.
	 * Reduces size if more than 25% empty.
	 * 
	 * @param key			the integer to remove from this list
	 */
	public void remove(int key)
	{
		int indexOfKey = search(key);
		
		
		if(indexOfKey != -1) // if element exists
		{
			int index = indexOfKey;
				
			while(index < (this.count - 1)) // shift elements
			{
				this.list[index] = this.list[index + 1];
				index++;
			}
				
			this.count--;
		}	
		
		int numOfEmpty = this.size - this.count;
		int fourthSize = (int) Math.floor(this.size * 0.25);
		int newSize = this.size - fourthSize;
		
		if(numOfEmpty > fourthSize) // more than 25% empty
		{
			if (newSize > 0)
			{
				this.size = newSize; // decrease size by 25%
				int[] newArr = Arrays.copyOf(this.list, this.size);
				this.list = newArr;
			}
		}
	}
	
	/**
	 * Returns the number of elements stored in this list
	 * 
	 * @return count		the amount of list integers 
	 */
	public int count()
	{
		return this.count;
	}
	
	/**
	 * Converts list integers into string format. 
	 * Separates elements with spaces. 
	 * 
	 * @return result		the list as a string
	 */
	public String toString()
	{
		String result = "";
		int index = 0;
		
		while(index < this.count)
		{
			result += this.list[index];
			
			if(index != (this.count - 1))
			{
				result += " ";
			}
			
			index++;
		}
		
		return result;
	}
	
	/**
	 * Returns index of this parameter in the list
	 * 
	 * @param key			the integer being searched for
	 * @return indexOfKey	location of parameter. 
	 * 						If not found, its value is -1.
	 */
	public int search(int key)
	{
		int indexOfKey = -1;
		int index = 0;
		
		while(index < this.count)
		{
			if(this.list[index] == key)
			{
				indexOfKey = index;
			}
			
			index++;
		}
		
		return indexOfKey;	
	}

}
