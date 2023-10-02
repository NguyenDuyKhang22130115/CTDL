package Lab_2;

public class Task1_3 {
	public static void printPascalTriangle(int index) {

		for (int row = 0; row <= index; row++) {
			
				System.out.print("   ");
			for (int j = 0; j < (index - row) ; j++) {
//				if (row%2==1 || row ==1 ) System.out.print("\t");
				System.out.print("\t");
			}
			int[] pascalRow = getPascalTriangle(row);
			for (int i = 0; i < pascalRow.length; i++) {

				System.out.print(pascalRow[i] + "\t\t");

			}
			System.out.println("\n");
		}
	}

	public static int[] getPascalTriangle(int n) {
		if (n == 0) {
			return new int[] { 1 };
		} else if (n == 1) {
			return new int[] { 1, 1 };
		} else {
			int[] prevRow = getPascalTriangle(n - 1);
			int[] nextRow = new int[prevRow.length + 1];
			nextRow[0] = 1;
			nextRow[prevRow.length] = 1;
			for (int i = 1; i < prevRow.length; i++) {
				nextRow[i] = prevRow[i - 1] + prevRow[i];
			}
			return nextRow;
		}
	}

	public static void main(String[] args) {
		printPascalTriangle(5);
	}
}
