package by.javatraining.simple_array.task10;

import java.io.*;
import java.util.Random;

/*
 * Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание: дополнительный массив не использовать.
 */

public class ArRemove {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями).");

		int iN = 0;
		do {
			try {
				System.out.println("Введите размер массива n:");
				System.out.print(">> ");

				iN = Integer.parseUnsignedInt(stdIn.readLine());

				if (iN == 0) {
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
		int[] numArray = new int[iN];

		System.out.print("Массив:    [");
		for (int i = 0; i < iN; i++) {
			numArray[i] = rng.nextInt(21);
			System.out.print((i > 0 ? ", " : "") + numArray[i]);
		}
		System.out.println("]");

		System.out.print("Результат: [");
		for (int i = 0; i < iN; i++) {
			if (i < (iN / 2) + (iN % 2)) {
				numArray[i] = numArray[i * 2];
			} else {
				numArray[i] = 0;
			}
			System.out.print((i > 0 ? ", " : "") + numArray[i]);
		}
		System.out.println("]");
	}
}
