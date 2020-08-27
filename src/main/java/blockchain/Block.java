package blockchain;

public interface Block {
    String getPrevBlockHash();
    String getHash();
    int getHeight();
}
