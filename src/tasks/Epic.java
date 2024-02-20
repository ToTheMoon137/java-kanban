package tasks;
import status.Status;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    private ArrayList<Integer> subTaskIds = new ArrayList<>();

    public Epic(String nameTask, String description) {
        super(nameTask, description);
    }

    public Epic(String nameTask, String description, int taskID, ArrayList<Integer> subTaskIds) {
        super(nameTask, description);
        setTaskID(taskID);
        this.subTaskIds = subTaskIds;
    }

    public ArrayList<Integer> getSubTaskIds() {
        return subTaskIds;
    }

    public void setSubTaskIds(int subTaskId) {
        subTaskIds.add(subTaskId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subTaskIds, epic.subTaskIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subTaskIds);
    }

    @Override
    public String toString() {
        return "Epic{" + super.toString() +
                "subTaskIds=" + subTaskIds +
                '}';

    }
}
