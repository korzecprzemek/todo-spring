package pl.pkorzec.todo.application;

import pl.pkorzec.todo.domain.Priority;

public class TaskQuery {

    private Boolean done;
    private Priority priority;
    private String search;

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
