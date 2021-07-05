package by.javatraining.complex_array.task2;

import java.io.*;
import java.util.Random;

/*
 * Дана квадратная матрица.
 * Вывести на экран элементы, стоящие на диагонали.
 */

public class MatrixPrintDiag {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.");

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

		// System.out.println("Матрица: {");
		for (int j = 0; j < iSquare; j++) {
			for (int i = 0; i < iSquare; i++) {
				iMatrix[i][j] = rng.nextInt(51);
				// System.out.printf("%3d", iMatrix[i][j]);
			}
			// System.out.println();
		}
		// System.out.println("}");

		System.out.print("Диагональ матрицы: ");
		for (int i = 0, j = 0; (i < iSquare) && (j < iSquare); i++, j++) {
			System.out.print((i > 0 ? ", " : "") + iMatrix[i][j]);
		}
		System.out.println();
	}
}
