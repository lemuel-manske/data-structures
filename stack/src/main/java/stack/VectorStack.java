package stack;

public class VectorStack<T> implements Stack<T> {

	private final Object[] innerList; // innerList.length is the limit
	private int size;
	
	public VectorStack (int initialCapacity) {
		innerList = new Object[initialCapacity];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public T pop() {
		T valueToPop = peek();
		
		size--;
		
		return valueToPop;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if (isEmpty()) 
			throw new Stack.Empty();
		
		return (T) innerList[size-1];
	}
	
	public void push(T e) {
		if (size == innerList.length)
			throw new Stack.MaximumCapacity();
		
		innerList[size++] = e;
	}

	public void free() {
		if (isEmpty()) return;
		
		for (int i = 0; i <= size; i++) pop();
	}

	@SuppressWarnings("unchecked")
	public void concat(VectorStack<T> stackToConcat) {
		if (size + stackToConcat.size > innerList.length)
			throw new Stack.MaximumCapacity();

		for (int i = 0; i < stackToConcat.size; i++)
			push((T) stackToConcat.innerList[i]);
	}

	@Override
	public String toString() {
		if (isEmpty()) return "";

		StringBuilder sb = new StringBuilder();

		for (int i = size - 1; i  > 0; i--)
			sb.append(innerList[i]).append(", ");

		sb.append(innerList[0]);

		return sb.toString();
	}
}
