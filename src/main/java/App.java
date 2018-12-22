import beans.Client;
import loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    App(Client client, EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

//        app.client = new beans.Client(1, "John Smith");
//        app.eventLogger = new loggers.ConsoleEventLogger();

        app.logEvent("first event");
        app.logEvent("second event");
    }

    private void logEvent(String msg){
        String s = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(s);
    }
}
