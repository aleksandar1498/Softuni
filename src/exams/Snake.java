package exams;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sizeOfScreen=Integer.parseInt(scanner.nextLine());
        String [] actions = scanner.nextLine().split(",");
        char [][] pixels=new char[sizeOfScreen][sizeOfScreen];
        int countFood=0;
        int snakeLength=1;
        int snakePositionX=0;
        int snakePositionY=0;
        for (int i = 0; i < sizeOfScreen; i++) {
            char [] row= scanner.nextLine().replace(" ","").toCharArray();
            for (int j = 0; j < row.length; j++) {
                if(row[j] == 's'){
                    snakePositionY=i;
                    snakePositionX=j;
                }else if(row[j] == 'f'){
                    countFood++;
                }
                pixels[i][j]=row[j];
            }
        }
        for (int i = 0; i < actions.length; i++) {
            switch (actions[i].trim()){
                case "up":
                    if(snakePositionY-1 < 0){
                        snakePositionY=sizeOfScreen-1;
                    }else{
                        snakePositionY--;
                    }

                    break;
                case "down":
                    if(snakePositionY+1 > (sizeOfScreen-1)){
                        snakePositionY=0;
                    }else{
                        snakePositionY++;
                    }
                    break;
                case "left":
                    if(snakePositionX-1 < 0 ){
                        snakePositionX=sizeOfScreen-1;
                    }else{
                        snakePositionX--;
                    }
                    break;
                case "right":
                    if(snakePositionX+1 > (sizeOfScreen-1)){
                        snakePositionX=0;
                    }else{
                        snakePositionX++;
                    }
                    break;
            }
            if(pixels[snakePositionY][snakePositionX] == 'e'){
                if(countFood == 0){
                    System.out.println("You win! Final snake length is "+snakeLength);

                }else{
                    System.out.println("You lose! Killed by an enemy!");

                }
                return;
            }else if(pixels[snakePositionY][snakePositionX] == 'f'){
                countFood--;
                snakeLength++;

            }
        }
        if(countFood == 0){
            System.out.println("You win! Final snake length is "+snakeLength);
        }else{
            System.out.println("You lose! There is still "+countFood+" food to be eaten.");
        }

    }
}
