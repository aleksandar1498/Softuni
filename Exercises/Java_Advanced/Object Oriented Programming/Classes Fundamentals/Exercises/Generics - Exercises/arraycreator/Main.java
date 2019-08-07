package arraycreator;
public class Main {
    public static void main(String args[]) {
        ArrayCreator<String> creator=new ArrayCreator(String.class);
        for(String s: creator.create(10,"alex")){
            System.out.println(s);
        }
    }
}