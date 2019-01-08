import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int priceSinger=Integer.parseInt(scanner.nextLine());
        String action=scanner.nextLine();
        int earnedMoeny=0;
        int totGuests=0;
        while(!action.equals("The restaurant is full")){
            int peopleInGroup=Integer.parseInt(action);
            totGuests+=peopleInGroup;
            if(peopleInGroup < 5){
                earnedMoeny+=peopleInGroup*100;
            }else{
                earnedMoeny+=peopleInGroup*70;
            }
            action=scanner.nextLine();
        }
        if(earnedMoeny >= priceSinger){
            System.out.printf("You have %d guests and %d leva left.",totGuests,earnedMoeny-priceSinger);
        }else{
            System.out.printf("You have %d guests and %d leva income, but no singer.",totGuests,earnedMoeny);
        }
    }
}
