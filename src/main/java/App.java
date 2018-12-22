public class App {

    private Client client;
    private ConsoleEventLogger eventLogger;

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client(1, "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("first event");
    }

    private void logEvent(String msg){
        String s = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(s);
    }
}
