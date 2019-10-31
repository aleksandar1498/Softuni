package com.dxc.internship;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Squash {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		String previous = null;
		while(scanner.hasNext()) {
			String [] pair = scanner.nextLine().split("\\s+");
			if(previous == null) {
				previous = pair[0];
				System.out.print(pair[1]);
				continue;
			}
			if(!previous.equals(pair[0])) {
				previous = pair[0];
				System.out.print("\n");
				System.out.print(pair[1]);
				continue;
				
			}
			System.out.print(" "+pair[1]);
		}
		
		/*
		 String signature = input.next();
			String word = input.next();

			if (last.equals(signature)) {
				System.out.print(" ");
			} else {
				if (!last.isEmpty()) {
					System.out.println();
				}
				last = signature;
			}

			System.out.print(word);
		*/
		
	}
}
