package staticlist;

public class StaticListImpl implements StaticList {

	private final int SIZE_TO_INCREASE = 10;
	private final int DEFAULT_LIST_SIZE = 10;
	
	private int[] list = new int[DEFAULT_LIST_SIZE];
	private int currentPosition = 0;

	public boolean isEmpty() {
		return size() == 0;
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
		if (currentPosition == list.length)
			resizeList();

		list[currentPosition++] = element;
	}

	private void resizeList() {
		int[] newList = new int[list.length + SIZE_TO_INCREASE];

		for (int i = 0; i < list.length; i++) // we could use System.arrayCopy as well
			newList[i] = list[i];

		list = newList;
	}

	public void free() {
		currentPosition = 0;
		list = new int[DEFAULT_LIST_SIZE];
	}

	public void remove(int element) {
		int index = find(element);

		if (index == -1) return;

		for (int i = index; i < size() - 1; i++)
			list[i] = list[i + 1];

		currentPosition--;
	}

	public void reverseOrder() {
		int midIndex = size() / 2 -1;

		for (int i = midIndex; i >= 0; i--) {
			int oppositeSideIndex = size() - i -1;
			int temp = list[oppositeSideIndex];
			list[oppositeSideIndex] = list[i];
			list[i] = temp;
		}
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
