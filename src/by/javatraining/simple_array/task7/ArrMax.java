package by.javatraining.simple_array.task7;

import java.io.*;
import java.util.Random;

/*
 * Даны действительные числа a1,a2,...,a2n.
 * Найти max{a[1] + a[2n],a[2] + a[2n-1],...,a[n] + a[n+1]}.
 */

public class ArrMax {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Даны действительные числа a1,a2,...,a2n. Найти max{a[1] + a[2n],a[2] + a[2n-1],...,a[n] + a[n+1]}.");

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

		int nX2 = 2 * sequenceLength;
		Random rng = new Random();
		double[] numArray = new double[nX2];
		double[] sumArray = new double[sequenceLength];
		double dResult = 0.0;

		System.out.print("Последовательность: ");
		for (int i = 0; i < nX2; i++) {
			numArray[i] = rng.nextDouble() * Math.pow(10, rng.nextInt(5));
			System.out.print(((i > 0) ? ", " : "") + numArray[i]);
		}
		System.out.println();

		System.out.print("Суммы: ");
		for (int i = 0; i < sequenceLength; i++) {
			sumArray[i] = numArray[i] + numArray[(sequenceLength - 1) - i];
			System.out.print(((i > 0) ? ", " : "") + sumArray[i]);
		}
		System.out.println();

		for (int i = 0; i < sequenceLength; i++) {
			dResult = Math.max(dResult, sumArray[i]);
		}

		System.out.println("Max: " + dResult);
	}
}
