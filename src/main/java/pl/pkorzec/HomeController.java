package pl.pkorzec;

import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("taskForm",new TaskFormDTO("",null));
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
    public String addTask(@Valid @ModelAttribute("taskForm")TaskFormDTO form, BindingResult result) {
        if(result.hasErrors()) return "index";
        taskService.addFromForm(form);
        return "redirect:/";
    }
    @PostMapping("tasks/find")
    public String findTask(Long id){
        Task task = taskService.findById(id);
        System.out.println(task.getId());
        System.out.println(task.getTaskName());
        return "redirect:/";
    }
    @PostMapping("tasks/remove")
    public String removeTask(Long id){
        taskService.removeById(id);
        return "redirect:/";
    }
    @RequestMapping("/test")
    String test(){
        return "test.html";
    }

}
