import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char lastSector=scanner.nextLine().charAt(0);
        int numSitsInEachSectors=Integer.parseInt(scanner.nextLine());
        int numSitsInOdd=Integer.parseInt(scanner.nextLine());
        int totComb=0;
        // odd e dispari , even pari
        for (char i = 'A'; i <= lastSector ; i++) {
            for (int j = 1; j <= numSitsInEachSectors ; j++) {
                if(j%2 == 0){
                    for (int k = 97; k < 97+numSitsInOdd+2 ; k++) {
                        totComb++;
                        System.out.printf("%c%d%c\n",i,j,(char)k);
                    }
                }else{
                    for (int k = 97; k < 97+numSitsInOdd ; k++) {
                        totComb++;
                        System.out.printf("%c%d%c\n",i,j,(char)k);
                    }
                }

            }
            numSitsInEachSectors++;
        }
        System.out.println(totComb);
    }
}
