package network;

public interface NetworkListener {
    <T> void listen(String from, T message);
}
