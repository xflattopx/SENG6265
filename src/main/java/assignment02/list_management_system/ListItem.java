package assignment02.list_management_system;

import java.util.Date;

public class ListItem {
    private String task = "";
    private Date date;
    private boolean isDone = false;

    public ListItem(){

    }

    public ListItem(String task, Date date, boolean isDone){
        this.date = date;
        this.task = task;
        this.isDone = isDone;
    }

    public String getTask() {
        return this.task;
    }

    public Date getDate() {
        return this.date;
    }

    public boolean getIsDone(){
        return this.isDone;
    }

    public void setTask(String task){
        this.task = task;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }
}
