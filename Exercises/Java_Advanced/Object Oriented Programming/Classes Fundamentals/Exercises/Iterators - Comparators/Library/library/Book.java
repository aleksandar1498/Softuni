package library;
import java.util.*;
class Book implements Comparable<Book>{
   private String title;
   private int year;
   private List<String> authors;
   public Book(String title,int year,String... authors){
       this.title=title;
       this.year=year;
       
   }
   public String getTitle(){
       return this.title;
   }
   public int getYear(){
       return this.year;
   }
   public List<String> getAuthors(){
       return this.authors;
   }
   @Override
   public int compareTo(Book o){
       return (this.getTitle().compareTo(o.getTitle()) != 0)?this.getTitle().compareTo(o.getTitle()) : this.getYear()-o.getYear();
   }
   private void setTitle(String title){
       this.title=title;
   }
   private void setYear(int year){
       this.year=year;
   }
   private void setAuthors(String... authors){
       List<String> auths=Arrays.asList(authors);
       if(auths.size() != 0){
           this.authors=auths;
       }
       
   }
}