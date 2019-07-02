package bookShop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    Pattern namePattern;
    private String title;
    private String author;
    private double price;

    public Book( String author, String title,double price) {
        namePattern = Pattern.compile("[A-Za-z0-9]+( ([A-Za-z]+)*)");
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    protected String getTitle() {
        return title;
    }

    protected String getAuthor() {
        return author;
    }

    protected double getPrice() {
        return price;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        Matcher matcher = namePattern.matcher(author);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
     /*   Type: Book
        Title: Pod Igoto
        Author: Ivan Vazov
        Price: 233.0*/

        return String.format("Type: %s%nTitle: %s%nAuthor: %s%nPrice: %.2f%n", this.getClass().getSimpleName(), this.getTitle(),this.getAuthor(),this.getPrice());

    }
}
