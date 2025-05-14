package diary.core;

import diary.event.EventQueue;

import java.time.LocalDate;
import java.util.*;

public class Diary {
    private final List<Entry> entries = new ArrayList<>();
    private final EventQueue eventQueue = new EventQueue();

    public void addEntry(String text, LocalDate date) {
        Entry entry = new Entry(text, date);
        entries.add(entry);
        eventQueue.record(entry);
    }

    public boolean removeEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            entries.remove(index);
            return true;
        }
        return false;
    }

    public List<Entry> getEntries() {
        return new ArrayList<>(entries);
    }

    public Iterator<Entry> futureEntries(LocalDate fromDate) {
        return new EntryIterator(entries, fromDate);
    }

    public Deque<Entry> getRecentEvents() {
        return eventQueue.getRecentEvents();
    }
}
