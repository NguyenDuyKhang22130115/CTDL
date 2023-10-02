package Lab_2;

public class Task1_4 {
	public static void main(String[] args) {
		int numberOfDisks = 2;
		hanoi(numberOfDisks, "A", "B", "C");
	}

	private static void hanoi(int n, String A, String B, String C) {
		if (n == 1) {
			System.out.println("Move disk 1 from " + A + " to " + C);
			return;
		}

		hanoi(n - 1, A, C, B);
		System.out.println("Move disk " + n + " from " + A + " to " + C);
		hanoi(n - 1, B, A, C);
	}
}
