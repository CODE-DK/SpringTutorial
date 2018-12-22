package beans;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public String toString(){
        return id + " " + msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }
}
