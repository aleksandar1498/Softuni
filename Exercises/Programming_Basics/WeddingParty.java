import java.util.Scanner;

public class WeddingParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numGuests=Integer.parseInt(scanner.nextLine());
        int budget=Integer.parseInt(scanner.nextLine());
        int neededMoney=numGuests*20;
        if(neededMoney <= budget){
            double moneyForFire=(budget-neededMoney)*.4;
            System.out.printf("Yes! %.0f lv are for fireworks and %.0f lv are for donation.",moneyForFire,(budget-neededMoney)-moneyForFire);
        }else{
            System.out.printf("They won't have enough money to pay the covert. They will need %d lv more.",neededMoney-budget);
        }
    }
}
