package listyiterator;
import java.util.*;
import java.util.stream.*;
class ListyIterator implements Iterator<String>{
    String [] data;
    int counter=0;
    public ListyIterator(String... d){
        data=d;
    }
    public boolean move(){
        if(counter+1 < data.length){
            counter++;
            return true;
        }
        return false;
    }
    @Override
    public String next(){
        return data[counter++];
    }
    @Override
    public boolean hasNext(){
        if(counter+1 < data.length){
            return true;
        }
        return false;
    }
    public void print(){
        if(data.length == 0){
           System.out.println("Invalid Operation!");
        }else{
            System.out.println(data[counter]);
        }
    }
}