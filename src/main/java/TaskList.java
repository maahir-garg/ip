import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArrayList;
    protected static int COUNT = 0;

    public TaskList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    protected void addTask(Task task) {
        taskArrayList.add(task);
        COUNT++;
    }

    public String getListDesc() throws TheBotFatherException {
        int size = taskArrayList.size();
        if (size < 1) throw new TheBotFatherException("How do I print what is not there?");
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(i + 1 + ". " + taskArrayList.get(i) + "\n");
        }
        return string.toString();
    }

    public void markAsDone(int index) throws TheBotFatherException {
        try {
            Task task = taskArrayList.get(index);
            if (!task.isDone()) COUNT--;
            task.markAsDone();
        } catch (IndexOutOfBoundsException e) {
            throw new TheBotFatherException("To be a real man you need to know how to count, you don't even have those many tasks son.\n" +
                    "\tTo mark a task as done enter \"mark <index>\"");
        }
    }

    public void unmark(int index) throws TheBotFatherException {
        try {
            Task task = taskArrayList.get(index);
            if (task.isDone()) COUNT++;
            task.unmark();
        } catch (IndexOutOfBoundsException e) {
            throw new TheBotFatherException("To be a real man you need to know how to count, you don't even have those many tasks son.\n" +
                    "\tTo unmark a task enter \"unmark <index>\"");
        }
    }

    public Task delete(int index) throws TheBotFatherException {
        try {
            Task task = taskArrayList.get(index);
            taskArrayList.remove(index);
            COUNT--;
            return task;
        } catch (IndexOutOfBoundsException e) {
            throw new TheBotFatherException("To be a real man you need to know how to count, you don't even have those many tasks son.\n" +
                    "\tTo delete a task enter \"delete <index>\"");
        }
    }

    public String toFile() {
        StringBuilder dataInFile = new StringBuilder();
        for (Task task : taskArrayList) {
            dataInFile.append(task.toFile() + System.lineSeparator());
        }

        return dataInFile.toString();
    }

    protected String getTaskDescAtIndex(int index) {
        return taskArrayList.get(index).toString();
    }
}
