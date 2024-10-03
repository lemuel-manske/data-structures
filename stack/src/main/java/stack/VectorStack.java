package stack;

public class VectorStack<T> implements Stack<T> {

	// the objects length is the stack limit (initial capacity)
	private final T[] objects;
	private int size;
	
	@SuppressWarnings("unchecked")
	public VectorStack (int initialCapacity) {
		objects = (T[]) new Object[initialCapacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T pop() {
		T valueToPop = peek();

		size--;

		return valueToPop;
	}

	public T peek() {
		if (isEmpty()) 
			throw new EmptyStack();
		
		return objects[size-1];
	}
	
	public void push(T e) {
		if (size == limit())
			throw new MaximumCapacity();

		objects[size++] = e;
	}

	public void free() {
		if (isEmpty()) return;

		for (int i = 0; i <= size; i++) pop();
	}

	public void concat(Stack<T> stackToConcat) {
		if (stackToConcat.isEmpty())
			return;

		T elementToPush = stackToConcat.pop();
		concat(stackToConcat);
		push(elementToPush);
	}

	@Override
	public String toString() {
		if (isEmpty()) return "";

		StringBuilder sb = new StringBuilder();

		for (int i = size - 1; i  > 0; i--)
			sb.append(objects[i]).append(", ");

		sb.append(objects[0]);

		return sb.toString();
	}

	private int limit() {
		return objects.length;
	}
}
