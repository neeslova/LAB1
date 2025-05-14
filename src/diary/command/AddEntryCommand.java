package diary.command;

import diary.core.Diary;

import java.time.LocalDate;
import java.util.Scanner;

public class AddEntryCommand implements Command {
    private final Diary diary;
    private final Scanner scanner;

    public AddEntryCommand(Diary diary, Scanner scanner) {
        this.diary = diary;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите дату (гггг-мм-дд): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите текст записи: ");
        String text = scanner.nextLine();
        diary.addEntry(text, date);
        System.out.println("Запись добавлена.");
    }
}
