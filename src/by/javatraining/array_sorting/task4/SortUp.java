package by.javatraining.array_sorting.task4;

import java.io.*;
import java.util.Random;

/*
 * Соритровка обменами. Дана последовательность чисел a1, a2, ..., an. Требуется переставить числа
 * в порядке возрастания. Для этого сравниваются два соседних числа a[i] и a[i+1]. Если a[i] > a[i+1],
 * то делается перестановка. Так продалжается до тех пор, пока все элементы не станут расположены в
 * порядке возрастания. Составить алгоритм сортировки, подсчитывая при этом количество перестановок.
 */

public class SortUp {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Соритровка обменами. Требуется переставить числа в порядке возрастания.");

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

		int switchCount = 0;
		System.out.print("Последоваельность возрастающая: ");
		for (int i = 0; i < iSize; i++) {
			for (int j = i + 1; j < iSize; j++) {
				if (iArray[i] > iArray[j]) {
					int tmpInt = iArray[i];
					iArray[i] = iArray[j];
					iArray[j] = tmpInt;
					switchCount++;
				}
			}
			System.out.print(((i > 0) ? ", " : "") + iArray[i]);
		}
		System.out.println();

		System.out.println("Количество перестановок: " + switchCount);
	}
}
