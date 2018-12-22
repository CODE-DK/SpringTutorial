import beans.Client;
import beans.Event;
import beans.EventType;
import loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers){
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml", "loggers.xml", "others.xml");

        App app = ctx.getBean("app", App.class);

//        app.logEvent();

        ctx.close();
    }

    private void logEvent(EventType eventType, Event event, String msg){

        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if(logger == null){
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
