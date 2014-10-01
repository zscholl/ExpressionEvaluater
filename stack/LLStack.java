///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  P2.java
// File:             LLStack.java
// Semester:         CS367 Summer 2014
//
// Author:           Zak Scholl zscholl@wisc.edu
// CS Login:         scholl
// Lecturer's Name:  M. Hidayath Ansari
//
////////////////////////////////////////////////////////////////////////////////
package stack;

import lists.*;
/**
 * This class is a generic stack implementation using the NodeChain class
 * @author zakscholl
 *
 * @param <E>
 */
public class LLStack<E> implements StackADT<E>{
	private NodeChain<E> stack; //the NodeChain that holds the stack
	private int numItems; //number of items in the stack (for accounting)
	/**
	 * Constructor for a new stack, initiates a node chain and numItems to zero
	 */
	public LLStack(){
		stack = new NodeChain<E>();
		numItems = 0;
	}
	/**
	 * Pushes the item onto the top of the stack
	 * 
	 * @param E item, the item to be pushed onto the stack
	 */
	public void push(E item) {
		stack.add(item);
		numItems++;
	}

	/**
	 * Pops the topmost item off of the stack and returns its value, this
	 * removes the item from the stack
	 * 
	 * <p> This returns a null object if the stack is empty
	 * 
	 * @return returns the topmost item in the stack
	 */
	public E pop() {
		if (numItems > 0){
		E item = stack.remove(numItems - 1);
		numItems--;
		return item;
		}
		return null; 
	}

	/**
	 * returns true if the stack is empty, otherwise returns false
	 */
	public boolean isEmpty() {
		return numItems == 0;
	}

	/**
	 * returns the topmost item of the stack without removing it.
	 */
	public E peek() {
		return stack.get(numItems -1);
	}
	
}
