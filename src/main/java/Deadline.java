public class Deadline extends Task{
    protected String deadline;

    public Deadline(String task, String deadline) {
        super(task);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString()+ " (by: " + this.deadline + ")";
    }
}
