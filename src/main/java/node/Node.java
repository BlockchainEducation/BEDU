package node;

import network.Network;
import network.NetworkListener;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements NetworkListener {
    protected final String nodeId;
    protected final List<String> connections = new ArrayList<>();

    public Node(String nodeId) {
        this.nodeId = nodeId;
    }

    public void open() {
        Network.AddListener(nodeId, this);
    }
    public void close() {
        Network.RemoveListener(nodeId);
    }

    public void connectTo(String to) {
        connections.add(to);
    }
    public void disconnectTo(String to) {
        connections.remove(to);
    }

    public String getNodeId() {
        return nodeId;
    }
}
