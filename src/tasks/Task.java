package tasks;

import status.Status;

import java.util.Objects;

public class Task {
    private String nameTask;
    private String description;
    private Status status;
    private int taskID;


    public Task(String nameTask, String description, Status status) {
        this.nameTask = nameTask;
        this.description = description;
        this.status = status;
    }

    public Task(String nameTask, String description) {
        this.nameTask = nameTask;
        this.description = description;

    }

    public Task(String nameTask, String description, Status status, int taskID) {
        this.nameTask = nameTask;
        this.description = description;
        this.status = status;
        this.taskID = taskID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskID == task.taskID && Objects.equals(nameTask, task.nameTask) && Objects.equals(description, task.description) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTask, description, status, taskID);
    }

    @Override
    public String toString() {
        return "Task{" +
                "nameTask='" + nameTask + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", taskID=" + taskID +
                '}';
    }
}
