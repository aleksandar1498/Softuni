package mood;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] characterToken=scanner.nextLine().split("(\\s\\|\\s)");
        Character  character=null;
        switch (characterToken[1]){
            case "Demon":
                character=new Demon(characterToken[0],Integer.parseInt(characterToken[3]),Double.parseDouble(characterToken[2]));
                break;
            case "Archangel":
                character=new Archangel(characterToken[0],Integer.parseInt(characterToken[3]),Integer.parseInt(characterToken[2]));
                break;
        }

      System.out.println(character);
    }
}
