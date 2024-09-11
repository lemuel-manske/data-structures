package stack;

public class VectorStack<T> implements Stack<T> {

	private Object[] list;
	private int size;
	
	public VectorStack (int initialCapacity) {
		list  = new Object[initialCapacity];
		size = 0;
	}
	
	public int size() {
		return size;
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
		
		return (T) list[size-1];
	}
	
	public void push(T e) {
		if (size == list.length)
			throw new Stack.MaximumCapacity();
		
		list[size++] = e;
	}
	
	@Override
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < size; i++)
			sb.append(pop() + ", ");
		
		sb.append(pop());
		
		return sb.toString();
	}

	public void free() {
		if (isEmpty()) return;
		
		for (int i = 0; i <= size; i++) pop();
	}
}
