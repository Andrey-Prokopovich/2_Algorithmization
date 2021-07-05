package by.javatraining.array_sorting.task6;

import java.io.*;
import java.util.Random;

/*
 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента a[i] и a[i+1].
 * Если a[i] <= a[i+1], то продвигаются на один элемент вперед. Если a[i] > a[i+1], то производится
 * перестановка и сдвигаются на один элемент назад. Составить алгоритм этой сортировки.
 */

public class SortUp {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Сортировка Шелла. Упорядочить по возрастанию.");

		int iSize = 0;
		do {
			try {
				System.out.println("Введите количество элементов массива:");
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
		double[] iArrayTask = new double[iSize];
		double[] iArrayShell = new double[iSize];

		System.out.print("Массив: [");
		for (int i = 0; i < iSize; i++) {
			iArrayTask[i] = rng.nextDouble() * Math.pow(10, rng.nextInt(5));
			iArrayShell[i] = iArrayTask[i];
			System.out.printf(((i > 0) ? " " : "") + "%4.3f", iArrayTask[i]);
		}
		System.out.println("]");

		int index = 0;
		while (index < iSize - 1) {
			if (iArrayTask[index] <= iArrayTask[index + 1]) {
				index = index + 1;
			} else if (iArrayTask[index] > iArrayTask[index + 1]) {
				double doubleStore = iArrayTask[index];
				iArrayTask[index] = iArrayTask[index + 1];
				iArrayTask[index + 1] = doubleStore;

				if (index > 0)
					index = index - 1;
			}
		}

		System.out.print("Массив по условию:      [");
		for (int i = 0; i < iSize; i++) {
			System.out.printf(((i > 0) ? " " : "") + "%4.3f", iArrayTask[i]);
		}
		System.out.println("]");

		int gap = iSize / 2;
		while (gap >= 1) {
			for (int right = 0; right < iSize; right++) {
				for (int c = right - gap; c >= 0; c -= gap) {
					if (iArrayShell[c] > iArrayShell[c + gap]) {
						double doubleStore = iArrayShell[c];
						iArrayShell[c] = iArrayShell[c + gap];
						iArrayShell[c + gap] = doubleStore;
					}
				}
			}

			gap = gap / 2;
		}

		System.out.print("Массив по методу Шелла: [");
		for (int i = 0; i < iSize; i++) {
			System.out.printf(((i > 0) ? " " : "") + "%4.3f", iArrayShell[i]);
		}
		System.out.println("]");
	}
}
