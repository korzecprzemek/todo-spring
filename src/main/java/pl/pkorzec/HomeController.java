package pl.pkorzec;

import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import jakarta.validation.Valid;


import pl.pkorzec.model.*;

import java.io.IOException;
import java.time.LocalTime;

@Controller
public class HomeController {

    private final TaskService taskService;

    public HomeController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    String index(Model model){
        model.addAttribute("tasks",taskService.getAll()) ;
        return "index";
    }
    @PostMapping("/tasks/read")
    public String readTasks(){
        TaskCsvReader tasksReader = new TaskCsvReader();
        try {
            tasksReader.read("/resources/data.csv").forEach(taskService::addTask);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        };
        return "redirect:/";
    }
    @PostMapping("/tasks/add")
    public String addTask(@Valid TaskFormDTO form, BindingResult result) {
        taskService.addTask(
                form.taskName(),
                LocalTime.parse(form.taskStartTime()),
                LocalTime.parse(form.taskEndTime())
        );
        return "redirect:/";
    }
    @RequestMapping("/test")
    String test(){
        return "test.html";
    }


}
