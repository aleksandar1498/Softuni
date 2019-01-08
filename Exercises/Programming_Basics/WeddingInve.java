import java.util.Scanner;

public class WeddingInve {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String limit=scanner.nextLine();
        String typeD=scanner.nextLine();
        String addedSweet=scanner.nextLine();
        int numMonthsToPay=Integer.parseInt(scanner.nextLine());
        double pricePerMonth=0.0;
        switch (limit){
            case "one":
                switch (typeD){
                    case "Small":
                        pricePerMonth=9.98;
                        break;
                    case "Middle":
                        pricePerMonth=18.99;
                        break;
                    case "Large":
                        pricePerMonth=25.98;
                        break;
                    case "ExtraLarge":
                        pricePerMonth=35.99;
                        break;
                }
                break;
            case "two":
                switch (typeD){
                    case "Small":
                        pricePerMonth=8.58;
                        break;
                    case "Middle":
                        pricePerMonth=17.09;
                        break;
                    case "Large":
                        pricePerMonth=23.59;
                        break;
                    case "ExtraLarge":
                        pricePerMonth=31.79;
                        break;
                }
                break;
        }
        if(addedSweet.equals("yes")){
            if(pricePerMonth <= 10){
                pricePerMonth+=5.5;
            }else if(pricePerMonth <= 30){
                pricePerMonth+=4.35;
            }else if(pricePerMonth > 30){
                pricePerMonth+=3.85;
            }
        }
        double totPrice=pricePerMonth*numMonthsToPay;
        if(limit.equals("two")){
            totPrice*=.9625;
        }
        System.out.printf("%.2f lv.",totPrice);
    }
}
