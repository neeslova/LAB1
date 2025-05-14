package diary.command;

import diary.core.Diary;
import diary.core.Entry;

public class ViewEntriesCommand implements Command {
    private final Diary diary;

    public ViewEntriesCommand(Diary diary) {
        this.diary = diary;
    }

    @Override
    public void execute() {
        System.out.println("Список записей:");
        for (Entry entry : diary.getEntries()) {
            System.out.println(entry);
        }
    }
}
