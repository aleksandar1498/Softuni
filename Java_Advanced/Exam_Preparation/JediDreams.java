import java.util.*;
import java.util.regex.*;
public class JediDreams {
    public static void main(String args[]) {
       Scanner scanner=new Scanner(System.in);
       Deque<Declaration> methodDeclarations=new ArrayDeque<>();
       Pattern p=Pattern.compile("(?<call>[a-zA-Z]*[A-Z][a-zA-Z]*)\\s*\\(");
       Pattern title=Pattern.compile("static\\s+.*\\s+(?<method>[a-zA-Z]*[A-Z][a-zA-Z]*)\\s*\\(");
       
       int n=Integer.parseInt(scanner.nextLine());
           for(int i=0;i<n;i++){
               String lineCode=scanner.nextLine();
              // System.out.println(lineCode);
               if(lineCode.contains("static")){
                   Matcher m=title.matcher(lineCode);
                   if(m.find()){
                       String nameDeclaration=m.group("method");
                       methodDeclarations.push(new Declaration(nameDeclaration));
                   }
                  
               }else{
                   Matcher m=p.matcher(lineCode);
                   while(m.find()){
                       methodDeclarations.peek().addMethod(m.group("call"));
                   }
               }
               
           
           }
           methodDeclarations.stream().sorted((m1,m2) -> {
               int sort = Integer.compare(m2.getMethods().size(),m1.getMethods().size());
               if(sort == 0){
                   return m1.name.compareTo(m2.name);
               }
               return sort;
           }).forEach(d -> {
               if(d.getMethods().size() == 0){
                   System.out.println(d.name+" -> None");
               }else{
                    Collections.sort(d.getMethods(),Comparator.naturalOrder());
                    System.out.println(d.name+" -> "+d.getMethods().size()+" -> "+d.getMethods().toString().replaceAll("[\\[\\]]",""));
               }
              
               });
           
        
    }
    static class Declaration{
        private String name;
        private List<String> methods;
        public Declaration(String name){
            this.name=name;
            this.methods=new ArrayList<>();
        }
        public void addMethod(String method){
            this.methods.add(method);
        }
        public List<String> getMethods(){
            return this.methods;
        }
    }
    
}