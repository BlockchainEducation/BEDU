package blockchain;

public interface Blockchain {
    boolean addBlock(Block block);
    Block findBlock(String hash);

    String getLastBlockHash();
    int getHeight();
}
