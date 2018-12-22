import beans.Client;
import loggers.EventLogger;

public class App {

    private Client client;
    private EventLogger eventLogger;

    App(Client client, EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
//        App app = new App();

//        app.client = new beans.Client(1, "John Smith");
//        app.eventLogger = new loggers.ConsoleEventLogger();

//        app.logEvent("first event");
    }

    private void logEvent(String msg){
        String s = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(s);
    }
}
