package by.javatraining.simple_array.task1;

import java.io.*;
import java.util.Random;

/*
 * В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному K.
 */

public class ArSumSq {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному K.");

		int iN = 0;
		int iK = 0;
		for (byte i = 0; i <= 1; i++) {
			do {
				try {
					if (i == 0) {
						System.out.println("Введите количество элементов массива N:");
						System.out.print(">> ");

						iN = Integer.parseUnsignedInt(stdIn.readLine());

						if (iN == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
					} else {
						System.out.println("Введите число K:");
						System.out.print(">> ");

						iK = Integer.parseUnsignedInt(stdIn.readLine());

						if (iK == 0) {
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
		int[][] numArray = new int[iN][2];
		int iResult = 0;
		for (int i = 0; i < iN; i++) {
			numArray[i][0] = rng.nextInt(1001);
			if ((numArray[i][0] % iK) == 0) {
				iResult = iResult + numArray[i][0];
				numArray[i][1] = 1;
			}
		}

		System.out.println("Масив A[N]: [");
		for (int i = 0; i < iN; i++) {
			System.out.print((i > 0 ? ", " : "") + numArray[i][0] + (numArray[i][1] > 0 ? "(V)" : "(X)"));
		}
		System.out.println("]");
		System.out.println("Сумма кратных элементов: " + iResult);
	}
}
