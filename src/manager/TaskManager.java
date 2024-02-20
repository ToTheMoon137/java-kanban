package manager;

import java.util.HashMap;

import status.Status;
import tasks.*;

public class TaskManager {
    private int taskID = 0;
    private HashMap<Integer, Task> storageTask = new HashMap<>();
    private HashMap<Integer, SubTask> storageSubTask = new HashMap<>();
    private HashMap<Integer, Epic> storageEpic = new HashMap<>();

    private int genTaskId() {
        return taskID = taskID + 1;
    }

    public void createNewTask(Task task) {
        int ID = genTaskId();
        storageTask.put(taskID, task);
        task.setTaskID(taskID);
    }

    public void updateTask(Task task) {
        storageTask.put(task.getTaskID(), task);
    }

    public void delAllTask() {
        storageTask.clear();
    }

    public void delTaskByID(Integer ID) {
        storageTask.remove(ID);
    }

    public HashMap<Integer, Task> getAllTask() {
        return storageTask;
    }

    public Task getTaskByID(int ID) {
        return storageTask.get(ID);
    }

    public void createNewEpic(Epic epic) {
        int ID = genTaskId();
        storageEpic.put(ID, epic);
        epic.setTaskID(ID);
        updateStatus(epic);
    }

    public void updateEpic(Epic epic) {

        storageEpic.put(epic.getTaskID(), epic);
        updateStatus(epic);
    }

    public void delAllEpic() {
        storageEpic.clear();
        storageSubTask.clear();
    }

    public void delEpicByID(Integer ID) {
        Epic epic = storageEpic.get(ID);

        for (int id : epic.getSubTaskIds()) {
            storageSubTask.remove(id);
        }
        storageEpic.remove(ID);
    }

    public HashMap<Integer, Epic> getAllEpic() {
        return storageEpic;
    }

    public Epic getEpicByID(int ID) {
        return storageEpic.get(ID);
    }

    public void createNewSubTask(SubTask subTask) {
        int id = genTaskId();
        Epic epic = storageEpic.get(subTask.getEpicId());

        storageSubTask.put(id, subTask);
        subTask.setTaskID(id);
        epic.setSubTaskIds(id);
        updateStatus(epic);
    }

    public void updateSubTask(SubTask subTask) {
        storageSubTask.put(subTask.getTaskID(), subTask);
        Epic epic = storageEpic.get(subTask.getEpicId());
        updateStatus(epic);
    }

    public void delAllSubTask() {
        storageSubTask.clear();
        for (Epic epic : storageEpic.values()) {
            epic.setStatus(Status.NEW);
        }
    }

    public void delSubTaskByID(Integer ID) {
        Epic epic = storageEpic.get(storageSubTask.get(ID).getEpicId());

        storageSubTask.remove(ID);
        epic.getSubTaskIds().remove(ID);
        updateStatus(epic);
    }

    public HashMap<Integer, SubTask> getAllSubTask() {
        return storageSubTask;
    }

    public SubTask getSubTaskByID(int id) {
        return storageSubTask.get(id);
    }

    public void updateStatus(Epic epic) {
        if (epic.getSubTaskIds().size() == 0) {
            epic.setStatus(Status.NEW);
            return;
        }

        boolean isEpicNew = true;
        boolean isEpicDone = true;
        for (int id : epic.getSubTaskIds()) {
            if (storageSubTask.get(id).getStatus() != Status.NEW) {
                isEpicNew = false;
            }
            if (storageSubTask.get(id).getStatus() != Status.DONE) {
                isEpicDone = false;
            }
        }

        if (isEpicNew) {
            epic.setStatus(Status.NEW);
        } else if (isEpicDone) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }
}
