package stack;

public interface StackADT<E> {
	/**
	 * Adds an item to the top of the stack.
	 * @param item
	 */
	public void push(E item);
	/**
	 * Removes the top most item of the stack and removes it from the stack
	 * @return
	 */
	public E pop();
	/**
	 * Returns the status of the stacks emptiness
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * Returns the contents of the topmost item without modifying the stack.
	 * @return
	 */
	public E peek();
}
