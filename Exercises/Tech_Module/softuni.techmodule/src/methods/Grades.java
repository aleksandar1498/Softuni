package methods;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
double grade=Double.parseDouble(scanner.nextLine());
        System.out.println(convertGradeInWords(grade));
    }
    private static String convertGradeInWords(double grade) {
        String gradeInWords = "";
        if (grade < 3) {
            gradeInWords = "Fail";
        } else if (grade < 3.50) {
            gradeInWords = "Poor";

        } else if (grade < 4.50) {
            gradeInWords = "Good";

        } else if (grade < 5.50) {
            gradeInWords = "Very good";

        } else {
            gradeInWords = "Excellent";

        }
        return gradeInWords;
    }


}
