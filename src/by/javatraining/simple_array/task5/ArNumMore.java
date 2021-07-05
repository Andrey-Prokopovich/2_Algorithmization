package by.javatraining.simple_array.task5;

import java.io.*;
import java.util.Random;

/*
 * Даны целые числа a1,a2,...,an. Вывети на печать только те числа, для которых at > i.
 */

public class ArNumMore {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Вывети на печать числа последовательности большие i.");

		int sequenceLength = 0;
		int numberI = 0;
		for (byte i = 0; i <= 1; i++) {
			do {
				try {
					if (i == 0) {
						System.out.println("Введите длинну последовательности n:");
						System.out.print(">> ");

						sequenceLength = Integer.parseUnsignedInt(stdIn.readLine());

						if (sequenceLength == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
					} else {
						System.out.print("Введите число i: ");
						System.out.print(">> ");

						numberI = Integer.parseUnsignedInt(stdIn.readLine());

						if (numberI == 0) {
							System.out.println("Значение не может быть нулевым!");
							continue;
						}
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
		int[] numArray = new int[sequenceLength];
		int[] resArray = new int[sequenceLength];
		int resIndex = 0;
		
		for (int i = 0; i < sequenceLength; i++) {
			numArray[i] = rng.nextInt(501);
			if (numArray[i] > numberI) {
				resArray[resIndex] = numArray[i];
				resIndex++;
			}
		}

		System.out.print("Числа последовательности большие i: ");
		for (int i = 0; i < sequenceLength; i++) {
			if (resArray[i] == 0) {
				break;
			}
			System.out.print(((i > 0) ? ", " : "") + resArray[i]);
		}
		System.out.println();
	}
}
