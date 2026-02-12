package pl.pkorzec.todo.application;

import org.springframework.stereotype.Service;
import pl.pkorzec.todo.domain.TaskList;
import pl.pkorzec.todo.persistence.TaskListRepository;

@Service
public class TaskListService {
    private TaskList taskList;
    private static final String DEFAULT_LIST_NAME = "Inbox"; // We treat Inbox as User's private tasklist - every user has one

    private TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository){
        this.taskListRepository = taskListRepository;
    }

    public TaskList getOrCreateInbox(Long userId){
        return taskListRepository
                .findByOwnerUserIdAndName(userId,DEFAULT_LIST_NAME)
                .orElseGet(() -> {
                    TaskList inbox = new TaskList();
                    inbox.setName(DEFAULT_LIST_NAME);
                    inbox.setOwnerUserId(userId);
                    return taskListRepository.save(inbox);
                });
    }
}
