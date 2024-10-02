package assignment02;

import assignment02.library_management_system.Book;
import assignment02.library_management_system.LibraryManagementSystem;
import assignment02.list_management_system.ListItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystemTest {
    LibraryManagementSystem expected;


    @Before
    public void setup(){
        Book book = new Book("I Love Software Engineering", "Chase Moore");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        expected = new LibraryManagementSystem(books);
    }
    @Test
    public void addBookTest(){
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.add("I Love Software Engineering", "Chase Moore");
        Assert.assertEquals(expected.displayLibrary(),lms.displayLibrary());

    }



    @Test
    public void removeBookTest(){
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.add("I Love Software Engineering", "Chase Moore");
        lms.remove("I Love Software Engineering");
        Assert.assertEquals("No books available.",lms.displayLibrary());
    }

    @Test
    public void searchBookTest(){
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.add("I Love Software Engineering", "Chase Moore");
        lms.add("I'm Burned Out", "Chase Moore");
        Assert.assertEquals("I'm Burned Out, Chase Moore",lms.searchBook("I'm Burned Out"));
    }
}
