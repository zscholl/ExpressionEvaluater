///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  P2.java
// File:             ListNode.java
// Semester:         CS367 Summer 2014
//
// Author:           Zak Scholl zscholl@wisc.edu
// CS Login:         scholl
// Lecturer's Name:  M. Hidayath Ansari
//
///////////////////////////////////////////////////////////////////////////////

package lists;
/**
 * This class represents a single list node and is used in the NodeChain class
 * @author zakscholl
 *
 * @param <E>
 */
public class ListNode<E>{
	
	private E data; //store the data in each node
	private ListNode<E> next; //stores the next node pointer
	/**
	 * Constructor for a new listnode containing the object and next node pointer
	 * @param obj
	 * @param nextNode
	 */
	public ListNode(E obj, ListNode<E> nextNode){
		data = obj;
		next = nextNode;
		
	}
	/**
	 * Constructor for a listnode with a null next pointer
	 * @param obj
	 */
	public ListNode(E obj){
		this(obj, null);
	}
	/**
	 * returns the data contained in this listnode
	 * @return item that is contained in the node
	 */
	public E getData() {
		return data;
	}

	/**
	 * sets the data in the node
	 * @param obj, item to be set in the node
	 */
	public void setData(E obj) {
		data = obj;
	}

	/**
	 * returns the next pointer contained in this node
	 * @return next pointer in the node
	 */
	public ListNode<E> getNext() {
		return next;
	}

	/**
	 * Sets the next pointer in this node
	 * @param nextNode, the next node pointer to be set.
	 */
	public void setNext(ListNode<E> nextNode) {
		this.next = nextNode;
	}

}
