package by.javatraining.decomposition.task15;

import java.io.*;

/*
 * Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность
 * (например, 1234, 5789).
 * Для решения задачи использовать декомпозицию.
 */

public class FormNDigitsRise {
	private BufferedReader stdIn;
	private int numberN;

	public FormNDigitsRise() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void userInput() {
		do {
			try {
				System.out.println("Введите число n:");
				System.out.print(">> ");

				numberN = Integer.parseUnsignedInt(stdIn.readLine());

				if ((numberN < 1) || (numberN > 9)) {
					System.out.println("Число n может принимать значения от 1 до 9!");
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
		for (int j = digNum; j < 10 - numberN + entryNum; j++) {
			int iCalc = iNumber + j;

			if (entryNum != numberN) {
				iCalc = iCalc * 10;
				insideFor(j + 1, iCalc, entryNum + 1);
			} else {
				System.out.println(iCalc);
			}
		}
	}

	public void findAndPrint() {
		System.out.println("Числа возрастающие: ");
		insideFor(1, 0, 1);
	}

	public static void main(String[] args) {
		FormNDigitsRise cTask15 = new FormNDigitsRise();

		System.out.println(
				"Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность (например, 1234, 5789).");

		cTask15.userInput();

		cTask15.findAndPrint();
	}
}
