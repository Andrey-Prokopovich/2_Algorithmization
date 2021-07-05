package by.javatraining.decomposition.task8;

import java.io.*;
import java.util.Random;

/*
 * Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5];
 * D[4] + D[5] + D[6]. Пояснение. Составить метод (методы) для вычисления суммы трех
 * последовательно расположенных элементов массива с номерами от r до m.
 */

public class SumThree {
	private BufferedReader stdIn;
	private Random rng;
	private int[] iParArray;
	private final String[] iName = { "количество элементов массива", "номер элемента r", "номер элемента m" };
	private int[] iNumArray;

	public SumThree() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		rng = new Random();
		iParArray = new int[3];
	}

	public void userInput() {
		for (byte i = 0; i < 3; i++) {
			do {
				try {
					System.out.println("Введите " + iName[i] + ":");
					System.out.print(">> ");

					iParArray[i] = Integer.parseUnsignedInt(stdIn.readLine());

					if (iParArray[i] == 0) {
						System.out.println("Значение не может быть нулевым!");
						continue;
					}
					if ((i == 1) && (iParArray[i] > iParArray[0] - 2)) {
						System.out.println("Значение не может быть равным номерам последних двух элементов массива!");
						continue;
					}
					if ((i == 2) && (iParArray[i] != iParArray[1] + 2)) {
						System.out.println("Значение должно быть равным номеру элемента r увеличенному на два!");
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
	}

	private int calcThreeSum(int iFrom, int iTo) {
		int iSum = 0;
		for (int i = iFrom; i <= iTo; i++) {
			iSum = iSum + iNumArray[i];
		}
		return iSum;
	}

	public void formAndCalcSum() {
		iNumArray = new int[iParArray[0]];

		System.out.print("Массив: [");
		for (int i = 0; i < iParArray[0]; i++) {
			iNumArray[i] = rng.nextInt(101);
			System.out.print((i > 0 ? ", " : "") + iNumArray[i]);
		}
		System.out.println("]");

		System.out.println("Сумма элементов от " + iParArray[1] + " до " + iParArray[2] + ": "
				+ calcThreeSum(iParArray[1] - 1, iParArray[2] - 1));
	}

	public static void main(String[] args) {
		SumThree cTask8 = new SumThree();

		System.out.println("Вычислить сумму трех последовательных элементов массива с номерами от r до m.");

		cTask8.userInput();

		cTask8.formAndCalcSum();
	}
}
