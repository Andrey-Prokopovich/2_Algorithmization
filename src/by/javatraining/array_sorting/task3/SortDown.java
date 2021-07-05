package by.javatraining.array_sorting.task3;

import java.io.*;
import java.util.Random;

/*
 * Сортировка выбором. Дана последовательность чисел a1, a2, ..., an. Требуется переставить элементы так,
 * чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
 * элемент и ставиться на первое место, а первый - на место наибольшего. Затем, начиная со второго,
 * эта процедура повторяется. Написать алгоритм сортировки ввыбором.
 */

public class SortDown {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Сортировка выбором. Требуется переставить элементы так, чтобы они были расположены по убыванию.");

		int iSize = 0;
		do {
			try {
				System.out.println("Введите количество элементов последовательности:");
				System.out.print(">> ");

				iSize = Integer.parseUnsignedInt(stdIn.readLine());

				if (iSize == 0) {
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
		int[] iArray = new int[iSize];

		System.out.print("Последоваельность: ");
		for (int i = 0; i < iSize; i++) {
			iArray[i] = rng.nextInt(51);
			System.out.print(((i > 0) ? ", " : "") + iArray[i]);
		}
		System.out.println();

		System.out.print("Последоваельность убывающая: ");
		for (int i = 0; i < iSize; i++) {
			int iMax = iArray[i];
			int indMax = i;

			for (int j = i + 1; j < iSize; j++) {
				if (iMax < iArray[j]) {
					iMax = iArray[j];
					indMax = j;
				}
			}

			iArray[indMax] = iArray[i];
			iArray[i] = iMax;

			System.out.print(((i > 0) ? ", " : "") + iArray[i]);
		}
		System.out.println();
	}
}
