package by.javatraining.complex_array.task5;

import java.io.*;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).
 *  1    1    1   ...   1    1    1
 *  2    2    2   ...   2    2    0
 *  3    3    3   ...   3    0    0
 * ...  ...  ...  ...  ...  ...  ...
 * n-1  n-1   0   ...   0    0    0
 *  n    0    0   ...   0    0    0
 */

public class FormSquareMatrix {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).");

		int iNth = 0;
		do {
			try {
				System.out.println("Введите порядок квадратной матрицы n (n - четное): ");
				System.out.print(">> ");

				iNth = Integer.parseUnsignedInt(stdIn.readLine());

				if (iNth == 0) {
					System.out.println("Значение не может быть нулевым!");
					continue;
				}
				if (iNth % 2 != 0) {
					System.out.println("Значение должно быть четным!");
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

		int[][] iMatrix = new int[iNth][iNth];

		System.out.println("Матрица: {");
		for (int j = 0; j < iNth; j++) {
			for (int i = 0; i < iNth; i++) {
				iMatrix[i][j] = (i >= iNth - j ? 0 : j + 1);
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
