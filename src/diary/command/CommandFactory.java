package diary.command;

import diary.core.Diary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandFactory {
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandFactory(Diary diary, Scanner scanner) {
        commandMap.put("1", new AddEntryCommand(diary, scanner));
        commandMap.put("2", new RemoveEntryCommand(diary, scanner));
        commandMap.put("3", new ViewEntriesCommand(diary));
        commandMap.put("4", new ExitCommand());
    }

    public Command getCommand(String choice) {
        return commandMap.get(choice);
    }
}
