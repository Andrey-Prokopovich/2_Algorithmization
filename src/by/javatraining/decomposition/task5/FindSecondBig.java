package by.javatraining.decomposition.task5;

import java.io.*;
import java.util.Random;

/*
 * Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
 * которое меньше максимального элемента массива, но больше всех других элементов).
 */

public class FindSecondBig {
	private BufferedReader stdIn;
	private Random rng;
	private int iSize;
	private int[] iArray;

	public FindSecondBig() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		rng = new Random();
		iSize = 0;
	}

	public void userInput() {
		do {
			try {
				System.out.println("Введите размер массива:");
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
	}

	public void formAndFind() {
		iArray = new int[iSize];
		int iMax = 0;
		int iSecond = 0;

		System.out.print("Массив: [");
		for (int i = 0; i < iSize; i++) {
			iArray[i] = rng.nextInt(101);
			
			if (iMax < iArray[i]) {
				iMax = iArray[i];
			}
			
			if ((iMax > iArray[i]) && (iSecond < iArray[i])) {
				iSecond = iArray[i];
			}
			System.out.print((i > 0 ? ", " : "") + iArray[i]);
		}
		System.out.println("]");

		System.out.println("Второе по величине число: " + iSecond);
	}

	public static void main(String[] args) {
		FindSecondBig cTask5 = new FindSecondBig();

		System.out.println(
				"Вывести на печать число, которое меньше максимального элемента массива, но больше всех других элементов.");

		cTask5.userInput();

		cTask5.formAndFind();
	}
}
