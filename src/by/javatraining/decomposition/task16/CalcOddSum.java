package by.javatraining.decomposition.task16;

import java.io.*;

/*
 * Написать программу, определяющую сумму n-значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме.
 * Для решения задачи использовать декомпозицию.
 */

public class CalcOddSum {
	private BufferedReader stdIn;
	private int numberN;
	private long lSumma;

	public CalcOddSum() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void userInput() {
		do {
			try {
				System.out.println("Введите число n:");
				System.out.print(">> ");

				numberN = Integer.parseUnsignedInt(stdIn.readLine());

				if ((numberN < 1) || (numberN > 10)) {
					System.out.println("Число n может принимать значения от 1 до 10!");
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

	private void insideFor(int digNum, int iNumber, int entryNum) {
		for (int j = digNum; j < 10; j = j + 2) {
			int iCalc = iNumber + j;

			if (entryNum != numberN) {
				iCalc = iCalc * 10;
				insideFor(1, iCalc, entryNum + 1);
			} else {
				lSumma = lSumma + iCalc;
			}
		}
	}

	private int countDigits(long number) {
		return (number == 0 ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5)));
	}

	private int findEvenAmount(long lSumma) {
		int numSize = countDigits(lSumma);
		long tmpNum = lSumma;
		int EvenDigitsAmount = 0;

		for (int i = 1; i <= numSize; i++) {
			if ((tmpNum % 10) % 2 == 0) {
				EvenDigitsAmount++;
			}
			tmpNum = tmpNum / 10;
		}

		return EvenDigitsAmount;
	}

	public void findAndPrint() {
		lSumma = 0;

		insideFor(1, 0, 1);

		System.out.printf("Сумма: %,d\n", lSumma);
		System.out.println("Четных цифр: " + findEvenAmount(lSumma));
	}

	public static void main(String[] args) {
		CalcOddSum cTask16 = new CalcOddSum();

		System.out.println(
				"Рассчитать сумму n-значных чисел, содержащих только нечетные цифры. Определить сколько четных цифр в этой сумме.");

		cTask16.userInput();

		cTask16.findAndPrint();
	}
}
