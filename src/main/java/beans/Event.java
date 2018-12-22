package beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private static final AtomicInteger ID = new AtomicInteger(0);
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
        this.id = ID.getAndIncrement();
        this.date = date;
        this.df = df;
    }
}
