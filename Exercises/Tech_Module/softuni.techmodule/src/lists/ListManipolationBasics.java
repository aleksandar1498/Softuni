package lists;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipolationBasics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> initialList= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String [] data=scanner.nextLine().split(" ");
        while(!data[0].equals("end")){
            if(data.length > 2){
                try {
                    performOperation(data[0],initialList,Integer.valueOf(data[1]),Integer.valueOf(data[2]));

                } catch(NumberFormatException e){
                    performOperation(data[0],initialList,data[1],Integer.valueOf(data[2]));

                    }

            }else{
                try {
                    performOperation(data[0], initialList, Integer.valueOf(data[1]));
                }catch (NumberFormatException e){
                    performOperation(data[0], initialList, data[1]);

                }
            }

            data=scanner.nextLine().split(" ");
        }
        System.out.println(String.join(" ",initialList.toString()));
    }
    private static void performOperation(String typeOperation,List<Integer> list,int... val){
        switch (typeOperation){
            case "Add":
                list.add(val[0]);
                break;
            case "Remove":
                list.remove(val[0]);
                break;
            case "RemoveAt":
                list.remove(val[0]);
                break;
            case "Insert":
                System.out.println(val[0]+" "+val[1]);
                list.add(val[1],val[0]);
                break;
            case "Contains":
                if(list.contains(val[0])){
                    System.out.println("Yes");
                }else{
                    System.out.println("No such number");
                }
                break;


        }
    }
    private static void performOperation(String typeOperation,List<Integer> list,String operator,int... val) {

   switch(typeOperation) {
       case "Print":
           if(operator.equals("even")){
           for (int i = 0; i < list.size(); i++) {
               if(list.get(i)%2 ==0){
                   System.out.print(list.get(i)+" ");
               }
           }
           }else{
               for (int i = 0; i < list.size(); i++) {
                   if(list.get(i)%2 != 0  ){
                       System.out.print(list.get(i)+" ");
                   }
               }
           }
           System.out.println();
           break;
       case "Get":
           int sum=0;
           for (int i = 0; i < list.size(); i++) {
               sum+=list.get(i);
           }
           System.out.println(sum);
           break;
       case "Filter":
           switch (operator){
               case "<":
                   for (int i = 0; i < list.size(); i++) {
                       if(list.get(i) < val[0]){
                           System.out.print(list.get(i)+" ");
                       }
                   }
                   System.out.println();
                   break;
               case ">":
                   for (int i = 0; i < list.size(); i++) {
                       if(list.get(i) > val[0]){
                           System.out.print(list.get(i)+" ");
                       }
                   }
                   System.out.println();
                   break;
               case ">=":
                   for (int i = 0; i < list.size(); i++) {
                       if(list.get(i) >= val[0]){
                           System.out.print(list.get(i)+" ");
                       }
                   }
                   System.out.println();
                   break;
               case "<=":
                   for (int i = 0; i < list.size(); i++) {
                       if(list.get(i) <= val[0]){
                           System.out.print(list.get(i)+" ");
                       }
                   }
                   System.out.println();
                   break;
           }
           break;
   }
   }
    }

