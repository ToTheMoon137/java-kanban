import manager.TaskManager;
import status.Status;
import tasks.Epic;
import tasks.SubTask;
import tasks.Task;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");
        test();
    }

    public static void test() {
        TaskManager taskManager = new TaskManager();
        taskManager.createNewTask(new Task("Закончить спринт 4", "Осталось совсем немного",
                Status.IN_PROGRESS));

        taskManager.createNewTask(new Task("Закончить спринт 5", "Придется постараться",
                Status.NEW));

        taskManager.createNewEpic(new Epic("Покупки", "Скоро будет вечеринка надо подготовится"));
        taskManager.createNewSubTask(new SubTask("Купить колбаски", "копченую",
                Status.DONE, 3));
        taskManager.createNewSubTask(new SubTask("Купить соку", "доброго", Status.DONE, 3));

        taskManager.createNewEpic(new Epic("Учить английский язык",
                "Пригодится в будующей профессии"));
        taskManager.createNewSubTask(new SubTask("Повторить тему present continuous", "2 часа",
                Status.IN_PROGRESS, 6));

        System.out.println(taskManager.getAllTask());
        System.out.println(taskManager.getAllEpic());
        System.out.println(taskManager.getAllSubTask());

        System.out.println();
        taskManager.delTaskByID(2);
        System.out.println(taskManager.getAllTask());

        taskManager.delEpicByID(3);
        System.out.println(taskManager.getAllEpic());
        System.out.println(taskManager.getAllSubTask());
    }
}
