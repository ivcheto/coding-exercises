package exercises.crackingthecodinginterview.treesandgraphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {

    BinarySearchTree tree;

    @BeforeEach
    public void setup() {
        tree = new BinarySearchTree();
    }

    @Test
    public void create_basic_tree() {
       int[] arr = {1, 2, 3, 4, 5};

       tree.createTree(arr);

       checkArray(tree.inOrderTraversal(), arr);
       tree.printTree();
    }

    @Test
    public void handles_null() {
        tree.createTree(null);
    }

    @Test
    public void handles_empty_array() {
        tree.createTree(new int[0]);

        assertEquals(0, tree.inOrderTraversal().size());
    }

    @Test
    public void handles_array_with_one_element() {
        int[] arr = {1};
        tree.createTree(arr);

        List<Integer> res = tree.inOrderTraversal();
        assertEquals(1, res.size());
        assertEquals(0, res.get(0).compareTo(1));
    }

    @Test
    public void create_basic_tree2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        tree.createTree(arr);

        checkArray(tree.inOrderTraversal(), arr);
        tree.printTree();
    }

    public void checkArray(List<Integer> res, int[] expected) {
        assertEquals(res.size(), expected.length);
        int i = 0;
        for(Integer cur: res) {
            assertEquals(0, cur.compareTo(expected[i]));
            i++;
        }
    }
}
