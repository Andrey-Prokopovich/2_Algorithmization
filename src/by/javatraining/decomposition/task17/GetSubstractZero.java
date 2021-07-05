package by.javatraining.decomposition.task17;

import java.io.*;

/*
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
 * Сколько таких действий надо произвести, чтобы получился нуль?
 * Для решения задачи использовать декомпозицию.
 */

public class GetSubstractZero {
	private BufferedReader stdIn;
	private long lNumber;
	private int substractionCount;

	public GetSubstractZero() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void userInput() {
		do {
			try {
				System.out.println("Введите число:");
				System.out.print(">> ");

				lNumber = Long.parseUnsignedLong(stdIn.readLine());

				if (lNumber == 0) {
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

	private int countDigits(long number) {
		return (number == 0 ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5)));
	}

	private void substractDigitsSum(long lSumma) {
		int numSize = countDigits(lSumma);
		long tmpNum = lSumma;
		int iDigitsSum = 0;
		substractionCount++;

		for (int i = 1; i <= numSize; i++) {
			iDigitsSum = (int) (iDigitsSum + tmpNum % 10);
			tmpNum = tmpNum / 10;
		}

		if (lSumma - iDigitsSum != 0) {
			substractDigitsSum(lSumma - iDigitsSum);
		}
	}

	public void findAndPrint() {
		substractionCount = 0;

		substractDigitsSum(lNumber);

		System.out.printf("Количество итераций: %,d\n", substractionCount);
	}

	public static void main(String[] args) {
		GetSubstractZero cTask17 = new GetSubstractZero();

		System.out.println("Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.");
		System.out.println("Сколько таких действий надо произвести, чтобы получился нуль?");

		cTask17.userInput();

		cTask17.findAndPrint();
	}
}
