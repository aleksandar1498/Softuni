import java.util.Scanner;

public class WeddingDecoration {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Double.parseDouble(scanner.nextLine());
        double initialBudget=budget;
        String action=scanner.nextLine();
        boolean allSpent=false;
        int numB=0,numF=0,numC=0,numR=0;
        outer:while(!action.equals("stop")){
            int numDec=Integer.parseInt(scanner.nextLine());

            switch (action){
                case "balloons":
                    numB+=numDec;
                    if(budget - (.1*numDec) < 0){
                        System.out.println("All money is spent");
                        allSpent=true;
                        break outer;
                    }

                    budget-=.1*numDec;
                    break ;
                case "flowers":
                    numF+=numDec;

                    if(budget - (1.5*numDec) < 0){
                        System.out.println("All money is spent");
                        allSpent=true;

                        break outer;
                    }

                    budget-=1.5*numDec;

                    break ;

                case "candles":
                    numC+=numDec;

                    if(budget - (.5*numDec) < 0){
                        System.out.println("All money is spent");
                        allSpent=true;

                        break  outer;
                    }
                    budget-=.5*numDec;

                    break ;
                case "ribbon":
                    numR+=numDec;

                    if(budget - (2*numDec) < 0){
                        System.out.println("All money is spent");
                        allSpent=true;

                        break outer;
                    }

                    budget-=2*numDec;

                    break ;
            }
            action=scanner.nextLine();
        }
        if(!allSpent){
            System.out.printf("Spend money: %.2f\nMoney left: %.2f\n",initialBudget-budget,budget);
        }
        System.out.printf("Purchased decoration is %d balloons, %d m ribbon, %d flowers and %d candles.",numB,numR,numF,numC);
    }
}
