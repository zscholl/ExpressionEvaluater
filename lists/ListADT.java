package lists;

/**
 * A List is an ordered collection of items.
 */
public interface ListADT<E> {
	/**
	 * Add item to the end of the List.
	 *
	 * @param item the item to add
	 */
	void add(E item);

	/**
	 * Add item at position pos in the List, moving the items
	 * originally in positions pos through size()- 1 one place
	 * to the right to make room.
	 *
	 * @param pos the position at which to add the item
	 * @param item the item to add
	 * @throws IndexOutOfBoundsException if pos is less than 0
	 * or greater than size()
	 */
	void add(int pos, E item);
	
	/**
	 * Return true iff item is
	 * item x in the List such
	 *
	 * @param item the item to
	 * @return true if item is
	 */
	boolean contains(E item);
	
	/**
	 * Return the number of items in the List.
	 *
	 * @return the number of items in the List
	 */
	int size();
	
	/**
	 * Return true iff the List is empty.
	 *
	 * @return true if the List is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Return the item at position pos in the List.
	 *
	 * @param pos the position of the item to return
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException if pos is less than 0
	 * or greater than or equal to size()
	 */
	E get(int pos);

	/**
	 * Remove and return the item at position pos in the List,
	 * moving the items originally in positions pos+1 through
	 * size() one place to the left to fill in the gap.
	 *
	 * @param pos the position at which to remove the item
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException if pos is less than 0
	 * or greater than or equal to size()
	 */
	E remove(int pos);
}
