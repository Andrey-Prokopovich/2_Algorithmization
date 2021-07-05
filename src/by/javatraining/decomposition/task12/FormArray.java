package by.javatraining.decomposition.task12;

import java.io.*;

/*
 * Даны натуральные числа K и N. Написать метод (методы) для формирования массива A, элементами которого
 * являются числа, сумма цифр которых равна K и которые не больше N.
 */

public class FormArray {
	private BufferedReader stdIn;
	private long[] lNumbers;
	private final char[] iName = { 'K', 'N' };

	FormArray() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		lNumbers = new long[2];
	}

	public void userInput() {
		for (byte i = 0; i < 2; i++) {
			do {
				try {
					System.out.println("Введите число " + iName[i] + ":");
					System.out.print(">> ");

					lNumbers[i] = Long.parseUnsignedLong(stdIn.readLine());

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

	private int getArrSize() {
		return (int) ((lNumbers[0] / lNumbers[1]) + ((lNumbers[0] % lNumbers[1] != 0) ? 1 : 0));
	}

	public void formArray() {
		int iSize = getArrSize();
		long[] iArrayA = new long[iSize];

		System.out.print("Масив A: [");
		for (int i = 0; i < iSize; i++) {
			if ((i != iSize - 1) || (lNumbers[0] % lNumbers[1] == 0))
				iArrayA[i] = lNumbers[1];
			else
				iArrayA[i] = lNumbers[0] % lNumbers[1];

			System.out.print(((i > 0) ? ", " : "") + iArrayA[i]);
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		FormArray cTask12 = new FormArray();

		System.out.println(
				"Сформировать массив, элементами которого являются числа, сумма цифр которых равна K и которые не больше N.");

		cTask12.userInput();

		cTask12.formArray();
	}
}
