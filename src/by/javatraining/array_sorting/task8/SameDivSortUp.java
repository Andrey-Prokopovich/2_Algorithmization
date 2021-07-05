package by.javatraining.array_sorting.task8;

import java.io.*;
import java.util.Random;

/*
 * Даны дроби p1/q1, p2/q2, ..., pn/qn (p1, q1 - натуральные). Составить программу, которая приводит
 * эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 */

public class SameDivSortUp {

	public static void main(String[] args) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Привести дроби к общему знаменателю и упорядочить их в порядке возрастания.");

		int iSize = 0;
		do {
			try {
				System.out.println("Введите количество дробей:");
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
		int[] iArrayP = new int[iSize];
		int[] iArrayQ = new int[iSize];

		System.out.println("Дроби:");
		for (int i = 0; i < iSize; i++) {
			iArrayP[i] = rng.nextInt(9) + 1;
			System.out.printf(" %1d", iArrayP[i]);
		}
		System.out.println();
		
		for (int i = 0; i < iSize; i++) {
			iArrayQ[i] = rng.nextInt(9) + 1;
			System.out.printf(" %1d", iArrayQ[i]);
		}
		System.out.println();
		System.out.println();

		int commonDivider = iArrayQ[0];
		for (int i = 0; i < iSize; i++) {
			if (commonDivider % iArrayQ[i] != 0) {
				int nod = 0;
				int a = commonDivider;
				int b = iArrayQ[i];
				
				do {
					if (a > b) {
						a = a % b;
					} else {
						b = b % a;
					}
				} while ((a > 0) && (b > 0));

				nod = a + b;
				commonDivider = (commonDivider / nod) * iArrayQ[i];
				i = -1;
			}
		}
		// System.out.println(commonDivider);

		for (int i = 0; i < iSize; i++) {
			iArrayP[i] = (iArrayP[i] * (commonDivider / iArrayQ[i]));
		}

		System.out.println("Дроби итоговые: ");
		for (int i = 0; i < iSize; i++) {
			for (int j = i + 1; j < iSize; j++) {
				if (iArrayP[i] > iArrayP[j]) {
					int storeInt = iArrayP[i];
					iArrayP[i] = iArrayP[j];
					iArrayP[j] = storeInt;
				}
			}
			System.out.printf(" %4d", iArrayP[i]);
		}
		System.out.println();
		
		for (int i = 0; i < iSize; i++) {
			System.out.printf(" %4d", commonDivider);
		}
		System.out.println();
	}
}
