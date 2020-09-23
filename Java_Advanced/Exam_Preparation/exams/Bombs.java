package exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bombs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer,Integer> bombs = new HashMap<Integer, Integer>(){{
			put(40, 0); // Datura
			put(60,0); // Cherry
			put(120,0); // Smoke
			
		}};
		ArrayDeque<Integer> bombEffects = new ArrayDeque<Integer>();
		Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bE -> {
			bombEffects.offer(bE);
		});
		ArrayDeque<Integer> bombCasings = new ArrayDeque<Integer>();
		Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bE -> {
			bombCasings.push(bE);
		});	
	

		while(!bombEffects.isEmpty() && !bombCasings.isEmpty() && !fullfilledQuest(bombs)) {
			int bombEffect = bombEffects.poll();
			int bombCasing = bombCasings.pop();
			int sum = bombEffect+bombCasing;
			if(bombs.containsKey(sum)) {
				bombs.put(sum, bombs.get(sum)+1);
			}else {
				bombCasings.addFirst(bombCasing-5);
				bombEffects.addFirst(bombEffect);
			}
		}
		
		if(fullfilledQuest(bombs)) {
			System.out.println("Bene! You have successfully filled the bomb pouch!");
		}else {
			System.out.println("You don't have enough materials to fill the bomb pouch.");
		}
		System.out.println("Bomb Effects: "+(bombEffects.isEmpty()?"empty":bombEffects.toString().replaceAll("[\\[\\]]", "")));
		System.out.println("Bomb Casings: "+(bombCasings.isEmpty()?"empty":bombCasings.toString().replaceAll("[\\[\\]]", "")));
		System.out.println("Cherry Bombs: "+bombs.get(60));
		System.out.println("Datura Bombs: "+bombs.get(40));
		System.out.println("Smoke Decoy Bombs: "+bombs.get(120));
	}
	
	private static boolean fullfilledQuest(Map<Integer,Integer> bombs) {
		return bombs.get(40) >= 3 && bombs.get(60) >= 3 && bombs.get(120) >= 3;
	}
	

}
