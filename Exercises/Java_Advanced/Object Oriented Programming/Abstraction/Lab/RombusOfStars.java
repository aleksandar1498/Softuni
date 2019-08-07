import java.util.Scanner;

public class RombusOfStars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print(draw(" ",n-i-1));
            System.out.print(drawAlternate("*",i+1));
            System.out.println(draw(" ",n-i-1));

        }
        for (int i = n-2; i >= 0; i--) {
            System.out.print(draw(" ",n-i-1));
            System.out.print(drawAlternate("*",i+1));
            System.out.println(draw(" ",n-i-1));

        }
    }
    public static String draw(String sym,int l){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < l; i++) {
            builder.append(sym);
        }
        return builder.toString();
    }
    public static String drawAlternate(String sym,int l){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < l*2-1; i++) {
            if(i%2 == 0){
                builder.append(sym);
            }else{
                builder.append(" ");
            }

        }
        return builder.toString();
    }
}
