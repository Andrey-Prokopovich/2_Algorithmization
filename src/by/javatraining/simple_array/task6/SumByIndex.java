package by.javatraining.simple_array.task6;

import java.io.*;
import java.util.Random;

/*
 * Задана последовательность N вещественных чисел.
 * Вычислить сумму чисел, порядковые номера которых являются простыми числами.
 */

public class SumByIndex {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Вычислить сумму чисел последовательности, порядковые номера которых являются простыми числами.");

		int sequenceLength = 0;
		do {
			try {
				System.out.println("Введите длинну последовательности n:");
				System.out.print(">> ");

				sequenceLength = Integer.parseUnsignedInt(stdIn.readLine());

				if (sequenceLength == 0) {
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

		Random rng = new Random();
		double[] numArray = new double[sequenceLength];
		double dResult = 0;

		System.out.print("Последовательность: ");
		for (int i = 0; i < sequenceLength; i++) {
			numArray[i] = rng.nextDouble() * Math.pow(10, rng.nextInt(5));
			if (i > 1) {
				boolean isSimple = true;
				
				for (int j = 2; j <= i / 2; j++) {
					if ((i % j) == 0) {
						isSimple = false;
						break;
					}
				}
				
				if (isSimple)
					dResult = dResult + numArray[i];
			}
			System.out.print((i > 0 ? ", " : "") + numArray[i]);
		}
		System.out.println();
		System.out.println("Сумма: " + dResult);
	}
}
