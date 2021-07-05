package by.javatraining.complex_array.task13;

import java.io.*;
import java.util.Random;

/*
 * Отсортировать столбцы матрицы по возрастанию и убыванию значений  элементов.
 */

public class SortMatrixCol {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Отсортировать столбцы матрицы по возрастанию и убыванию значений  элементов.");

		int iSquare = 0;
		do {
			try {
				System.out.println("Введите размер квадратной матрицы:");
				System.out.print(">> ");

				iSquare = Integer.parseUnsignedInt(stdIn.readLine());

				if (iSquare == 0) {
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
		int[][] iMatrix = new int[iSquare][iSquare];

		System.out.println("Матрица: {");
		for (int j = 0; j < iSquare; j++) {
			for (int i = 0; i < iSquare; i++) {
				iMatrix[i][j] = rng.nextInt(51);
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		for (int i = 0; i < iSquare; i++) {
			for (int j = 0; j < iSquare; j++) {
				int minValue = iMatrix[i][j];
				int matrixIndex = j;
				
				for (int k = j + 1; k < iSquare; k++) {
					if (minValue > iMatrix[i][k]) {
						minValue = iMatrix[i][k];
						matrixIndex = k;
					}
				}
				
				if (matrixIndex != j) {
					iMatrix[i][matrixIndex] = iMatrix[i][j];
					iMatrix[i][j] = minValue;
				}
			}
		}

		System.out.println("Отсортированная по ворзрастанию: {");
		for (int j = 0; j < iSquare; j++) {
			for (int i = 0; i < iSquare; i++) {
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		for (int i = 0; i < iSquare; i++) {
			for (int j = 0; j < iSquare; j++) {
				int maxValue = iMatrix[i][j];
				int matrixIndex = j;
				
				for (int k = j + 1; k < iSquare; k++) {
					if (maxValue < iMatrix[i][k]) {
						maxValue = iMatrix[i][k];
						matrixIndex = k;
					}
				}
				
				if (matrixIndex != j) {
					iMatrix[i][matrixIndex] = iMatrix[i][j];
					iMatrix[i][j] = maxValue;
				}
			}
		}

		System.out.println("Отсортированная по убыванию: {");
		for (int j = 0; j < iSquare; j++) {
			for (int i = 0; i < iSquare; i++) {
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
