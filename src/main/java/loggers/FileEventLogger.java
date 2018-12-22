package loggers;

import beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger extends AbstractLogger implements EventLogger {

    private String fileName;
    private File file;

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);

        if (!file.canWrite()) throw new IOException("Can't write to file");
        if (!file.exists()) file.createNewFile();
    }
}
