package assignment02.library_management_system;

import assignment02.list_management_system.ListItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryManagementSystem {

    List<Book> books = new ArrayList<Book>();

    public LibraryManagementSystem() {

    }

    public LibraryManagementSystem(ArrayList<Book> books){
        this.books = books;
    }

    public void add(String title, String author) {
        books.add(new Book(title, author));
    }

    public void remove(String title) {
        books.remove(getIndexByTitle(title));
    }

    public String searchBook(String title) {


        if (books.isEmpty()) {
            return "This book isn't available"; // Return a message if the list is empty
        }

        Book book = books.get(getIndexByTitle(title));
        StringBuilder displayBook = new StringBuilder();
        displayBook.append(book.getTitle())
                    .append(", ")
                    .append(book.getAuthor());

        return displayBook.toString();
    }

    public String displayLibrary(){
        StringBuilder list = new StringBuilder();

        if (books.isEmpty()) {
            return "No books available."; // Return a message if the list is empty
        }

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            list.append(i + 1)  // Using i + 1 for 1-based index
                    .append(", ")
                    .append(book.getTitle())
                    .append(", ")
                    .append(book.getAuthor())
                    .append("\n");
        }

        return list.toString();
    }


    private int getIndexByTitle(String task) {
        for (int i = 0; i < books.size(); i++) {
            if (task.equals(books.get(i).getTitle())) {
                return i;
            }
        }
        return -1;
    }

}