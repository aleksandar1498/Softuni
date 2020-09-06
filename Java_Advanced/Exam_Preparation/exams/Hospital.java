package arena;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, LinkedList<String>> departments=new LinkedHashMap<>();
        Map<String,LinkedList<String>> doctors=new LinkedHashMap<>();
        String line="";
        while(!"Output".equals(line = scanner.nextLine())){
            String [] token=line.split("\\s+");
            String department=token[0];
            String doctorFullName=token[1]+" "+token[2];
            String patient=token[3];
            doctors.putIfAbsent(doctorFullName,new LinkedList<>());
            departments.putIfAbsent(department,new LinkedList<>());
            if(departments.get(department).size() < 60){
                departments.get(department).add(patient);
                doctors.get(doctorFullName).add(patient);
            }
        }
        String command="";
        while(!"End".equals(command = scanner.nextLine())){
            String [] cmToken=command.split(" ");
            if(cmToken.length == 2){
                if(Character.isDigit(cmToken[1].charAt(0))){
                    int room=Integer.parseInt(cmToken[1]);
                    room--;
                    departments.get(cmToken[0]).stream().skip(3*room).limit(3).sorted().forEach(System.out::println);
                }else{
                    doctors.get(command.trim()).stream().sorted().forEach(System.out::println);
                }
            }else{
                departments.get(cmToken[0]).forEach(System.out::println);
            }
        }
    }
}
