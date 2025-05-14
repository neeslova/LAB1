package diary.ui;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Map<String, String> options;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.options = new LinkedHashMap<>();
        options.put("1", "Добавить запись");
        options.put("2", "Удалить запись");
        options.put("3", "Просмотреть записи");
        options.put("4", "Выход");
    }

    public void display() {
        System.out.println("\nВыберите команду:");
        for (Map.Entry<String, String> entry : options.entrySet()) {
            System.out.printf("%s. %s%n", entry.getKey(), entry.getValue());
        }
    }

    public String getUserChoice() {
        System.out.print("Введите номер команды: ");
        return scanner.nextLine();
    }

    public boolean isExitChoice(String choice) {
        return "4".equals(choice);
    }
}
