package com.dxc.internship;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

final class Squash {
	private Squash(){
		// Utility class 
	}
	
	public static void squash(InputStream in,PrintStream out) {
		Scanner scanner = new Scanner(in);
		String last = "";
		while (scanner.hasNext()) {
			String signature = scanner.next();
			String word = scanner.next();

			if (last.equals(signature)) {
				out.print(" ");
			} else {
				if (!last.isEmpty()) {
					out.print("\n");
				}
				last = signature;
			}

			out.print(word);

		}
	}
	public static void main(String[] args) {
		squash(System.in,System.out);
		//String last = "";
//
//		while (scanner.hasNext()) {
//			String[] pair = scanner.nextLine().split("\\s+");
//			if (previous == null) {
//				previous = pair[0];
//				System.out.print(pair[1]);
//				continue;
//			}
//			if (!previous.equals(pair[0])) {
//				previous = pair[0];
//				System.out.print("\n");
//				System.out.print(pair[1]);
//				continue;
//
//			}
//			System.out.print(" " + pair[1]);
//		}

//		while (scanner.hasNext()) {
//			String signature = scanner.next();
//			String word = scanner.next();
//
//			if (last.equals(signature)) {
//				System.out.print(" ");
//			} else {
//				if (!last.isEmpty()) {
//					System.out.println();
//				}
//				last = signature;
//			}
//
//			System.out.print(word);
//
//		}
	}
}
