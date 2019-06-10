package library;
import java.util.*;
class Library implements Iterable<Book>{
    Book [] books;
    public Library(Book... books){
        this.books=books;
    }
    @Override
    public Iterator<Book> iterator(){
        return new LibraryIterator();
    }
    private final class LibraryIterator implements Iterator<Book>{
        int counter=0;
        public boolean hasNext(){
            if(counter < books.length){
                return true;
            }
            return false;
        }
        public Book next(){
            return books[counter++];
        }
    }
}