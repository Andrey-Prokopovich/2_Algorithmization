package by.javatraining.complex_array.task11;

import java.util.Random;

/*
 * Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу
 * и номера строк, в которых число 5 встречается три и более раз.
 */

public class FindFive {

	public static void main(String[] args) {
		System.out.println(
				"Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.");

		Random rng = new Random();
		final int iCol = 10;
		final int iRow = 20;
		int[][] iMatrix = new int[iCol][iRow];
		int[] iFiveCount = new int[iRow];

		System.out.println("Матрица: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				iMatrix[i][j] = rng.nextInt(16);
				
				if (iMatrix[i][j] == 5) {
					iFiveCount[j]++;
				}
				
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");

		System.out.print("Строки, где число 5 встречается три и более раз: ");
		for (int j = 0; j < iRow; j++) {
			if (iFiveCount[j] >= 3) {
				System.out.print((j + 1) + " ");
			}
		}
		System.out.println();
	}
}
