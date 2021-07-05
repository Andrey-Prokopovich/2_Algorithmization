package by.javatraining.simple_array.task8;

import java.io.*;
import java.util.Random;

/*
 * Дана последовательность целых чисел a1,a2,...,an.
 * Образовать новую последоваетельность, выбросив из исходной те члены, которые равны min(a1,a2,...an).
 */

public class FormNewAr {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out
				.println("Образовать новую последоваетельность, выбросив из исходной члены, равные min(a1,a2,...an).");

		int sequenceLegth = 0;
		do {
			try {
				System.out.println("Введите длинну последовательности n:");
				System.out.print(">> ");

				sequenceLegth = Integer.parseUnsignedInt(stdIn.readLine());

				if (sequenceLegth == 0) {
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
		double[] numArray = new double[sequenceLegth];
		double[] resArray = new double[sequenceLegth - 1];
		double minNum = Double.MAX_VALUE;

		System.out.print("Последовательность: ");
		for (int i = 0; i < sequenceLegth; i++) {
			numArray[i] = rng.nextDouble() * Math.pow(10, rng.nextInt(5));
			if (numArray[i] < minNum) {
				minNum = numArray[i];
			}
			System.out.print(((i > 0) ? ", " : "") + numArray[i]);
		}
		System.out.println();

		int iVar = 0;
		System.out.print("Новая последовательность: ");
		for (int i = 0; i < sequenceLegth; i++) {
			if ((i > 0) && (numArray[i] == minNum)) {
				iVar++;
				continue;
			}
			resArray[i - iVar] = numArray[i];
			System.out.print(((i > 0) ? ", " : "") + resArray[i - iVar]);
		}
		System.out.println();
	}
}
