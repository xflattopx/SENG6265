package assignment02;

import assignment02.list_management_system.ListItem;
import assignment02.list_management_system.ListManagementSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListMangementSystemTest {
    private ListItem item;
    private ArrayList<ListItem> itemList;
    private ListManagementSystem expected;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Before
    public void setup() throws ParseException {

        Date date = sdf.parse("2024-09-29");
        item = new ListItem("Study For Exam", date, false);
        itemList = new ArrayList<ListItem>();
        itemList.add(item);
        expected = new ListManagementSystem(itemList);

    }

    @Test
    public void addTaskTest() throws ParseException {
        ListManagementSystem lms = new ListManagementSystem();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2024-09-29");
        lms.add("Study For Exam", date, false); //we're adding by name of task
        Assert.assertEquals(expected.displayList(),lms.displayList());
    }

    @Test
    public void removeTaskTest() throws ParseException {
        ListManagementSystem lms = new ListManagementSystem();
        Date date1 = sdf.parse("2024-09-29");
        Date date2 = sdf.parse("2024-09-28");
        lms.add("Study For Exam", date1, false);
        lms.add("Study For midterm",date2, false);
        lms.remove("Study For midterm"); //we're removing item based on name of task
        Assert.assertEquals(expected.displayList(),lms.displayList());
    }

    @Test
    public void markTaskTest() throws ParseException {
        ListManagementSystem lms = new ListManagementSystem();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2024-09-29");
        lms.add("Study For Exam", date, false);
        lms.updateTask("Study For Exam", true);


        ListItem listItem = new ListItem("Study For Exam", date, true);
        ArrayList<ListItem> li = new ArrayList<ListItem>();
        li.add(listItem);
        ListManagementSystem expected = new ListManagementSystem(li);
        Assert.assertEquals(expected.displayList(),lms.displayList());
    }

    @Test
    public void displayTaskTest() throws ParseException {
        ListManagementSystem lms = new ListManagementSystem();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2024-09-29");
        lms.add("Study For Exam", date, false);
        lms.updateTask("Study For Exam", false);
        Assert.assertEquals(expected.displayList(),lms.displayList());
    }
}
