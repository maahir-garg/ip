package thebotfather.command;

import thebotfather.util.Storage;
import thebotfather.util.TaskList;
import thebotfather.util.TheBotFatherException;
import thebotfather.util.Ui;

public class MarkCommand extends Command {

    private final int index;
    private final boolean isDone;

    public MarkCommand(String stringIndex, boolean isDone) throws TheBotFatherException {
        try {
            this.index = Integer.parseInt(stringIndex) - 1;
        } catch (NumberFormatException e) {
            throw new TheBotFatherException("How do you not know what a number is, jeez\n" +
                    "\tTo mark/unmark a task enter \"mark/unmark <index>\"");
        }
        this.isDone = isDone;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws TheBotFatherException {
        if (isDone) {
            taskList.markAsDone(index);
            ui.printMarked(taskList.getTaskDescAtIndex(index));
        } else {
            taskList.unmark(index);
            ui.printUnmarked(taskList.getTaskDescAtIndex(index));
        }
        storage.toFile(taskList);

    }
}
