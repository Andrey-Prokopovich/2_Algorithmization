package by.javatraining.decomposition.task2;

import java.io.*;

/*
 * Написать метод (методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */

public class NokAndNodx4 {
	private final String[] iName = { "первое", "второе", "третье", " четвертое" };

	public String obtainName(int index) {
		return iName[index];
	}

	public int nod(int A, int B) {
		do {
			if (A > B) {
				A = A % B;
			} else {
				B = B % A;
			}
		} while ((A > 0) && (B > 0));

		return A + B;
	}

	public int nodAll(int[] numbers) {
		int result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			result = nod(result, numbers[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		NokAndNodx4 cTask2 = new NokAndNodx4();
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Найти общий делитель и наименьшее общее кратное двух натуральных чисел.");

		int[] iNum = new int[4];
		for (byte i = 0; i < 4; i++) {
			do {
				try {
					System.out.println("Введите " + cTask2.obtainName(i) + " число:");
					System.out.print(">> ");

					iNum[i] = Integer.parseUnsignedInt(stdIn.readLine());

					if (iNum[i] == 0) {
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

		System.out.println("НОД: " + cTask2.nodAll(iNum));
	}
}
