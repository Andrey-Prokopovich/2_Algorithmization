package by.javatraining.decomposition.task10;

import java.io.*;

/*
 * Дано натуральное число N. Написать метод (методы) для формирования массива,
 * элементами которого являются цифры числа N.
 */

public class FormFromNumber {
	private BufferedReader stdIn;
	private long theNumber;
	private byte[] iNumberFB; // с начала в конец
	private byte[] iNumberBF; // с конца в начало

	FormFromNumber() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void userInput() {
		do {
			try {
				System.out.println("Введите число N:");
				System.out.print(">> ");

				theNumber = Long.parseUnsignedLong(stdIn.readLine());

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

	private int getCountOfDigits() {
		return (theNumber == 0 ? 1 : (int) Math.ceil(Math.log10(Math.abs(theNumber) + 0.5)));
	}

	public void formArray() {
		int numSize = getCountOfDigits();
		iNumberFB = new byte[numSize];
		iNumberBF = new byte[numSize];
		long tmpNum = theNumber;

		System.out.print("Масив прямой:   [");
		for (int i = 0; i < numSize; i++) {
			iNumberFB[i] = (byte) (tmpNum / Math.pow(10, numSize - i - 1));
			tmpNum = (long) (tmpNum - (iNumberFB[i] * Math.pow(10, numSize - i - 1)));
			System.out.print((i > 0 ? ", " : "") + iNumberFB[i]);
		}
		System.out.println("]");

		tmpNum = theNumber;
		System.out.print("Масив обратный: [");
		for (int i = 0; i < numSize; i++) {
			iNumberBF[i] = (byte) (tmpNum % 10);
			tmpNum = tmpNum / 10;
			System.out.print((i > 0 ? ", " : "") + iNumberBF[i]);
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		FormFromNumber cTask10 = new FormFromNumber();

		System.out.println("Сформировать массива, элементами которого являются цифры числа N.");

		cTask10.userInput();

		cTask10.formArray();
	}
}
