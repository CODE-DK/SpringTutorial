import beans.Client;
import loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;

    App(Client client, EventLogger eventLogger){
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = ctx.getBean("app", App.class);

        app.logEvent(ctx);

        ctx.close();
    }

    private void logEvent(ApplicationContext ctx){

    }
}
