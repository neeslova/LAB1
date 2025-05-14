package diary.command;

import diary.core.Diary;
import diary.core.Entry;

import java.util.List;
import java.util.Scanner;

public class RemoveEntryCommand implements Command {
    private final Diary diary;
    private final Scanner scanner;

    public RemoveEntryCommand(Diary diary, Scanner scanner) {
        this.diary = diary;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        List<Entry> entries = diary.getEntries();
        if (entries.isEmpty()) {
            System.out.println("Записей нет.");
            return;
        }

        for (int i = 0; i < entries.size(); i++) {
            System.out.printf("%d: %s%n", i, entries.get(i));
        }

        System.out.print("Введите номер записи для удаления: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (diary.removeEntry(index)) {
            System.out.println("Запись удалена.");
        } else {
            System.out.println("Неверный индекс.");
        }
    }
}
