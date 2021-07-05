package by.javatraining.complex_array.task12;

import java.io.*;
import java.util.Random;

/*
 * Отсортировать строки матрицы по возрастанию и убыванию значений  элементов.
 */

public class SortMatrixRow {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Отсортировать строки матрицы по возрастанию и убыванию значений  элементов.");

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

		System.out.println("Отсортированная по ворзрастанию: {");
		for (int j = 0; j < iSquare; j++) {
			for (int i = 0; i < iSquare; i++) {
				int minValue = iMatrix[i][j];
				int matrixIndex = i;
				
				for (int k = i + 1; k < iSquare; k++) {
					if (minValue > iMatrix[k][j]) {
						minValue = iMatrix[k][j];
						matrixIndex = k;
					}
				}
				
				if (matrixIndex != i) {
					iMatrix[matrixIndex][j] = iMatrix[i][j];
					iMatrix[i][j] = minValue;
				}
				
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		System.out.println("Отсортированная по убыванию: {");
		for (int j = 0; j < iSquare; j++) {
			for (int i = 0; i < iSquare; i++) {
				int maxValue = iMatrix[i][j];
				int matrixIndex = i;
				
				for (int k = i + 1; k < iSquare; k++) {
					if (maxValue < iMatrix[k][j]) {
						maxValue = iMatrix[k][j];
						matrixIndex = k;
					}
				}
				
				if (matrixIndex != i) {
					iMatrix[matrixIndex][j] = iMatrix[i][j];
					iMatrix[i][j] = maxValue;
				}
				
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
