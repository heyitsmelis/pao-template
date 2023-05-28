package ro.pao.threads;

import lombok.AllArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.exceptions.ObjectNotFoundException;
import ro.pao.exceptions.ObjectNotFoundException;

import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class ProcessingFileWorker implements Runnable {

    private String fileName;

    private Path filePath;

    private List<List<String[]>> result;

    private static final CsvReader csvReader = CsvReader.getInstance();

    private static final Logger logger = Logger.getGlobal();

    @Override
    public void run() {
        try {
            logger.log(Level.INFO, () -> Thread.currentThread().getName() + " processing " + fileName);
            result.add(csvReader.readAllLines(filePath));
        } catch (ObjectNotFoundException e) {
            logger.log(Level.WARNING, e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
