package diary.core;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class EntryIterator implements Iterator<Entry> {
    private final List<Entry> entries;
    private final LocalDate fromDate;
    private int index = 0;

    public EntryIterator(List<Entry> entries, LocalDate fromDate) {
        this.entries = entries;
        this.fromDate = fromDate;
        skipToFuture();
    }

    private void skipToFuture() {
        while (index < entries.size() && entries.get(index).getDate().isBefore(fromDate)) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < entries.size();
    }

    @Override
    public Entry next() {
        if (!hasNext()) throw new NoSuchElementException();
        return entries.get(index++);
    }
}
