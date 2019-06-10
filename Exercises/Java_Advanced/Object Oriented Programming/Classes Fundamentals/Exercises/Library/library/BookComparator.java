package library;
import java.util.*;
class BookComparator implements Comparator<Book>{
       @Override
       public int compare(Book o,Book o1){
           if(o.getTitle().compareTo(o1.getTitle()) == 0){
               if(o.getYear() < o1.getYear()){
                   return -1;
               }else if(o.getYear() > o1.getYear()){
                   return 1;
               }
               return 0;
           }else{
               return o.getTitle().compareTo(o1.getTitle());
           }
          
       }
   }