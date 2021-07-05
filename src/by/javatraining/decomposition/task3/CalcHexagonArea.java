package by.javatraining.decomposition.task3;

import java.io.*;

/*
 * Вычислить площадь правильного шестиугольникасо стороной a, используя метод вычисления площади треугольника.
 */

public class CalcHexagonArea {
	private double calcTriangle(double sideA) {
		return (Math.pow(sideA, 2) * Math.sqrt(3)) / 4;
	}

	private double calcHexagonArea(double sideA) {
		return calcTriangle(sideA) * 6;
	}

	public static void main(String[] args) {
		CalcHexagonArea cTask3 = new CalcHexagonArea();
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Вычислить площадь правильного шестиугольникасо, используя метод вычисления площади треугольника.");

		double dSideA = 0.0;
		do {
			try {
				System.out.println("Введите размер стороны шестиугольника:");
				System.out.print(">> ");

				dSideA = Double.parseDouble(stdIn.readLine());

				if (dSideA == 0) {
					System.out.println("Значение не может быть нулевым!");
					continue;
				}
				if (dSideA < 0) {
					System.out.println("Значение не может быть отрицательным!");
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

		System.out.print("Площадь шестиугольника: ");
		System.out.printf("%5.3f", cTask3.calcHexagonArea(dSideA));
		System.out.println();
	}
}
