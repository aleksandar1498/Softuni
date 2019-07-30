package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        List<String> products=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String product=scanner.nextLine();
            products.add(product);


        }
        for (int i = 0; i < products.size()-1 ; i++) {
            for (int j = i+1; j < products.size(); j++) {
                if(products.get(i).compareTo(products.get(j)) > 0){
                    String temp=products.get(i);
                    products.set(i,products.get(j));
                    products.set(j,temp);
                }
            }
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s\n",i+1,products.get(i));
        }
    }
}
