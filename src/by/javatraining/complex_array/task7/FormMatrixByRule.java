package by.javatraining.complex_array.task7;

import java.io.*;

/*
 * Сформировать квадратную матрицу порядка N по правилу: A[I,J]=sin(I^2 - J^2)/N
 * и подсчитать количество положительных элементов в ней.
 */

public class FormMatrixByRule {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Сформировать квадратную матрицу порядка N по правилу: A[I,J]=sin(I^2 - J^2)/N");
		System.out.println("и подсчитать количество положительных элементов в ней.");

		int iNth = 0;
		do {
			try {
				System.out.println("Введите порядок квадратной матрицы N:");
				System.out.print(">> ");

				iNth = Integer.parseUnsignedInt(stdIn.readLine());

				if (iNth == 0) {
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

		double[][] iMatrix = new double[iNth][iNth];
		int iPositive = 0;

		System.out.println("Матрица: {");
		for (int j = 0; j < iNth; j++) {
			for (int i = 0; i < iNth; i++) {
				iMatrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / iNth);
				
				if (iMatrix[i][j] > 0) {
					iPositive++;
				}
				System.out.printf("%7.3f", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
		
		System.out.println("Положитедьных элементов в матрице: " + iPositive);
	}
}
