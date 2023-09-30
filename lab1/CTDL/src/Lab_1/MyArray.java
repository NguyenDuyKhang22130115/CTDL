package Lab_1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public static int[] mirror(int[] array) {
		int[] mirroredArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			mirroredArray[i] = array[i];
			mirroredArray[array.length + i] = array[array.length - 1 - i];
		}
		return mirroredArray;
	}

	public static int[] removeDuplicates(int[] array) {
		int[] uniqueArray = new int[array.length];

		int index = 0;

		for (int i = 0; i < array.length; i++) {

			boolean isDuplicate = false;
			for (int j = 0; j < index; j++) {
				if (array[i] == uniqueArray[j]) {
					isDuplicate = true;
					break;
				}
			}

			if (!isDuplicate) {
				uniqueArray[index] = array[i];
				index++;
			}
		}
		int x = uniqueArray.length;
		do {
			x--;

		} while (uniqueArray[x] == 0);

		int[] result = Arrays.copyOf(uniqueArray, x + 1);
		return result;

	}

	public static int[] getMissingValues(int[] array) {
		int x = array[array.length - 1] - array[0] - (array.length-1);
		int[] re = new int[x];
		int y = 0;
		for (int i = 0; i < array.length-1; i++) {
			if (array[i + 1] - array[i] != 1) {
				int temp = array[i + 1] - array[i];
				for (int j = 1; j < temp; j++) {
					re[y] = array[i] + j;
					y++;
				}
			}
		}
		return re;
	}

	public static int[] fillMissingValues(int[] arr, int k) {
		// Khởi tạo một mảng mới để lưu trữ kết quả
		int[] output = new int[arr.length];
		output[0]=arr[0];
		// Duyệt qua mảng
		for (int i = 1; i < arr.length; i++) {
			// Nếu phần tử hiện tại là phần tử bị sai
			if (arr[i] < arr[i - 1] && i == 1) {
				int sum = 0;
				for (int x = 2; x < k + 2; x++) {
					sum += arr[x];
				}
				output[i] = sum / k;
			} else if (arr[i] < arr[i - 1] && i == arr.length - 1) {
				int sum = 0;
				for (int x = arr.length - 1; x > arr.length - k - 1; x--) {
					sum += arr[x];
				}
				output[i] = sum / k;
			} else if (arr[i] < arr[i - 1]) {
				// Tìm trung bình cộng nhỏ nhất của k phần tử xung quanh phần tử bị sai
				int count = 0;
				int[] temp = new int[2*(k-1)];
				for (int j = i - (k-1); j <= i + (k-1); j++) {
					if ( j == i) {continue;}
					
					temp[count] = arr[j];
					count++;
					
							
				}
				Arrays.sort(temp);
				int[] sorted = Arrays.copyOfRange(temp, 0, k);
				int temp2 =0;
				for (int l = 0;l<sorted.length;l++) {
					temp2 += sorted[l];
					
				}
				int sum2 = temp2 / k;
				// Thay thế phần tử bị sai bằng trung bình cộng nhỏ nhất
				output[i] = sum2;
				arr[i] = sum2;
			} else {
				// Nếu phần tử hiện tại không phải là phần tử bị sai thì giữ nguyên giá trị
				output[i] = arr[i];
			}
		}

		// Trả về mảng kết quả
		return output;
	}

	public static void main(String[] args) {
		int[] array = { 10, 11, 12, 12, 13, 14, 16, 21, 21, 26};
		int[] array1 = { 10, 11, 12, 14, 17, 19, 25 };
		int[] array2 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		
		System.out.println(Arrays.toString(mirror(array)));
		
		System.out.println(Arrays.toString(removeDuplicates(array)));
		
		System.out.println(Arrays.toString(getMissingValues(array1)));
		
		System.out.println(Arrays.toString(fillMissingValues(array2, 3)));
		
		

	}
}
