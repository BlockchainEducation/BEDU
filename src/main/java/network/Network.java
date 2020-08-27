package network;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Network {
    private static final int MAX_THREAD_POOL = 100;
    public static final Map<String, NetworkListener> Listeners = new HashMap<>();

    public static void AddListener(String nodeId, NetworkListener listener) {
        Listeners.put(nodeId, listener);
    }
    public static void RemoveListener(String nodeId) {
        Listeners.remove(nodeId);
    }

    private static <T> void CallEvent(String from, String to, T message) {
        if (!Listeners.containsKey(to)) return ;

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD_POOL);

        NetworkListener listener = Listeners.get(to);

        executorService.execute(() -> listener.listen(from, message));
        executorService.shutdown();
    }
    public static <T> void Send(String from, String to, T message) {
        CallEvent(from, to, message);
    }
    public static <T> void Broadcast(String from, List<String> toList, T message) {
        for (String to : toList)
            CallEvent(from, to, message);
    }
}
