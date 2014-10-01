///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  P2.java
// File:             NodeChain.java
// Semester:         CS367 Summer 2014
//
// Author:           Zak Scholl zscholl@wisc.ed
// CS Login:         scholl
// Lecturer's Name:  M. Hidayath Ansari
//
///////////////////////////////////////////////////////////////////////////////
package lists;

/**
 * This class is a list of nodes assembled into a NodeChain, implements the 
 * ListADT
 * @author zakscholl
 *
 * @param <E>
 */
public class NodeChain<E> implements ListADT<E> {
	
	private ListNode<E> head; //pointer to the head node
	private int numItems; //number of items in the list
	/**
	 * Constructor for a new nodechain, initializes head pointer to null and 
	 * numItems to zero
	 */
	public NodeChain(){
		head = null;
		numItems = 0;
	}
	/**
	 * Adds an item to the end of the list.
	 * @param E item, the item to be added onto the end of the list
	 */
	public void add(E item) {
		if (item == null) throw new IllegalArgumentException();
		//if adding to the beginning of the list
		if (numItems == 0){
			head = new ListNode<E>(item);
		}
		else {
			//normal case
		ListNode<E> tmp = traverseTo(numItems -1);
		tmp.setNext(new ListNode<E>(item));
		
		}
	
		numItems++;
	}

	/**
	 * Adds an item at the given position to the list
	 * @param int pos, the position where the item will be added
	 * @param E item, the item to be added to the list
	 * 
	 */
	public void add(int pos, E item) {
		if (pos < 0 || pos > numItems) throw new IndexOutOfBoundsException();
		//if adding to the head
		if (pos == 0){
			head = new ListNode<E>(item, head);
			numItems++;
			return;
		}
		//normal case
		ListNode<E> tmp = traverseTo(pos - 1);
		tmp.setNext(new ListNode<E>(item, tmp.getNext()));
		numItems++;
	}
	/**
	 * returns true if node chain contains the item, else returns false
	 * 
	 *	@param E item, item that is supposedly contained in the list
	 *	@return true if item is in list, otherwise false
	 */
	public boolean contains(E item) {
		if (numItems == 0) return false;
		if (item == null) throw new IllegalArgumentException();
		
		ListNode<E> tmp = head;
		for (int i = 0; i < numItems; i++){
			if (tmp.getData() == item){
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	/**
	 * returns the size of the list in number of items it contains
	 */
	public int size() {return numItems;	}
	/**
	 * returns a ListNode at the given position.
	 * @param pos, the position that is desired to be returned
	 * @return pointer to listnode at the given position
	 */
	public ListNode<E> traverseTo(int pos){
		
		if ( pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
		ListNode<E> tmp = head;
		
		for (int i = 0; i < pos; i++){
			tmp = tmp.getNext();
		}
		return tmp;
	}
	/**
	 * returns true if the list is empty, otherwise returns false.
	 */
	public boolean isEmpty() { return numItems == 0;}
	/**
	 * returns the item at the given position in the list.
	 * @param int pos, the position where the item can be found
	 * @return the item in the node at that position
	 */
	public E get(int pos) {	return traverseTo(pos).getData();}

	/**
	 * Removes the node in the list at the given position and returns its data
	 * @param int pos, the position that will be removed
	 * @return the item at that position
	 */
	public E remove(int pos) {
		
		if (pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
		//if at the first position
		if (pos == 0){
			ListNode<E> tmp = head;
			head = tmp.getNext();
			numItems--;
			return tmp.getData();
		}
	
		//normal case
		ListNode<E> tmp1 = traverseTo(pos - 1);
		E ret = tmp1.getNext().getData();
		tmp1.setNext(tmp1.getNext().getNext());
		numItems--;
		return ret;
		
	}
	
}
