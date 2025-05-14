package diary.event;

import diary.core.Entry;

import java.util.ArrayDeque;
import java.util.Deque;

public class EventQueue {
    private final Deque<Entry> recentEvents = new ArrayDeque<>();

    public void record(Entry entry) {
        if (recentEvents.size() == 10) {
            recentEvents.removeFirst();
        }
        recentEvents.addLast(entry);
    }

    public Deque<Entry> getRecentEvents() {
        return new ArrayDeque<>(recentEvents);
    }
}
