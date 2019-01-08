import java.util.Scanner;

public class WeddingPresents {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int totGuests=Integer.parseInt(scanner.nextLine());
        int numPresents=Integer.parseInt(scanner.nextLine());
        double percGuestsWithPresents=(numPresents*100.0)/totGuests;
        double pMoney=0,pTech=0,pVouchers=0,pOthers=0;
        for (int present = 0; present < numPresents; present++) {
            String pre=scanner.nextLine();
            switch (pre){
                case "A":
                    pMoney++;
                break;
                case "B":
                    pTech++;
                    break;
                case "V":
                    pVouchers++;
                    break;
                case "G":
                    pOthers++;
                    break;
            }
        }
        System.out.printf("%.2f%%\n",(pMoney*100)/numPresents);
        System.out.printf("%.2f%%\n",(pTech*100)/numPresents);
        System.out.printf("%.2f%%\n",(pVouchers*100)/numPresents);
        System.out.printf("%.2f%%\n",(pOthers*100)/numPresents);
        System.out.printf("%.2f%%\n",percGuestsWithPresents);
    }
}
