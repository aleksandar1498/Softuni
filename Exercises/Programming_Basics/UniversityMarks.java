package com.softuni;

import java.util.Scanner;

public class UniversityMarks {
    enum marks {
        PERFECT(0), DISTINCT(0), GOOD(0), NOT_BAD(0), ENOUGH(0), NOT_ENOUGH(0);

        int m;

        private marks(int initialCount) {
            this.m = initialCount;
        }

        private void increaseMark() {
            this.m += 1;
        }

        public int getMark() {
            return m;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = 0;
        do {
            input = Integer.parseInt(scanner.nextLine());
            if (input > 0) {
                if (input <= 17) {
                    marks.NOT_ENOUGH.increaseMark();
                } else if (input <= 19) {
                    marks.ENOUGH.increaseMark();
                } else if (input <= 22) {
                    marks.NOT_BAD.increaseMark();
                } else if (input <= 25) {
                    marks.GOOD.increaseMark();
                } else if (input <= 28) {
                    marks.DISTINCT.increaseMark();
                } else {
                    marks.PERFECT.increaseMark();
                }
            }
        } while (input > 0);
        for (marks m : marks.values()) {
            System.out.println(m + " " + m.getMark());
        }
    }
}
