package tasks;

import status.Status;

import java.util.Objects;

public class SubTask extends Task {
    private int epicId;

    public SubTask(String nameTask, String description, Status status, int epicId) {
        super(nameTask, description, status);
        this.epicId = epicId;
    }

    public SubTask(String nameTask, String description, Status status, int epicId, int taskID) {
        super(nameTask, description, status);
        this.epicId = epicId;
        setTaskID(taskID);
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SubTask subTask = (SubTask) o;
        return epicId == subTask.epicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicId);
    }

    @Override
    public String toString() {
        return "SubTask{" + super.toString() +
                "epicId=" + epicId +
                '}';
    }
}
