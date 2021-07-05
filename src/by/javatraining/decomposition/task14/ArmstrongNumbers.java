package by.javatraining.decomposition.task14;

import java.io.*;

/*
 * Натуральное число в записи которого n цифр, называется числом Армстронгга, если сумма его цифр,
 * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k.
 * Для решения задачи использовать декомпозицию.
 */

public class ArmstrongNumbers {
	private BufferedReader stdIn;
	private long numberK;

	public ArmstrongNumbers() {
		stdIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void userInput() {
		do {
			try {
				System.out.println("Введите число k:");
				System.out.print(">> ");

				numberK = Long.parseUnsignedLong(stdIn.readLine());

				if (numberK == 0) {
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

	private int countDigits(long number) {
		return (number == 0 ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5)));
	}

	private boolean checkIfArmstrong(long number) {
		int numSize = countDigits(number);
		long tmpNum = number;
		long digitsSum = 0;

		for (int i = 1; i <= numSize; i++) {
			digitsSum = (long) (digitsSum + Math.pow((tmpNum % 10), numSize));
			tmpNum = tmpNum / 10;
		}

		return (number == digitsSum);
	}

	public void findAndPrint() {
		System.out.print("Числа Армстронга: ");
		for (long i = 1; i <= numberK; i++) {
			if (checkIfArmstrong(i)) {
				System.out.printf("[%,d]", i);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArmstrongNumbers cTask14 = new ArmstrongNumbers();

		System.out.println("Найти все числа Армстронга от 1 до k.");

		cTask14.userInput();

		cTask14.findAndPrint();
	}
}
