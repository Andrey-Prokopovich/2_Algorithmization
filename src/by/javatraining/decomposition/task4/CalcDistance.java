package by.javatraining.decomposition.task4;

import java.io.*;
import java.util.Random;

/*
 * На плоскости заданы своими координатами n точек. Написать метод (методы), определяющие, между какими
 * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class CalcDistance {
	private double сalcDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public double[] findFarthest(int[][] iArr) {
		double[] indFarthest = { 0, 0, 0 }; // дистанция, координаты

		for (int i = 0; i < iArr.length - 1; i++) {
			for (int j = i + 1; j < iArr.length; j++) {
				double calcRes = сalcDistance(iArr[i][0], iArr[i][1], iArr[j][0], iArr[j][1]);

				if (indFarthest[0] < calcRes) {
					indFarthest[0] = calcRes;
					indFarthest[1] = i;
					indFarthest[2] = j;
				}
			}

		}

		return indFarthest;
	}

	public static void main(String[] args) {
		CalcDistance cTask4 = new CalcDistance();
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Определить пару точек наиболее удаленных друг от друга.");

		int iPointCount = 0;
		do {
			try {
				System.out.println("Введите количество точек:");
				System.out.print(">> ");

				iPointCount = Integer.parseUnsignedInt(stdIn.readLine());

				if (iPointCount == 0) {
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
		int[][] iPointArray = new int[iPointCount][2];

		System.out.println("Точки:");
		for (int i = 0; i < iPointCount; i++) {
			if ((i != 0) && (i % 15 == 0)) {
				System.out.println();
			}
			
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					System.out.print("(");
				}

				iPointArray[i][j] = (rng.nextInt(31) + rng.nextInt(iPointCount)) * (rng.nextBoolean() ? (-1) : 1);
				System.out.print(iPointArray[i][j]);

				if (j == 0) {
					System.out.print(",");
				}
				if (j != 0) {
					System.out.print(") ");
				}
			}
		}
		System.out.println();

		double[] farIndex = cTask4.findFarthest(iPointArray);
		System.out.print("Наиболее удаленные точки: ");
		System.out.print("(" + iPointArray[(int) farIndex[1]][0] + "," + iPointArray[(int) farIndex[1]][1] + ") и ");
		System.out.print("(" + iPointArray[(int) farIndex[2]][0] + "," + iPointArray[(int) farIndex[2]][1] + ")");
		System.out.println();
		System.out.println("Расстояние: " + farIndex[0]);
	}
}
