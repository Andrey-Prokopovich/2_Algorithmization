package by.javatraining.array_sorting.task7;

import java.io.*;
import java.util.Random;

/*
 * Пусть даны две неубывающие последовательности действичетьных чисел a1 <= a2 <= ... <= an и
 * b1 <= b2 <= ... <= bm. Требуется указать те места, на которые нужно вставлять элементы 
 * последовательности b1 <= b2 <= ... <= bm в первую последовательность так, чтобы новая
 * последовательность оставалась возрастающей.
 */

public class FindInsertPoints {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Требуется указать те места последовательности a, на которые нужно вставлять элементы последовательности b так, "
						+ "чтобы последовательность оставалась возрастающей.");

		int iSize1 = 0;
		int iSize2 = 0;
		for (byte i = 0; i < 2; i++) {
			do {
				try {
					switch (i) {
					case 0:
						System.out.println("Введите количество элементов первой последовательности:");
						System.out.print(">> ");

						iSize1 = Integer.parseUnsignedInt(stdIn.readLine());

						if (iSize1 == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						break;
					case 1:
						System.out.println("Введите количество элементов второй последовательности:");
						System.out.print(">> ");

						iSize2 = Integer.parseUnsignedInt(stdIn.readLine());

						if (iSize2 == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						break;
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

		Random rng = new Random();
		double[] iArray1 = new double[iSize1];
		double[] iArray2 = new double[iSize2];

		System.out.print("Последоваельность 1: [");
		for (int i = 0; i < iSize1; i++) {
			double rngDouble = rng.nextDouble() * Math.pow(10, rng.nextInt(3));
			iArray1[i] = ((i == 0) ? rngDouble : iArray1[i - 1] + rngDouble);
			System.out.printf(((i > 0) ? " " : "") + "%3.3f", iArray1[i]);
		}
		System.out.println("]");
		
		System.out.print("Последоваельность 2: [");
		for (int i = 0; i < iSize2; i++) {
			double rngDouble = rng.nextDouble() * Math.pow(10, rng.nextInt(3));
			iArray2[i] = ((i == 0) ? rngDouble : iArray2[i - 1] + rngDouble);
			System.out.printf(((i > 0) ? " " : "") + "%3.3f", iArray2[i]);
		}
		System.out.println("]");

		int i2 = 0;
		System.out.print("Места вставки в первой последовательности: ");
		for (int i = 0; i < iSize1; i++) {
			for (; (i2 < iSize2) && (iArray1[i] > iArray2[i2]); i2++) {
				System.out.print(((i > 0) ? " " : "") + (i + 1));
			}
		}
		for (int i = i2; i < iSize2; i++) {
			System.out.print(((i > 0) ? " " : "") + (i + 1));
		}
		System.out.println();
	}
}
