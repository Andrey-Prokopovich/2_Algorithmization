package by.javatraining.complex_array.task15;

import java.io.*;
import java.util.Random;

/*
 * Найти наибольший элемент матрицы и заменить на него все нечетные элементы.
 */

public class MatrixChange {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Найти наибольший элемент матрицы и заменить на него все нечетные элементы.");

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
		int iMaxElement = 0;

		System.out.println("Матрица: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				iMatrix[i][j] = rng.nextInt(81);
				
				if (iMaxElement < iMatrix[i][j]) {
					iMaxElement = iMatrix[i][j];
				}
				
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		System.out.println("Матрица с заменой: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				if (iMatrix[i][j] % 2 != 0) {
					iMatrix[i][j] = iMaxElement;
				}
				
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
