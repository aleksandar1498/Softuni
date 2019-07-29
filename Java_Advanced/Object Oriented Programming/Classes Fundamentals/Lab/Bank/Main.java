import java.util.*;
import java.text.*;
import java.util.function.*;
public class Main {
    public static void main(String args[]) {
        DecimalFormat df=new DecimalFormat("#######.##");
        BiPredicate<Integer,Integer> findId=(a,b) -> a == b;
        BiFunction<BankAccount,Integer,Boolean> findBank=(bank,id) -> findId.test(bank.getId(),id);
        Scanner scanner=new Scanner(System.in);
        String operation="";
        List<BankAccount> bankAccounts=new ArrayList<>();
        while(!"End".equals(operation = scanner.nextLine())){
            String [] operationToken=operation.split(" ");
            String typeOperation=operationToken[0];
            switch(typeOperation){
                case "Create":
                    bankAccounts.add(new BankAccount());
                    break;
                case "Deposit":
                    int id=Integer.parseInt(operationToken[1]);
                    double amount=Double.parseDouble(operationToken[2]);
                    boolean found=false;
                    for(int i=0;i < bankAccounts.size();i++){
                        if(findBank.apply(bankAccounts.get(i),id)){
                            bankAccounts.get(i).deposit(amount);
                            System.out.printf("Deposited %s to ID%s%n",df.format(amount),bankAccounts.get(i).getId());
                            found=true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Account does not exist");
                    }
                    
                    break;
                case "SetInterest":
                     double newInterest=Double.parseDouble(operationToken[1]);
                     BankAccount.setInterestRate(newInterest);
                    break;
                case "GetInterest":
                    int searchedId=Integer.parseInt(operationToken[1]);
                    int years=Integer.parseInt(operationToken[2]);
                    boolean foundB=false;
                    for(int i=0;i < bankAccounts.size();i++){
                        if(findBank.apply(bankAccounts.get(i),searchedId)){
                            System.out.printf("%.2f%n",bankAccounts.get(i).getInterest(years));
                            foundB=true;
                            break;
                        }
                    }
                    if(!foundB){
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
  
   
}