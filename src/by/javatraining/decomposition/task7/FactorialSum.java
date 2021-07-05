package by.javatraining.decomposition.task7;

/*
 * Написать метод (методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */

public class FactorialSum {
	public void calcFactorialSum() {
		int iFactorial = 1;
		int factorialSum = 1;
		System.out.printf("Факториал %d: %,d.\n", 1, factorialSum);

		for (int i = 3; i <= 9; i = i + 2) {
			iFactorial = iFactorial * (i - 1) * i;
			factorialSum = factorialSum + iFactorial;
			System.out.printf("Факториал %d: %,d.\n", i, factorialSum);
		}

		System.out.printf("Сумма факториалов: %,d.\n", factorialSum);
	}

	public static void main(String[] args) {
		FactorialSum cTask7 = new FactorialSum();

		System.out.println("Вычислить сумму факториалов всех нечетных чисел от 1 до 9.");

		cTask7.calcFactorialSum();
	}
}
