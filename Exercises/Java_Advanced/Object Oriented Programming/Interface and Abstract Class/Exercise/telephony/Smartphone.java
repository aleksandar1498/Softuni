package telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.setNumbers(numbers);
        this.setUrls(urls);
    }

    List<String> getNumbers() {
        return numbers;
    }

    List<String> getUrls() {
        return urls;
    }

    private void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    private void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String browse(String url) {

        StringBuilder builder= new StringBuilder();
            if(url.matches("[^0-9]+")){
                return builder.append("Browsing: ").append(url).append("!").toString();
            }else{
                return builder.append("Invalid URL!").toString();
            }

    }

    @Override
    public String call(String number) {
        StringBuilder builder=new StringBuilder();



            if(number.matches("[^\\D]+")) {
               return builder.append("Calling... ").append(number).toString();
            }else{
               return builder.append("Invalid number!").toString();

            }

    }
}
