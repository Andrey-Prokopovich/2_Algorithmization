package by.javatraining.array_sorting.task2;

import java.io.*;
import java.util.Random;

/*
 * Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 * Примечание. Дополнительный массив не использоваеть.
 */

public class FormRising {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Образовать новую последовательность чисел так, чтобы она тоже была неубывающей.");

		int iSize1 = 0;
		int iSize2 = 0;
		for (byte i = 0; i < 2; i++) {
			do {
				try {
					switch (i) {
					case 0:
						System.out.println("Введите количество элементов первой последовательности:");
						System.out.print(">> ");

						iSize1 = Integer.parseUnsignedInt(stdIn.readLine());

						if (iSize1 == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						break;
					case 1:
						System.out.println("Введите количество элементов второй последовательности:");
						System.out.print(">> ");

						iSize2 = Integer.parseUnsignedInt(stdIn.readLine());

						if (iSize2 == 0) {
							System.out.println("Значение не может быть нулевым!");
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
		int[] iArray1 = new int[iSize1];
		int[] iArray2 = new int[iSize2];
		int[] iResultArray = new int[iSize1 + iSize2];

		System.out.print("Последоваельность 1: [");
		for (int i = 0; i < iSize1; i++) {
			iArray1[i] = ((i == 0) ? rng.nextInt(51) : iArray1[i - 1] + rng.nextInt(31));
			System.out.print(((i > 0) ? ", " : "") + iArray1[i]);
		}
		System.out.println("]");

		System.out.print("Последоваельность 2: [");
		for (int i = 0; i < iSize2; i++) {
			iArray2[i] = ((i == 0) ? rng.nextInt(51) : iArray2[i - 1] + rng.nextInt(31));
			System.out.print(((i > 0) ? ", " : "") + iArray2[i]);
		}
		System.out.println("]");

		int i1 = 0;
		int i2 = 0;
		System.out.print("Последоваельность итоговая: [");
		for (int i = 0; i < iSize1 + iSize2; i++) {
			if ((i1 < iSize1) && (i2 < iSize2)) {
				if (iArray1[i1] <= iArray2[i2]) {
					iResultArray[i] = iArray1[i1];
					i1++;
				} else {
					iResultArray[i] = iArray2[i2];
					i2++;
				}
			} else {
				if (i1 == iSize1) {
					iResultArray[i] = iArray2[i2];
					i2++;
				}

				if ((i2 == iSize2) && (i1 != iSize1)) {
					iResultArray[i] = iArray1[i1];
					i1++;
				}
			}

			System.out.print(((i > 0) ? ", " : "") + iResultArray[i]);
		}
		System.out.println("]");
	}
}
