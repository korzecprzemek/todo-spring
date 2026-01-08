package pl.pkorzec.model;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskCsvReader {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("H:mm");

    public List<Task> read(String filePath) throws IOException, CsvException {
        String dirPath = new File("").getAbsolutePath();
        filePath = dirPath.concat("/src/main" + filePath);
        List<Task> taskList = new ArrayList<>();

        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            for(String[] row : reader.readAll()){
                Task t = new Task(
                        row[0].replace("\"",""),
                        LocalTime.parse(row[1],TIME_FORMAT),
                        LocalTime.parse(row[2],TIME_FORMAT)
                );
                taskList.add(t);
            }
        }
        return taskList;
    }
}
