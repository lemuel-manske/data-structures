package staticlist;

public class StaticListImpl implements StaticList {

	private int DEFAULT_LIST_SIZE = 10;
	
	private int[] list = new int[DEFAULT_LIST_SIZE];
	private int currentPosition = 0;
	
	public boolean isEmpty() {
		return true;
	}
	
	public int size() {
		return currentPosition;
	}
	
	public int find(int element) {
		for (int i = 0; i < size(); i++)
			if (list[i] == element)
				return i;
		
		return -1;
	}
	
	public int get(int index) {
		if (size() == 0 || index > size())
			throw new IndexOutOfBoundsException();
		
		return list[index];
	}
	
	public void add(int element) {
		list[currentPosition++] = element;
	}
	
	public void free() {
		list = new int[DEFAULT_LIST_SIZE];
		currentPosition = 0;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < currentPosition; i++) {
			builder.append(list[i]);
			if (i < currentPosition - 1) builder.append(" ");
		}

		return builder.toString();
	}
}
