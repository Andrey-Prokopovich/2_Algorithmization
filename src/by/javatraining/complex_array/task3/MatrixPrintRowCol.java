package by.javatraining.complex_array.task3;

import java.io.*;
import java.util.Random;

/*
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class MatrixPrintRowCol {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Дана матрица. Вывести k-ю строку и p-й столбец матрицы.");

		int iCol = 0;
		int iRow = 0;
		int iPCol = 0;
		int iKRow = 0;
		for (int i = 0; i < 4; i++) {
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
					case 2:
						System.out.println("Введите столбец матрицы для вывода:");
						System.out.print(">> ");
						
						iPCol = Integer.parseUnsignedInt(stdIn.readLine());
						
						if (iPCol == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						if (iPCol > iCol) {
							System.out.println(
									"Нельзя задать значение большее чем количество столбцов!");
							continue;
						}
						break;
					case 3:
						System.out.println("Введите строку матрицы для вывода:");
						System.out.print(">> ");
						
						iKRow = Integer.parseUnsignedInt(stdIn.readLine());
						
						if (iKRow == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						if (iKRow > iRow) {
							System.out.println("Нельзя задать значение большее чем количество строк!");
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

		System.out.println("Матрица: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				iMatrix[i][j] = rng.nextInt(51);
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		System.out.print(iKRow + "-я строка: ");
		for (int i = 0; i < iCol; i++) {
			System.out.print((i > 0 ? ", " : "") + iMatrix[i][iKRow - 1]);
		}
		System.out.println();
		System.out.print(iPCol + "-й столбец: ");
		for (int i = 0; i < iRow; i++) {
			System.out.print((i > 0 ? ", " : "") + iMatrix[iPCol - 1][i]);
		}
		System.out.println();
	}
}
