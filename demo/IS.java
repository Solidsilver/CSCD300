public class IS {
	public static void main(String[] args) {
		String[] bary = {"6", "4", "7", "3", "1"};
		printArr(bary);
		insertionSort(bary);
		printArr(bary);
	}

	public static void insertionSort(Comparable[] array) {
		int lastSorted; int sortedWalker;
		for (lastSorted = 0; lastSorted < array.length-1; lastSorted ++) {
			Comparable firstUnsortedData = array[lastSorted + 1];
			for (sortedWalker = lastSorted; sortedWalker >= 0 && array[sortedWalker].compareTo(firstUnsortedData) > 0; sortedWalker--) {
				array[sortedWalker + 1] = array[sortedWalker];
			}
			array[sortedWalker + 1] = firstUnsortedData;
		}
	}

	public static void printArr(Comparable[] arr) {
		for (int ix = 0; ix < arr.length; ix++) {
			System.out.print(arr[ix] + ", ");
		}
		System.out.println();
	}
}

