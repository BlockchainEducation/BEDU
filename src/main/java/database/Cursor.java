package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.Pair;

public class Cursor {
    private final Map<String, Object> db;
    private final List<String> keys = new ArrayList<>();
    private int idx = -1;

    public Cursor(Map<String, Object> db) {
        this.db = db;
        keys.addAll(db.keySet());
    }

    public Pair<String, Object> head() {
        idx = 0;
        return new Pair<>(keys.get(idx), db.get(keys.get(idx)));
    }
    public Pair<String, Object> tail() {
        idx = keys.size()-1;
        return new Pair<>(keys.get(idx), db.get(keys.get(idx)));
    }

    public Pair<String, Object> next() {
        idx++;
        return new Pair<>(keys.get(idx), db.get(keys.get(idx)));
    }
    public Boolean hasNext() {
        return idx + 1 < keys.size();
    }

    public Pair<String, Object> get(int idx) {
        return new Pair<>(keys.get(idx), db.get(keys.get(idx)));
    }
}
