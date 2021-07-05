package by.javatraining.simple_array.task2;

import java.io.*;
import java.util.Random;

/*
 * Дана последоватьльность действительных чисел a1,a2,...,an.
 * Заменить все ее члены, большие данного Z, этим числом.
 * Подсчитать количество замен.
 */

public class ArrReplace {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Заменить члены последовательности, большие Z, на Z. Подсчитать количество замен.");

		int sequenceLength = 0;
		int numberZ = 0;
		for (byte i = 0; i <= 1; i++) {
			do {
				try {
					if (i == 0) {
						System.out.println("Введите длинну последовательности n:");
						System.out.print(">> ");

						sequenceLength = Integer.parseUnsignedInt(stdIn.readLine());

						if (sequenceLength == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
					} else {
						System.out.println("Введите число Z:");
						System.out.print(">> ");

						numberZ = Integer.parseUnsignedInt(stdIn.readLine());

						if (numberZ == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
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
		double[] numArray = new double[sequenceLength];
		double[] resArray = new double[sequenceLength];
		int iReplaceCount = 0;
		
		System.out.print("Последовательность перед заменой: ");
		for (int i = 0; i < sequenceLength; i++) {
			resArray[i] = numArray[i] = rng.nextDouble() * Math.pow(10, rng.nextInt(5));
			if (resArray[i] > numberZ) {
				resArray[i] = numberZ;
				iReplaceCount++;
			}
			System.out.print(((i > 0) ? ", " : "") + numArray[i]);
		}
		System.out.println();
		
		System.out.print("Последовательность после замены:  ");
		for (int i = 0; i < sequenceLength; i++) {
			System.out.print(((i > 0) ? ", " : "") + resArray[i]);
		}
		System.out.println();
		
		System.out.println("Количество замен: " + iReplaceCount);
	}
}
