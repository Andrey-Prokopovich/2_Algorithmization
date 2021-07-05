package by.javatraining.decomposition.task1;

import java.io.*;

/*
 * Написать метод (методы) для нахождения наибольшего общего делителя и наименьшего общего кратного
 * двух натуральных чисел:
 * НОК(A,B) = (A*B)/НОД(A,B)
 */

public class NokNNodx2 {
	private final String[] iName = {"первое", "второе"}; 

	public String obtainName(int index) {
		return iName[index];
	}
	
	public int calcNod(int a, int b) {
		do {
			if(a > b) a = a % b;
			else b = b % a;
		} while((a > 0) && (b > 0));

		return a + b;
	}
	public int calcNok(int a, int b) {
		return (a * b) / calcNod(a, b);
	}

	public static void main(String[] args) {
		NokNNodx2 cTask1 = new NokNNodx2();
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Найти общий делитель и наименьшее общее кратное двух натуральных чисел.");
		
		int[] iNum = new int[2];
		for(byte i = 0; i <= 1; i++) {
			do {
				try {
					System.out.println("Введите " + cTask1.obtainName(i) + " число:");
					System.out.print(">> ");
					
					iNum[i] = Integer.parseUnsignedInt(stdIn.readLine());
					
					if(iNum[i] == 0) {
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
		
		System.out.println("НОД: " + cTask1.calcNod(iNum[0], iNum[1]));
		System.out.println("НОК: " + cTask1.calcNok(iNum[0], iNum[1]));
	}
}
