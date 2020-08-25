package database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Database {
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    public Bucket getBucket(String bName) {
        Bucket b = buckets.get(bName);
        if(b == null) {
            buckets.put(bName, new Bucket());
        }
        return b;
    }
}
