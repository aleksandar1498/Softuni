import java.util.*;
import java.util.regex.*;
public class Voina {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Map<String,ArrayList<Double>> students=new TreeMap<>();
        int numInsertedGrades=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<numInsertedGrades;i++){
            String [] dataToken=scanner.nextLine().split(" ");
            if(!students.containsKey(dataToken[0])){
                students.put(dataToken[0],new ArrayList<>());
            }
             students.get(dataToken[0]).add(Double.parseDouble(dataToken[1]));
        }
        students.entrySet().stream().forEach(student -> {
            System.out.print(student.getKey()+" -> ");
            student.getValue().stream().forEach(st -> System.out.printf("%.2f ",st));
            System.out.printf("(avg: %.2f)%n",(student.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()));
            });
     
    }
}
