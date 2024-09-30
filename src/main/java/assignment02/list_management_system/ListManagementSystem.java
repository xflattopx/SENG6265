package assignment02.list_management_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListManagementSystem {
    private List<ListItem> listItems = new ArrayList<ListItem>();

    public  ListManagementSystem(){

    }
    public ListManagementSystem(ArrayList<ListItem> listItem){
        this.listItems = listItem;
    }

    public void add(String task, Date date, boolean isDone){
        listItems.add(new ListItem(task,date,isDone));
    }

    //  Gets the item based on the name of the task
    //  Removes it by index.
    public void remove(String task){
        if(getIndexByTask(task) != -1) {
            listItems.remove(getIndexByTask(task));
        }
    }

    //  Gets the item based on the name of the task
    //  marks task as done or not done
    public void updateTask(String task, boolean isDone){
        if(getIndexByTask(task) != -1) {
            listItems.get(getIndexByTask(task)).setIsDone(isDone);
        }
    }

    public String displayList() {
        StringBuilder list = new StringBuilder();

        if (listItems.isEmpty()) {
            return "No tasks available."; // Return a message if the list is empty
        }

        for (int i = 0; i < listItems.size(); i++) {
            ListItem item = listItems.get(i);
            String status = item.getIsDone() ? "completed" : "not completed"; // Check if the task is done
            list.append(i + 1)  // Using i + 1 for 1-based index
                    .append(", ")
                    .append(item.getTask())
                    .append(", ")
                    .append(item.getDate())
                    .append(", ")
                    .append(status)
                    .append("\n");
        }

        return list.toString();
    }

    private int getIndexByTask(String task){
        for(int i = 0; i < listItems.size(); i++){
            if(task.equals(listItems.get(i).getTask())){
                return i;
            }
        }
        return -1;
    }


}
