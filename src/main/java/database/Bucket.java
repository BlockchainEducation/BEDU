package database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bucket {
    private final Map<String, Object> db = new ConcurrentHashMap<>();

    public void put(String key, Object value){
        db.put(key, value);
    }
    public Object get(String key) {
        return db.get(key);
    }
    public void delete(String key) {
        db.remove(key);
    }
    public void clear() { db.clear(); }

    public Cursor cursor() {
        return new Cursor(db);
    }

}