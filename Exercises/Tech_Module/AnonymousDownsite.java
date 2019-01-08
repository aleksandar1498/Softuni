import java.util.ArrayList;
import java.util.Scanner;

public class AnonymousDownsite {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberOfAffectedSites=Integer.parseInt(scanner.nextLine());
        int securityKey=Integer.parseInt(scanner.nextLine());
double totLoss=0.0;
        ArrayList<Website> s=new ArrayList<>();
        for (int i = 0; i < numberOfAffectedSites; i++) {
            String [] info=scanner.nextLine().split(" ");
            s.add(new Website(info[0],Integer.valueOf(info[1]),Double.valueOf(info[2])));
        totLoss+=Double.valueOf(info[1])*Double.valueOf(info[2]);
        }
        for(Website w:s){
            System.out.println(w.siteName);
        }
        System.out.printf("Total Loss: %.20f\n",totLoss);
        System.out.printf("Security Token: %.0f\n",Math.pow(securityKey,numberOfAffectedSites));

    }
    public static class Website{
        String siteName;
        int siteVisits;
        double siteCommercialPricePerVisit;
        public Website(String siteN,int numVisits,double price){
            this.siteName=siteN;
            this.siteVisits=numVisits;
            this.siteCommercialPricePerVisit=price;
        }
    }
}
