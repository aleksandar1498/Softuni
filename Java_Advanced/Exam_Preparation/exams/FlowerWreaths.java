package exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class FlowerWreaths {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int wreaths = 0;
			int remainingFlowers = 0;

			Deque<Integer> lilies = FlowerWreaths.populate(scanner.nextLine(), (a, b) -> {
				a.push(b);
			});
			Deque<Integer> roses = FlowerWreaths.populate(scanner.nextLine(), (a, b) -> {
				a.offer(b);
			});
			while (!roses.isEmpty() && !lilies.isEmpty()) {
				int lilieValue = lilies.pop();
				int rosesValue = roses.poll();
				int sum = lilieValue + rosesValue;
				if (sum == 15) {
					wreaths++;
				} else if (sum > 15) {
					lilies.push(lilieValue - 2);
					roses.addFirst(rosesValue);
				} else {
					remainingFlowers += sum;
				}
			}
			wreaths += (int) (remainingFlowers / 15);
			if (wreaths >= 5) {
				System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
			} else {
				System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static Deque<Integer> populate(String input, BiConsumer<Deque<Integer>, Integer> cons) {
		Deque<Integer> flowers = new ArrayDeque<>();
		Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).forEach(l -> {
			cons.accept(flowers, l);
		});
		return flowers;
	}
}
