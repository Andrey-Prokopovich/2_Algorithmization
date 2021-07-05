package by.javatraining.simple_array.task9;

import java.io.*;
import java.util.Random;

/*
 * В массиве целых чисел, с количеством элементов n, найти наиболее часто встречающаеся число.
 * Если таких несколько, то определить нименьшее из них.
 */

public class ArNumRepeats {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Найти наиболее часто встречающаеся число в последовательности.");

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
		int[] numArray = new int[sequenceLength];
		int[] repArray = new int[sequenceLength];
		int iRepeats = 0;
		int iResult = 0;

		System.out.print("Последовательность: ");
		for (int i = 0; i < sequenceLength; i++) {
			numArray[i] = rng.nextInt(21);
			System.out.print((i > 0 ? ", " : "") + numArray[i]);
		}
		System.out.println();

		for (int i = 0; i < sequenceLength; i++) {
			for (int j = i + 1; j < sequenceLength; j++) {
				if (numArray[j] == numArray[i]) {
					repArray[i]++;
				}
			}
		}

		for (int i = 0; i < sequenceLength; i++) {
			if (repArray[i] > 1) {
				if (iRepeats < repArray[i]) {
					iResult = numArray[i];
					iRepeats = repArray[i];
				}
			} else if ((iRepeats == repArray[i]) && (iResult != numArray[i])) {
				iResult = Math.min(iResult, numArray[i]);
			}
		}

		System.out.println("Результат: " + iResult);
	}
}
