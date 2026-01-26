package pl.pkorzec.todo.application;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import pl.pkorzec.todo.domain.Priority;
import pl.pkorzec.todo.domain.Task;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskCsvReader {

    public List<Task> read(String filePath) throws IOException, CsvException {
        String dirPath = new File("").getAbsolutePath();
        filePath = dirPath.concat("/src/main" + filePath);
        List<Task> taskList = new ArrayList<>();

        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            for(String[] row : reader.readAll()){
                if (row.length == 0) continue;

                String name = unquote(row[0]);
                String priorityRaw = row.length > 1 ? unquote(row[1]) : null;

                Task t = new Task(
                        name,
                        Priority.fromString(priorityRaw),
                        false,
                        null
                );
                taskList.add(t);
            }
        }
        return taskList;
    }

    private String unquote(String s) {
        return s == null ? null : s.replace("\"", "").trim();
    }
}
