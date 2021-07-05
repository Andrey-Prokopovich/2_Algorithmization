package by.javatraining.decomposition.task6;

import java.io.*;

/*
 * Написать метод (методы), проверяющий, являются ли данные три числа взаимно простыми.
 */

public class CheckIfSimple {
	private BufferedReader stdIn;
	private int[] iArray;
	private final String[] iName = { "первое", "второе", "третье" };

	public CheckIfSimple() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		iArray = new int[3];
	}

	public void userInput() {
		for (byte i = 0; i < 3; i++) {
			do {
				try {
					System.out.println("Введите " + iName[i] + " число:");
					System.out.print(">> ");

					iArray[i] = Integer.parseUnsignedInt(stdIn.readLine());

					if (iArray[i] == 0) {
						System.out.println("Значение не может быть нулевым!");
						continue;
					}

					break;
				} catch (NumberFormatException e) {
					e.printStackTrace();
					continue;
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
			} while (true);
		}
	}

	private int nod(int a, int b) {
		do {
			if (a > b)
				a = a % b;
			else
				b = b % a;
		} while ((a > 0) && (b > 0));

		return a + b;
	}

	private int nodAll() {
		int result = iArray[0];

		for (int i = 1; i < iArray.length; i++) {
			result = nod(result, iArray[i]);
		}

		return result;
	}

	public void checkIfSimple() {
		boolean isSimple = nodAll() == 1;
		System.out.println("Ответ: данные три числа " + (isSimple ? "" : "не ") + "являются взаимно простыми");
	}

	public static void main(String[] args) {
		CheckIfSimple cTask6 = new CheckIfSimple();

		System.out.println("Проверить являются ли данные три числа взаимно простыми.");

		cTask6.userInput();

		cTask6.checkIfSimple();
	}
}
