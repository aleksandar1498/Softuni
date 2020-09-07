package exams;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bee {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int beeRow = -1;

			int beeCol = -1;

			int pollinatedFlowers = 0;

			int rows = Integer.parseInt(scanner.nextLine());

			String[][] field = new String[rows][];
			for (int i = 0; i < field.length; i++) {
				String currentRow = scanner.nextLine();
				if (currentRow.indexOf("B") != -1) {
					beeRow = i;
					beeCol = currentRow.indexOf("B");
				}
				field[i] = currentRow.split("");
			}

			String action = scanner.nextLine();
			loop: while (!action.equals("End")) {
				field[beeRow][beeCol] = ".";
				switch (action) {
				case "up":
					beeRow--;
					if (isInBound(beeRow, beeCol, field)) {
						if (field[beeRow][beeCol].equals("f")) {
							pollinatedFlowers++;
						} else if (field[beeRow][beeCol].equals("O")) {
							field[beeRow][beeCol] = ".";
							beeRow--;
							if (isInBound(beeRow, beeCol, field)) {
								if (field[beeRow][beeCol].equals("f")) {
									pollinatedFlowers++;
								}
							} else {
								System.out.println("The bee got lost!");
								break loop;
							}
						}
					} else {
						System.out.println("The bee got lost!");
						break loop;
					}
					break;
				case "right":
					beeCol++;
					if (isInBound(beeRow, beeCol, field)) {
						if (field[beeRow][beeCol].equals("f")) {
							pollinatedFlowers++;
						} else if (field[beeRow][beeCol].equals("O")) {
							field[beeRow][beeCol] = ".";
							beeCol++;
							if (isInBound(beeRow, beeCol, field)) {
								if (field[beeRow][beeCol].equals("f")) {
									pollinatedFlowers++;
								}
							} else {
								System.out.println("The bee got lost!");
								break loop;
							}
						}
					} else {
						System.out.println("The bee got lost!");
						break loop;
					}
					break;
				case "down":
					beeRow++;
					if (isInBound(beeRow, beeCol, field)) {
						if (field[beeRow][beeCol].equals("f")) {
							pollinatedFlowers++;
						} else if (field[beeRow][beeCol].equals("O")) {
							field[beeRow][beeCol] = ".";
							beeRow++;
							if (isInBound(beeRow, beeCol, field)) {
								if (field[beeRow][beeCol].equals("f")) {
									pollinatedFlowers++;
								}
							} else {
								System.out.println("The bee got lost!");
								break loop;
							}
						}
					} else {
						System.out.println("The bee got lost!");
						break loop;
					}
					break;
				case "left":
					beeCol--;
					if (isInBound(beeRow, beeCol, field)) {
						if (field[beeRow][beeCol].equals("f")) {
							pollinatedFlowers++;
						} else if (field[beeRow][beeCol].equals("O")) {
							field[beeRow][beeCol] = ".";
							beeCol--;
							if (isInBound(beeRow, beeCol, field)) {
								if (field[beeRow][beeCol].equals("f")) {
									pollinatedFlowers++;
								}
							} else {
								System.out.println("The bee got lost!");
								break loop;
							}
						}
					} else {
						System.out.println("The bee got lost!");
						break loop;
					}
				}

				field[beeRow][beeCol] = "B";

				action = scanner.nextLine();
			}
			if (pollinatedFlowers >= 5) {
				System.out.println(
						String.format("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers));
			} else {
				System.out.println(String.format("The bee couldn't pollinate the flowers, she needed %d flowers more",
						5 - pollinatedFlowers));
			}
			printField(field);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	private static boolean isInBound(int row, int col, String[][] field) {
		return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
	}

	private static void printField(String[][] field) {
		for (int i = 0; i < field.length; i++) {
			System.out.println(String.join("", field[i]));
		}
	}

}
