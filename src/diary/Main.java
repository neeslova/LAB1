package diary;

import diary.command.*;
import diary.core.Diary;
import diary.ui.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Diary diary = new Diary();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        CommandFactory factory = new CommandFactory(diary, scanner);

        while (true) {
            menu.display();
            String choice = menu.getUserChoice();
            Command command = factory.getCommand(choice);

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Неверная команда. Попробуйте снова.");
            }

            if (menu.isExitChoice(choice)) {
                break;
            }
        }

        scanner.close();
    }
}
