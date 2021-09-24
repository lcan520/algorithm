

import data_structure.RedBlackTree;
import org.junit.jupiter.api.Test;


class RedBlackTreeTest {

    private final RedBlackTree redBlackTree = new RedBlackTree();


    @Test
    void remove() {
        redBlackTree.remove(1);
    }

    @Test
    void put() {
        redBlackTree.put(1);
    }
}