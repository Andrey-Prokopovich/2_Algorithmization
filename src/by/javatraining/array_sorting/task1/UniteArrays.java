package by.javatraining.array_sorting.task1;

import java.io.*;
import java.util.Random;

/*
 * Заданы два одномерных массива с различным количеством элементов и натруальное число k. объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не  используя
 * дополнительный массив.
 */

public class UniteArrays {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Объедитнить два массива, включив второй массив между k-м и (k+1) - м элементами первого.");

		int iSize1 = 0;
		int iSize2 = 0;
		int kElem = 0;
		for (byte i = 0; i < 3; i++) {
			do {
				try {
					switch (i) {
					case 0:
						System.out.println("Введите количество элементов первого массива:");
						System.out.print(">> ");

						iSize1 = Integer.parseUnsignedInt(stdIn.readLine());

						if (iSize1 == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						break;
					case 1:
						System.out.println("Введите количество элементов второго массива:");
						System.out.print(">> ");

						iSize2 = Integer.parseUnsignedInt(stdIn.readLine());

						if (iSize2 == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						break;
					case 2:
						System.out.println("Введите число K:");
						System.out.print(">> ");

						kElem = Integer.parseUnsignedInt(stdIn.readLine());

						if (kElem == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
						if (kElem > iSize1) {
							System.out.println("Значение K не может быть больше количества элементов первого массива!");
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

		System.out.print("Масив 1: [");
		for (int i = 0; i < iSize1; i++) {
			iArray1[i] = rng.nextInt(100);
			System.out.print((i > 0 ? ", " : "") + iArray1[i]);
		}
		System.out.println("]");

		System.out.print("Масив 2: [");
		for (int i = 0; i < iSize2; i++) {
			iArray2[i] = rng.nextInt(100);
			System.out.print((i > 0 ? ", " : "") + iArray2[i]);
		}
		System.out.println("]");

		System.out.print("Масив объединенный: [");
		for (int i = 0; i < iSize1 + iSize2; i++) {
			if (i < kElem) {
				iResultArray[i] = iArray1[i];
			} else if (i == kElem) {
				for (int ii = i, j = 0; j < iSize2; ii++, j++) {
					iResultArray[ii] = iArray2[j];
				}
			} else if (i >= kElem + iSize2) {
				iResultArray[i] = iArray1[i - iSize2];
			}
			System.out.print(((i > 0) ? ", " : "") + iResultArray[i]);
		}
		System.out.println("]");
	}
}
