package by.javatraining.simple_array.task3;

import java.io.*;
import java.util.Random;

/*
 * Дан массив действительных чисел, размерность которого N.
 * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
 */

public class ArrCountEl {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Подсчитать, сколько в массиве отрицательных, положительных и нулевых элементов.");

		int arraySize = 0;
		do {
			try {
				System.out.println("Введите рамер массива N:");
				System.out.print(">> ");

				arraySize = Integer.parseUnsignedInt(stdIn.readLine());

				if (arraySize == 0) {
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
		double[] numArray = new double[arraySize];
		int[] resArray = new int[3]; // 0 - нулевых, 1 - положительных, 2 - отрицательных

		System.out.print("Массив: [");
		for (int i = 0; i < arraySize; i++) {
			numArray[i] = rng.nextDouble() * Math.pow(10, rng.nextInt(5));

			switch (rng.nextInt(3)) {
			case 0:
				numArray[i] = numArray[i] * 0;
				break;
			case 2:
				numArray[i] = numArray[i] * (-1);
				break;
			default:
				break;
			}

			if (numArray[i] == 0) {
				resArray[0]++;
			} else if (numArray[i] > 0) {
				resArray[1]++;
			} else if (numArray[i] < 0) {
				resArray[2]++;
			}
			System.out.print(((i > 0) ? ", " : "") + numArray[i]);
		}
		System.out.println("]");

		System.out.println("Количество нулевых элементов: " + resArray[0]);
		System.out.println("Количество положительных элементов:  " + resArray[1]);
		System.out.println("Количество отрицательных элементов: " + resArray[2]);
	}
}
