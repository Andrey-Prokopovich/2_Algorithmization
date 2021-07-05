package by.javatraining.array_sorting.task5;

import java.io.*;
import java.util.Random;

/*
 * Сортировка вставками. Дана последовательность чисел a1, a2, ..., an. Требуется переставить числа в порядке
 * возрастания. Длеается это следующим образом. Пусть a1,a2,...,an - упорядоченная последовательность, т.е.
 * a1 <= a2 <= ... <= an. Берется следующее число a[i+1] и вставляется в последовательность так, чтобы новая
 * последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i+1 до n
 * не будут перебраны. Примечание. Места помещения очередного элемента в осортированную часть производить
 * с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */

public class SortUp {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Сортировка вставками. Требуется переставить числа в порядке возрастания.");

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

		for (int i = 0; i < iSize; i++) {
			int value = iArray[i];
			int low = 0;
			int high = i - 1;
			int valuePos = -1;

			while (low <= high) {
				int mid = (low + high) / 2;
				if (iArray[mid] < value) {
					low = mid + 1;
				} else if (iArray[mid] > value) {
					valuePos = mid;
					high = mid - 1;
				} else if (iArray[mid] == value) {
					valuePos = mid;
					break;
				}
			}

			if ((valuePos < 0) || (valuePos == i)) {
				continue;
			}

			int j = i;
			for (; j >= valuePos; j--) {
				if (j != valuePos) {
					iArray[j] = iArray[j - 1];
				} else {
					break;
				}
			}

			iArray[j] = value;
		}

		System.out.print("Последоваельность возрастающая: ");
		for (int i = 0; i < iSize; i++) {
			System.out.print(((i > 0) ? ", " : "") + iArray[i]);
		}
		System.out.println();
	}
}
