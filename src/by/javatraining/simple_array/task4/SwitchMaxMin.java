package by.javatraining.simple_array.task4;

import java.io.*;
import java.util.Random;

/*
 * Даны действительные числа a1,a2,...,an. Поменять местами наибольший и наименьший элементы.
 */

public class SwitchMaxMin {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Поменять местами наибольший и наименьший элементы последовательности.");

		int sequenceLength = 0;
		do {
			try {
				System.out.println("Введите длинну последовательности n:");
				System.out.print(">> ");

				sequenceLength = Integer.parseUnsignedInt(stdIn.readLine());

				if (sequenceLength == 0) {
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
		double[] numArray = new double[sequenceLength];
		double[] resArray = new double[sequenceLength];
		int minIndex = 0;
		int maxIndex = 0;

		System.out.print("Последовательность перед заменой: ");
		for (int i = 0; i < sequenceLength; i++) {
			resArray[i] = numArray[i] = rng.nextDouble() * Math.pow(10, rng.nextInt(5));

			if (i > 0) {
				if (numArray[i] < numArray[minIndex]) {
					minIndex = i;
				}

				if (numArray[i] > numArray[maxIndex]) {
					maxIndex = i;
				}
			}
			System.out.print((i > 0 ? ", " : "") + numArray[i]);
		}
		System.out.println();

		resArray[minIndex] = numArray[maxIndex];
		resArray[maxIndex] = numArray[minIndex];

		System.out.print("Последовательность после замены:  ");
		for (int i = 0; i < sequenceLength; i++) {
			System.out.print((i > 0 ? ", " : "") + resArray[i]);
		}
		System.out.println();
		System.out.println("" + (minIndex + 1) + "-й и " + (maxIndex + 1) + "-й элементы перемещены");
	}
}
