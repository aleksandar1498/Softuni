package com.softuni;

import java.util.Scanner;

public class OldLibrary {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        int libraryCapacity=Integer.parseInt(scanner.nextLine());
        boolean found=false;
        int checkedBooks=0;
        while(found== false && checkedBooks < libraryCapacity){
            String title=scanner.nextLine();
            if(title.equals(name)){
                System.out.printf("You checked %d books and found it.",checkedBooks);
                found=true;
            }else{
                checkedBooks++;
            }
        }
        if(found == false){
            System.out.printf("The book you search is not here!\nYou checked %d books.",checkedBooks);
        }
    }
}
