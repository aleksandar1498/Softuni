package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double initialSave=Double.parseDouble(scanner.nextLine());
        List<Integer> initialQuality= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> backupQuality=new ArrayList<>();
        initialQuality.stream().forEach(backupQuality::add);
        String action=scanner.nextLine();
        while(!action.equals("Hit it again, Gabsy!")){
            int powerAppliedToDrum=Integer.valueOf(action);
            for (int i = 0; i < backupQuality.size(); i++) {
                if(backupQuality.get(i) == 0){
                    continue;
                }
                if((backupQuality.get(i) - powerAppliedToDrum) > 0){
                    backupQuality.set(i,backupQuality.get(i)-powerAppliedToDrum);
                }else{
                    double drumPrice=initialQuality.get(i)*3;
                    if((initialSave-drumPrice ) > 0){
                        initialSave-=drumPrice;
                        backupQuality.set(i,initialQuality.get(i));

                    }else{
                        backupQuality.set(i,0);
                    }
                }
            }
            action=scanner.nextLine();
        }
        System.out.println(String.join(" ",backupQuality.stream().filter(integer -> (integer > 0)).collect(Collectors.toList()).toString().replaceAll("[\\[\\],]","")));
        System.out.printf("Gabsy has %.2flv.",initialSave);

    }
}
