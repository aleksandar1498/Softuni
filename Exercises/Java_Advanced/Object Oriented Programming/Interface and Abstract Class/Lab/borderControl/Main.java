package borderControl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Identifiable> identifiables = new ArrayList<>();
        String command="";
        while(!"End".equals(command = scanner.nextLine())){
            String [] commandToken=command.split("\\s+");
            if(commandToken.length == 2){
                identifiables.add(new Robot(commandToken[0],commandToken[1]));
            }else{
                identifiables.add(new Citizen(commandToken[0],Integer.parseInt(commandToken[1]),commandToken[2]));
            }
        }
        String illecitSuffix=scanner.nextLine().trim();
        identifiables.stream().filter(x -> x.getId().endsWith(illecitSuffix)).forEach(detained -> System.out.println(detained) );
    }
}
