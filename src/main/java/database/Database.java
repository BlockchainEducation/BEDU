package database;

import java.util.concurrent.ConcurrentHashMap;

public class Database {
    private static ConcurrentHashMap<String, Bucket> bucket = new ConcurrentHashMap();

    public static Bucket getBucket(String bName) {
        Bucket b = bucket.get(bName);
        if(b == null) {
            bucket.put(bName, new Bucket());
        }
        return b;
    }
}
