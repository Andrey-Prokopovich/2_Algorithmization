package by.javatraining.complex_array.task10;

import java.io.*;
import java.util.Random;

/*
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class FindDiagPlus {
	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Найти положительные элементы главной диагонали квадратной матрицы.");

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
		double[][] iMatrix = new double[iSquare][iSquare];

		System.out.println("Матрица: {");
		for (int j = 0; j < iSquare; j++) {
			for (int i = 0; i < iSquare; i++) {
				iMatrix[i][j] = rng.nextDouble() * Math.pow(10, rng.nextInt(4));
				
				switch (rng.nextInt(3)) {
				case 0:
					iMatrix[i][j] = iMatrix[i][j] * 0;
					break;
				case 2:
					iMatrix[i][j] = iMatrix[i][j] * (-1);
					break;
				default:
					break;
				}
				
				System.out.printf("%9.3f", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		System.out.print("Положительные элементы главной диагонали: ");
		for (int i = 0, j = 0; (i < iSquare) && (j < iSquare); i++, j++) {
			if (iMatrix[i][j] > 0) {
				System.out.printf("%9.3f", iMatrix[i][j]);
			}
		}
		System.out.println();
	}
}
