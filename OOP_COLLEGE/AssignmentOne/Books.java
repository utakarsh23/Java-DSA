package AssignmentOne;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//ques 26
public class Books {
    String title;
    String author;
    Date yop;

    public Books(String title, String author, Date yop) {
        this.title = title;
        this.author = author;
        this.yop = yop;
    }

    public void displayBookDetails() {
        System.out.println();
        System.out.println("Title :                 " + title);
        System.out.println("Author :                " + author);
        System.out.println("Year Of Publication :   " + yop);
        System.out.println();
    }

    static boolean compare(Books a, Books b){
        return a.yop == b.yop && a.title.equals(b.title) && a.author.equals(b.author);
    }
}

class mainClass1 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = sdf.parse("2019");
        Date date1 = sdf.parse("2017");
        Books book1 = new Books("No Longer Human", "Osamu Dazai", date);
        Books book3 = new Books("No Longer Human", "Osamu Dazai", date);
        Books book2 = new Books("Computer Networks", "Bellmen", date1);
        book1.displayBookDetails();
        book2.displayBookDetails();
        book3.displayBookDetails();
        System.out.println(Books.compare(book1, book2));
        System.out.println(Books.compare(book1, book3));
        System.out.println(Books.compare(book3, book2));
    }
}
