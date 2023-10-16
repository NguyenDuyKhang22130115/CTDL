package Lab3_Task1;

public class Task_1 {
	private int[] array;

	public Task_1(int[] array) {
		this.array = array;
	}
	// Task 1.1
	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelper(target, 0);
	}

	private int recursiveLinearSearchHelper(int target, int index) {
		if (index == array.length) {
			return -1;
		}

		if (array[index] == target) {
			return index;
		}

		return recursiveLinearSearchHelper(target, index + 1);
	}
	// Task 1.2
	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (target < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelper(target, 0, array.length - 1);
	}

	private int recursiveBinarySearchHelper(int target, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (array[mid] == target) {
			return mid;
		} else if (target < array[mid]) {
			return recursiveBinarySearchHelper(target, low, mid - 1);
		} else {
			return recursiveBinarySearchHelper(target, mid + 1, high);
		}
	}
}
