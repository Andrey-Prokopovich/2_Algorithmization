package by.javatraining.complex_array.task16;

import java.io.*;
import java.util.Random;

/*
 * Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1,2,3...n
 * так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой.
 * Построить такой квадрат. Пример магического квадрата порядка 3:
 *  6  1  8
 *  7  5  3
 *  2  9  4
 */

public class MagicSquare {
	int col = 0;
	int row = 0;
	private int[][] magicSquare;
	private Random rng = new Random();

	public int obtainSquareElement(int Index1, int Index2) {
		return magicSquare[Index1][Index2];
	}

	private int checkOutofBounds(int Num, int mSize) {
		if (Num < 0)
			return checkOutofBounds(mSize + Num, mSize);
		else {
			if (Num >= mSize)
				return checkOutofBounds(0 + (Num - mSize), mSize);
			else
				return Num;
		}
	}

	private void changePosition(int newCol, int newRow, int rcMode, int newRC, int size, int[][] iMatrix) {
		newCol = checkOutofBounds(newCol, size);
		newRow = checkOutofBounds(newRow, size);

		if (iMatrix[newCol][newRow] != 0) {
			switch (rcMode) {
			case 0:
				row = checkOutofBounds(newRC, size);
				break;
			case 1:
				col = checkOutofBounds(newRC, size);
				break;
			default:
				break;
			}
		} else {
			col = newCol;
			row = newRow;
		}
	}

	private void methodDeLaLoubere(int orientationMode, int size, int[][] iMatrix) {
		switch (orientationMode) {
		case 1:
			col = size - 1;
			row = size / 2;
			break;
		case 2:
			col = size / 2;
			row = size - 1;
			break;
		case 3:
			col = 0;
			row = size / 2;
			break;
		default:
			col = size / 2;
			row = 0;
			break;
		}

		iMatrix[col][row] = 1;

		for (int number = 2; number <= size * size; number++) {
			switch (orientationMode) {
			case 1:
				changePosition(col + 1, row + 1, 1, col - 1, size, iMatrix);
				break;
			case 2:
				changePosition(col - 1, row + 1, 0, row - 1, size, iMatrix);
				break;
			case 3:
				changePosition(col - 1, row - 1, 1, col + 1, size, iMatrix);
				break;
			default:
				changePosition(col + 1, row - 1, 0, row + 1, size, iMatrix);
				break;
			}

			iMatrix[col][row] = number;
		}
	}

	private void methodMoscopull(int orientationMode, int size, int[][] iMatrix) {
		if (size % 3 == 0) {
			switch (orientationMode) {
			case 1:
				col = 0;
				row = size / 2;
				break;
			case 2:
				col = size / 2;
				row = 0;
				break;
			case 3:
				col = size - 1;
				row = size / 2;
				break;
			default:
				col = size / 2;
				row = size - 1;
				break;
			}
		} else {
			col = rng.nextInt(size);
			row = rng.nextInt(size);
		}

		iMatrix[col][row] = 1;

		for (int number = 2; number <= size * size; number++) {
			switch (orientationMode) {
			case 1:
				changePosition(col + 2, row + 1, 1, col + 4, size, iMatrix);
				break;
			case 2:
				changePosition(col - 1, row + 2, 0, row + 4, size, iMatrix);
				break;
			case 3:
				changePosition(col - 2, row - 1, 1, col - 4, size, iMatrix);
				break;
			default:
				changePosition(col + 1, row - 2, 0, row - 4, size, iMatrix);
				break;
			}

			iMatrix[col][row] = number;
		}
	}

	private void methodLatinSquares(int mode, int size, int[][] iMatrix) {
		int iShift = rng.nextInt(size);

		for (int iRow = 0; iRow < size; iRow++) {
			for (int iCol = 0; iCol < size; iCol++) {
				iMatrix[iCol][iRow] = checkOutofBounds(iCol + iRow + iShift, size);
			}
		}

		iShift = rng.nextInt(size);
		int[][] iSupport = new int[size][size];
		for (int iRow = 0; iRow < size; iRow++) {
			for (int iCol = size - 1; iCol >= 0; iCol--) {
				iSupport[iCol][iRow] = checkOutofBounds(iCol - iRow - iShift, size);
			}

		}

		for (int iRow = 0; iRow < size; iRow++) {
			for (int iCol = 0; iCol < size; iCol++) {
				if (mode == 0) {
					iMatrix[iCol][iRow] = size * iMatrix[iCol][iRow] + iSupport[iCol][iRow] + 1;
				} else {
					iMatrix[iCol][iRow] = size * iSupport[iCol][iRow] + iMatrix[iCol][iRow] + 1;
				}
			}
		}
	}

	private void exchangeValues(int[][] iMatrix, int col1, int row1, int col2, int row2) {
		int tmpInt = iMatrix[col1][row1];
		iMatrix[col1][row1] = iMatrix[col2][row2];
		iMatrix[col2][row2] = tmpInt;
	}

	private int obtainOrderNum(int[][] iMatrix, int iCol, int iRow) {
		if (iMatrix == null) {
			if ((iCol < 1) && (iRow < 1)) {
				return 1;
			} else if ((iCol >= 1) && (iRow >= 1)) {
				return 2;
			} else if (iCol >= 1) {
				return 3;
			} else {
				return 4;
			}
		} else {
			return iMatrix[iCol][iRow];
		}
	}

	private void methodComplexSquares(int size, int[][] iMatrix) {
		if ((size > 4) && (((size % 2 == 0) && (size % 4 != 0)) || ((size % 4 == 0) && ((size / 4) % 2 != 0)))) {
			int mSDivided = 0;
			int[][] iOrder = null;
			int[][] iSupport = null;

			if (size % 4 == 0) {
				mSDivided = 4;

				iSupport = new int[mSDivided][mSDivided];
				methodComplexSquares(mSDivided, iSupport);

				iOrder = new int[size / 4][size / 4];
				methodDeLaLoubere(0, size / 4, iOrder);
			} else {
				mSDivided = size / 2;

				iSupport = new int[mSDivided][mSDivided];
				methodDeLaLoubere(0, mSDivided, iSupport);
			}

			int uOrder = mSDivided;
			int mCells = (uOrder - 1) / 2;

			for (int iRow = 0; iRow < size; iRow++) {
				for (int iCol = 0; iCol < size; iCol++) {
					int supCol = (iCol < mSDivided ? iCol : iCol - mSDivided * (iCol / mSDivided));
					int supRow = (iRow < mSDivided ? iRow : iRow - mSDivided * (iRow / mSDivided));

					iMatrix[iCol][iRow] = iSupport[supCol][supRow] + (int) (Math.pow(uOrder, 2)
							* (obtainOrderNum(iOrder, iCol / mSDivided, iRow / mSDivided) - 1));
				}
			}

			if (mSDivided != 4) {
				for (int iRow = 0; iRow < size / 2; iRow++) {
					int startCol = 0;
					if (iRow == mSDivided / 2) {
						startCol = 1;
					}

					for (int iCol = startCol, mC = 1; (iCol < mSDivided) && (mC <= mCells); iCol++, mC++) {
						exchangeValues(iMatrix, iCol, iRow, iCol, iRow + mSDivided);
					}

					for (int iCol = size - 1, mC = 1; (iCol >= mSDivided) && (mC <= mCells - 1); iCol--, mC++) {
						exchangeValues(iMatrix, iCol, iRow, iCol, iRow + mSDivided);
					}
				}
			}
		} else {
			col = 0;
			row = 0;
			iMatrix[col][row] = 1;

			for (int Number = 2; Number <= size * size; Number++) {
				col = checkOutofBounds(col + 1, size);
				if (col == 0) {
					row = checkOutofBounds(row + 1, size);
				}

				iMatrix[col][row] = Number;
			}

			for (int iRow = 0; iRow < size; iRow++) {
				for (int iCol = 0; iCol < size; iCol++) {
					if ((iCol == iRow) && (iCol < size / 2)) {
						exchangeValues(iMatrix, iCol, iRow, size - 1 - iCol, size - 1 - iRow);
					}

					if ((iCol == size - 1 - iRow) && (iCol >= size / 2)) {
						exchangeValues(iMatrix, iCol, iRow, iRow, iCol);
					}

					if (size > 4) {
						if (iCol != iRow) {
							if ((iCol > iRow) && ((iCol - iRow) % 4 == 0)) {
								exchangeValues(iMatrix, iCol, iRow, size - 1 - iCol, size - 1 - iRow);
							}

							if ((iCol < size - 1 - iRow) && ((iCol + 1 + iRow) % 4 == 0)) {
								exchangeValues(iMatrix, iCol, iRow, size - 1 - iCol, size - 1 - iRow);
							}
						}
					}
				}
			}
		}
	}

	public void formMagicSquare(int size) {
		magicSquare = new int[size][size];

		if (size % 2 == 1) {
			switch (rng.nextInt(3)) {
			case 0:
				methodDeLaLoubere(rng.nextInt(4), size, magicSquare);
				break;
			case 1:
				methodMoscopull(rng.nextInt(4), size, magicSquare);
				break;
			case 2:
				methodLatinSquares(rng.nextInt(2), size, magicSquare);
				break;
			}
		} else {
			methodComplexSquares(size, magicSquare);
		}
	}

	public static void main(String[] args) {
		MagicSquare magicSquare = new MagicSquare();
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		int iSize = 3;

		System.out.println("Построить магический квадрат размера n.");

		do {
			try {
				System.out.println("Введите размер магического квадрата n (не более 30):");
				System.out.print(">> ");

				iSize = Integer.parseUnsignedInt(stdIn.readLine());

				if (iSize == 0) {
					System.out.println("Значение не может быть нулевым!");
					continue;
				}
				if (iSize < 3) {
					System.out.println("Значение не может быть меньше 3!");
					continue;
				}
				if (iSize > 30) {
					System.out.println("Значение не может быть больше 30!");
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

		magicSquare.formMagicSquare(iSize);

		System.out.println("Магический квадрат: {");
		for (int j = 0; j < iSize; j++) {
			for (int i = 0; i < iSize; i++) {
				if (iSize < 10) {
					System.out.printf(" %2d", magicSquare.obtainSquareElement(i, j));
				} else {
					System.out.printf(" %3d", magicSquare.obtainSquareElement(i, j));
				}
			}
			System.out.println();
		}
		System.out.println("}");
	}
}
