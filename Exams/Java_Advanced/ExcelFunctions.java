package lineardatastructure.exam;

import javax.management.ObjectName;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size=Integer.parseInt(scanner.nextLine());
        String[][] table = new String[size][];
        for (int i = 0; i < size; i++) {
            table[i]=scanner.nextLine().split(", ");
        }
        String [] command=scanner.nextLine().split(" ");
        int indexHeader=0;
        for(int i=0;i<table[0].length;i++){
            if(table[0][i].equals(command[1])){
                indexHeader=i;
                break;
            }
        }
        switch (command[0]){
            case "sort":

                try{
                    for (int i = 1; i < table.length-1; i++) {
                        for (int j = i+1; j < table.length; j++) {
                            if(Double.compare(Double.parseDouble(table[i][indexHeader]),Double.parseDouble(table[j][indexHeader])) > 0){
                                for (int item = 0; item < table[i].length; item++) {
                                    String temp=table[i][item];
                                    table[i][item]=table[j][item];
                                    table[j][item]=temp;
                                }
                            }
                        }
                    }
                }catch (NumberFormatException e){
                    for (int i = 1; i < table.length-1; i++) {
                        for (int j = i+1; j < table.length; j++) {
                            if(table[i][indexHeader].compareTo(table[j][indexHeader]) > 0){
                                for (int item = 0; item < table[i].length; item++) {
                                    String temp=table[i][item];
                                    table[i][item]=table[j][item];
                                    table[j][item]=temp;
                                }
                            }
                        }
                    }
                }

                break;
            case "filter":
                for(int i=0;i<table.length;i++){
                    if(table[i][indexHeader].equals(command[2]) || i == 0){
                        System.out.println(String.join(" | ",table[i]));
                    }
                }
              return;
            case "hide":
                for (int i = 0; i < table.length; i++) {

                           table[i][indexHeader]="null";
                    System.out.println(String.join(" | ", Arrays.stream(table[i]).filter(x -> !x.equals("null")).collect(Collectors.toList())));




                }
               return;
        }
        for (int i = 0; i < table.length; i++) {
            System.out.println(String.join(" | ",table[i]));
        }
    }
}
