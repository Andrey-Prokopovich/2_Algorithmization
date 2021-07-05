package by.javatraining.decomposition.task13;

import java.io.*;

/*
 * Два простых числа называются "близнецами", если они отличаются друг от друга на 2 (напримерБ 41 и 43).
 * Найти и напечатать все пары "близнецов" из отрезка [n, 2n], где n - заданное натуральное число больше 2.
 * Для решения задачи использовать декомпозицию.
 */

public class PrintSimpleTwins {
	private BufferedReader stdIn;
	private int numberN;

	public PrintSimpleTwins() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void userInput() {
		do {
			try {
				System.out.println("Введите число N:");
				System.out.print(">> ");

				numberN = Integer.parseUnsignedInt(stdIn.readLine());

				if (numberN < 3) {
					System.out.println("Значение должно быть больше 2!");
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

	private boolean isSimple(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public void findAndPrint() {
		System.out.print("\"Близнецы\": ");
		for (int i = numberN; i <= 2 * numberN; i++) {
			if (isSimple(i)) {
				if (isSimple(i + 2)) {
					System.out.print("[" + i + "," + (i + 2) + "]");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PrintSimpleTwins cTask13 = new PrintSimpleTwins();

		System.out.println(
				"Найти и напечатать все пары \"близнецов\" из отрезка [n, 2n], где n - заданное натуральное число больше 2.");

		cTask13.userInput();

		cTask13.findAndPrint();
	}
}
