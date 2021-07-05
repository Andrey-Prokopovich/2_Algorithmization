package by.javatraining.complex_array.task6;

import java.io.*;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).
 *  1    1    1   ...   1    1    1
 *  0    1    1   ...   1    1    0
 *  0    0    1   ...   1    0    0
 * ...  ...  ...  ...  ...  ...  ...
 *  0    1    1   ...   1    1    0
 *  1    1    1   ...   1    1    1
 */

public class FormSquareMatrix {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Сформировать квадратную матрицу порядка n по заданному образцу (n - четное).");

		int iNth = 0;
		do {
			try {
				System.out.println("Введите порядок квадратной матрицы n (n - четное):");
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
				if ((j < iNth / 2) && (i < iNth - j) && (i >= j)) {
					iMatrix[i][j] = 1;
				} else if ((i > iNth - j - 2) && (i <= j)) {
					iMatrix[i][j] = 1;
				}
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
