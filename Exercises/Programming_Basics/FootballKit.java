package com.softuni;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teamName = scanner.nextLine();
        String typeKit = scanner.nextLine();
        int numBoughtKits = Integer.parseInt(scanner.nextLine());
        double price=0.0;
        switch (teamName) {
            case "Argentina":
                switch (typeKit) {
                    case "flags":
                        price=3.25;
                        break;
                    case "caps":
                        price=7.20;
                        break;
                    case "posters":
                        price=5.10;
                        break;
                    case "stickers":
                        price=1.25;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        return;
                }
            break;
            case "Brazil":
                switch (typeKit) {
                    case "flags":
                        price=4.2;
                        break;
                    case "caps":
                        price=8.5;
                        break;
                    case "posters":
                        price=5.35;
                        break;
                    case "stickers":
                        price=1.2;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        return;
                }
                break;
            case "Croatia":
                switch (typeKit) {
                    case "flags":
                        price=2.75;
                        break;
                    case "caps":
                        price=6.9;
                        break;
                    case "posters":
                        price=4.95;
                        break;
                    case "stickers":
                        price=1.10;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        return;
                }
                break;
            case "Denmark":
                switch (typeKit) {
                    case "flags":
                        price=3.1;
                        break;
                    case "caps":
                        price=6.5;
                        break;
                    case "posters":
                        price=4.8;
                        break;
                    case "stickers":
                        price=.9;
                        break;
                        default:
                            System.out.println("Invalid stock!");
                            return;
                }
                break;
            default:
                System.out.println("Invalid country!");
                return;
        }
        price=price*numBoughtKits;
        System.out.printf("Pepi bought %d caps of %s for %.2f lv.",numBoughtKits,teamName,price);
    }
}
