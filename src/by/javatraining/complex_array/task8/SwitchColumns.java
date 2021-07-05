package by.javatraining.complex_array.task8;

import java.io.*;
import java.util.Random;

/*
 * В числовой матрице поменять местами два любых столбца, т.е. все элементы одного столбца поставить
 * на соответствующие им позиции другого столбца, а элементы второго столбца переместить в первый.
 * Номера столбцов вводит пользователь с клавиатуры.
 */

public class SwitchColumns {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("В числовой матрице поменять местами два любых столбца.");

		int iCol = 0;
		int iRow = 0;
		int colSwitch1 = 0;
		int colSwitch2 = 0;
		for (byte i = 0; i < 4; i++) {
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
						System.out.println("Введите количество строк матрицы: ");
						System.out.print(">> ");

						iRow = Integer.parseUnsignedInt(stdIn.readLine());

						if (iRow == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						break;
					case 2:
						System.out.println("Введите номер первого столбца для замены: ");
						System.out.print(">> ");

						colSwitch1 = Integer.parseUnsignedInt(stdIn.readLine());

						if (colSwitch1 > iCol) {
							System.out.println("Значение не может быть большим чем количество столбцов!");
							continue;
						}
						break;
					case 3:
						System.out.println("Введите номер второго столбца для замены: ");
						System.out.print(">> ");

						colSwitch2 = Integer.parseUnsignedInt(stdIn.readLine());

						if (colSwitch2 > iCol) {
							System.out.println("Значение не может быть большим чем количество столбцов!");
							continue;
						}
						if (colSwitch1 == colSwitch2) {
							System.out.println("Значение не может совпадать с номером первого столбца для замены!");
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

		System.out.println("Результат: {");
		for (int j = 0; j < iRow; j++) {
			for (int i = 0; i < iCol; i++) {
				if (i == Math.min(colSwitch1, colSwitch2) - 1) {
					int storeInt = iMatrix[i][j];
					iMatrix[i][j] = iMatrix[Math.max(colSwitch1, colSwitch2) - 1][j];
					iMatrix[Math.max(colSwitch1, colSwitch2) - 1][j] = storeInt;
				}
				System.out.printf("%3d", iMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
