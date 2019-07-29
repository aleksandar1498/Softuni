import java.util.*;
import java.util.regex.*;
public class PhoneBook {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
         Map<String,String> phonebook=new HashMap<>();
        String add="";
        while(!"search".equals(add = scanner.nextLine())){
            String [] phoneEntryToken=add.split("-");
            phonebook.put(phoneEntryToken[0],phoneEntryToken[1]);
        }
        String searched="";
        while(!"stop".equals(searched = scanner.nextLine())){
           System.out.println((phonebook.containsKey(searched))? String.format("%s -> %s",searched,phonebook.get(searched)):String.format("Contact %s does not exist.",searched));
        }
      
     
    }
}