package by.javatraining.decomposition.task9;

import java.io.*;

/*
 * Даны числа X, Y, Z, T - длины сторон четырехугольника. Написать метод (методы) вычисления его площади,
 * если угол между сторонами длинной X и Y - прямой.
 */

public class CalcArea {
	private BufferedReader stdIn;
	private int[] xyztValues;
	private final char[] iName = { 'X', 'Y', 'Z', 'T' };

	public CalcArea() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		xyztValues = new int[4];
	}

	public void userInput() {
		for (byte i = 0; i < 4; i++) {
			do {
				try {
					System.out.println("Введите длинну стороны " + iName[i] + ":");
					System.out.print(">> ");

					xyztValues[i] = Integer.parseUnsignedInt(stdIn.readLine());

					if (xyztValues[i] == 0) {
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
	}

	private double calcXYdiag() {
		double xyDiag = Math.pow(xyztValues[0], 2) + Math.pow(xyztValues[1], 2)
				- (2 * xyztValues[0] * xyztValues[1] * Math.cos(90.0));
		xyDiag = Math.sqrt(xyDiag);
		return xyDiag;
	}

	private double calcYXArea() {
		return 0.5 * xyztValues[0] * xyztValues[1] * Math.sin(90.0);
	}

	private double calcZTArea(double XYdiag) {
		double p = (xyztValues[2] + xyztValues[3] + XYdiag) / 2;
		return Math.sqrt(p * (p - xyztValues[2]) * (p - xyztValues[3]) * (p - XYdiag));
	}

	public void calcArea() {
		double dArea = calcYXArea() + calcZTArea(calcXYdiag());

		System.out.printf("Площадь четырехугольника: %5.3f", dArea);
	}

	public static void main(String[] args) {
		CalcArea cTask9 = new CalcArea();

		System.out.println("Вычислить площадь четырехугольника X, Y, Z, T, с прямым углом X, Y.");

		cTask9.userInput();

		cTask9.calcArea();
	}
}
