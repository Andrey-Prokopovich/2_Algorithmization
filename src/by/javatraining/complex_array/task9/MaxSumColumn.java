package by.javatraining.complex_array.task9;

import java.io.*;
import java.util.Random;

/*
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце.
 * Определить, какой столбец содержит максимальную сумму.
 */

public class MaxSumColumn {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Определить, какой столбец содержит максимальную сумму его элементов.");

		int iCol = 0;
		int iRow = 0;
		for (byte i = 0; i < 2; i++) {
			do {
				try {
					switch (i) {
					case 0:
						System.out.println("Введите количество столбцов матрицы:");
						System.out.print(">> ");

						iCol = Integer.parseUnsignedInt(stdIn.readLine());

						if (iCol == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						break;
					case 1:
						System.out.println("Введите количество строк матрицы:");
						System.out.print(">> ");

						iRow = Integer.parseUnsignedInt(stdIn.readLine());

						if (iRow == 0) {
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
		int[][] iMatrix = new int[iCol][iRow];
		int[] iSums = new int[iCol];
		int maxSum = 0;
		int maxSumIndex = 0;

		System.out.println("Матрица: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				iMatrix[i][j] = rng.nextInt(51);
				iSums[i] = iSums[i] + iMatrix[i][j];
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		for (int i = 0; i < iCol; i++) {
			if (maxSum < iSums[i]) {
				maxSum = iSums[i];
				maxSumIndex = i;
			}
		}
		
		System.out.println("Наибольшая сумма элементов в столбце: " + maxSumIndex + 1);
	}
}
