package by.javatraining.complex_array.task1;

import java.io.*;
import java.util.Random;

/*
 * Дана матрица. Вывести на экран все нечетные столбцы, 
 * у которых первый элемент больше последнего.
 */

public class MatrixPrint {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out
				.println("Вывести на экран все нечетные столбцы матрицы, у которых первый элемент больше последнего.");

		int iCol = 0;
		int iRow = 0;
		for (int i = 0; i <= 1; i++) {
			do {
				try {
					if (i == 0) {
						System.out.println("Введите количество столбцов матрицы:");
						System.out.print(">> ");

						iCol = Integer.parseUnsignedInt(stdIn.readLine());

						if (iCol == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
					} else {
						System.out.println("Введите количество строк матрицы:");
						System.out.print(">> ");

						iRow = Integer.parseUnsignedInt(stdIn.readLine());

						if (iRow == 0) {
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
		int[][] iMatrix = new int[iCol][iRow];

		// System.out.println("Матрица: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				iMatrix[i][j] = rng.nextInt(51);
				// System.out.printf("%3d", iMatrix[i][j]);
			}
			// System.out.println();
		}
		// System.out.println("}");

		System.out.println("Результат: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i = i + 2) {
				if (iMatrix[i][0] > iMatrix[i][iRow - 1]) {
					System.out.printf("%3d", iMatrix[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
