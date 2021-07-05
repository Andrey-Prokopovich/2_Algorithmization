package by.javatraining.complex_array.task14;

import java.io.*;
import java.util.Random;

/*
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
 * причем в каждом столбце число единиц равно номеру столбца.
 */

public class FormMatrix {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Сформировать матрицу, состоящую из нулей и единиц, причем в каждом столбце число единиц равно номеру столбца.");

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
						if (iRow < iCol) {
							System.out.println(
									"При количестве строк меньшем чем количество столбцов, условие не выполнимо!");
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
		int[] iOneCount = new int[iCol];

		System.out.println("Матрица: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				if (iOneCount[i] < i + 1) {
					if ((iOneCount[i] != i + 1) && (j >= iRow - i - 1)) {
						iMatrix[i][j] = 1;
					} else {
						iMatrix[i][j] = rng.nextInt(2);
					}
					
					if (iMatrix[i][j] == 1) {
						iOneCount[i]++;
					}
				}
				System.out.printf("%2d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
