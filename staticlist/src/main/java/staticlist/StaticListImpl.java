package staticlist;

public class StaticListImpl implements StaticList {

	private int DEFAULT_LIST_SIZE = 10;
	
	private int[] list = new int[DEFAULT_LIST_SIZE];
	private int current_position = 0;
	
	public boolean isEmpty() {
		return true;
	}
	
	public int size() {
		return 0;
	}
	
	public int find(int element) {
		for (int i = 0; i < list.length; i++)
			if (list[i] == element)
				return i;
		
		return -1;
	}
	
	public int get(int index) {
		if (index > list.length -1) 
			throw new IndexOutOfBoundsException();
		
		return list[index];
	}
	
	public void add(int element) {
		list[current_position++] = element;
	}
	
	public void free() {
		list = new int[DEFAULT_LIST_SIZE];
	}
}
