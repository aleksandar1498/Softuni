import java.util.Scanner;

public class Christmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double targetMoney = Double.parseDouble(scanner.nextLine());
        int numFan=Integer.parseInt(scanner.nextLine());
        int numHor=Integer.parseInt(scanner.nextLine());
        int numRom=Integer.parseInt(scanner.nextLine());
        double sum=numFan*14.9 + numHor* 9.8 + numRom*4.30;
        sum-=sum*.20;
        if(sum > targetMoney){
            double bonusForTheSeller=Math.floor((sum-targetMoney)*.1);
            sum-=bonusForTheSeller;
            if(bonusForTheSeller-(int)bonusForTheSeller >0){
                System.out.printf("%.2f leva donated.\nSellers will receive %.2f leva.",sum,bonusForTheSeller);

            }else{
                System.out.printf("%.2f leva donated.\nSellers will receive %d leva.",sum,(int)bonusForTheSeller);

            }
        }else{
            System.out.printf("%.2f money needed.",(targetMoney-sum));
        }
    }

}
