package Lab_1;

import java.util.Arrays;

public class MyCeasar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCeasar(int shiftSteps) {
		this.n = shiftSteps;
	}

	/**
	 * Mã hóa một ký tự theo số bước dịch chuyển đã cho. Mã hóa: En(x) = (x + n) mod
	 * 26. x đại diện cho chỉ số của c trong mảng ALPHABET.
	 *
	 * @param c ký tự cần mã hóa
	 * @return ký tự đã mã hóa
	 */
	public char encryptChar(char c) {
		if (Arrays.binarySearch(ALPHABET, c) == -1) {
			return c;
		} else {
			// Tìm kiếm chỉ số của c trong mảng ALPHABET
			int x = Arrays.binarySearch(ALPHABET, c);
			// Mã hóa ký tự
			int newX = (x + n) % ALPHABET.length;
			return ALPHABET[newX];
		}
	}

	/**
	 * Mã hóa một văn bản sử dụng hàm mã hóa ký tự ở trên.
	 *
	 * @param input văn bản cần mã hóa
	 * @return văn bản đã mã hóa
	 */
	public String encrypt(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			sb.append(encryptChar(c));
		}

		return sb.toString();
	}

	/**
	 * Giải mã một ký tự theo số bước dịch chuyển đã cho. Giải mã: Dn(x) = (x – n)
	 * mod 26. x đại diện cho chỉ số của c trong mảng ALPHABET.
	 *
	 * @param c ký tự cần giải mã
	 * @return ký tự đã giải mã
	 */
	public char decryptChar(char c) {
		if (Arrays.binarySearch(ALPHABET, c) == -1) {
			return c;
		} else {
			// Tìm kiếm chỉ số của c trong mảng ALPHABET
			int x = Arrays.binarySearch(ALPHABET, c);

			// Giải mã ký tự
			int newX = (x - n) % ALPHABET.length;
			return ALPHABET[newX];
		}
	}

	/**
	 * Giải mã một văn bản mã hóa sử dụng hàm giải mã ký tự ở trên.
	 *
	 * @param input văn bản cần giải mã
	 * @return văn bản đã giải mã
	 */
	public String decrypt(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			sb.append(decryptChar(c));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		MyCeasar caesar = new MyCeasar(3); // Tạo một đối tượng MyCaesar với số bước dịch chuyển là 3
		
		// Mã hóa văn bản "HELLO WORLD!"
		String encryptedText = caesar.encrypt("HELLO WORLD!");

		// Giải mã văn bản đã mã hóa
		String decryptedText = caesar.decrypt(encryptedText);

		// In kết quả
		System.out.println(encryptedText);
		System.out.println(decryptedText);

	}
}
