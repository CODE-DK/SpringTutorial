package loggers;

import beans.Event;

import java.util.Collection;

public class CombinedEventLogger extends AbstractLogger {

    private Collection<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    public Collection<EventLogger> getLoggers() {
        return loggers;
    }
}
