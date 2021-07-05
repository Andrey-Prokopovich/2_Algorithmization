package by.javatraining.decomposition.task11;

import java.io.*;

/*
 * Написать метод (методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class CompareNumbersAmount {
	private BufferedReader stdIn;
	private long[] lNumbers;
	private final String[] iName = { "первое", "второе" };

	CompareNumbersAmount() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		lNumbers = new long[2];
	}

	public void userInput() {
		for (byte i = 0; i < 2; i++) {
			do {
				try {
					System.out.println("Введите " + iName[i] + " число:");
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

	private int getCountOfDigits(long number) {
		return (number == 0 ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5)));
	}

	public long compareDigitsAmount() {
		if (getCountOfDigits(lNumbers[0]) == getCountOfDigits(lNumbers[1]))
			return 0;
		else if (getCountOfDigits(lNumbers[0]) > getCountOfDigits(lNumbers[1]))
			return lNumbers[0];
		else
			return lNumbers[1];
	}

	public static void main(String[] args) {
		CompareNumbersAmount cTask11 = new CompareNumbersAmount();

		System.out.println("Определить в каком из двух чисел больше цифр.");

		cTask11.userInput();

		long lRes = cTask11.compareDigitsAmount();
		if (lRes == 0)
			System.out.println("Количество цифр в этих числах одинаково");
		else
			System.out.println("Больше цифр в числе: " + lRes);
	}
}
