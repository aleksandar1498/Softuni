package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;
    public Smartphone(List<String> numbers,List<String> urls) {
        this.numbers=numbers;
        this.urls=urls;
    }

    @Override
    public String browse() {
        int i=0;
        StringBuilder builder=new StringBuilder();
        for (String url : this.urls) {
            if(i == 0){
                i++;
            }else{
                builder.append(System.lineSeparator());
            }
            boolean isValid = true;
            for (char c : url.toCharArray()) {
                if (Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                builder.append(String.format("Browsing: %s!", url));
                continue;
            }
            builder.append("Invalid URL!");

        }
        return builder.toString();
    }

    @Override
    public String call() {
        int i=0;
        StringBuilder builder=new StringBuilder();
        for (String number : this.numbers) {
            if(i == 0){
                i++;
            }else{
                builder.append(System.lineSeparator());
            }
            boolean isValid = true;
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                builder.append(String.format("Calling... %s", number));
                continue;
            }
            builder.append("Invalid number!");

        }
        return builder.toString();


    }


}
