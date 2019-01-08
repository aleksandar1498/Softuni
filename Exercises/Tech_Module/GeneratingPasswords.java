import java.util.Scanner;

public class GeneratingPasswords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int limit = Integer.parseInt(scanner.nextLine());

        int A = 35, B = 64;
        int generatedPasswords = 0;

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                System.out.printf("%c%c%d%d%c%c|", (char) A, (char) B, i, j, (char) B, (char) A);
                generatedPasswords++;
                if (generatedPasswords == limit) {
                    return;
                }
                A++;
                B++;
                if (A  > 55) {
                    A = 35;
                }
                if (B > 96) {
                    B = 64;
                }

            }

        }
    }
}
