package exercises.crackingthecodinginterview.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    private Node root;
    public void createTree(int[] arr) {
        if(arr != null) {
            root = helper(arr, 0, arr.length - 1);
        }
    }

    private Node helper(int[] arr, int start, int end) {
        Node root = null;
        if(start ==  end) {
            root = new Node(arr[start]);
        } else if(start < end) {
            int len = end - start;
            root = new Node(arr[start + len/2]);
            root.left = helper(arr, start, start + len/2 - 1);
            root.right = helper(arr, start + len/2 + 1, end);
        }
        return root;
    }

    public List<List<Node>> getNodesByLevel() {
        List<List<Node>> res = new ArrayList<>();
        List<Node> q = new LinkedList<>();
        q.add(root);
        int i = 0;
        int exp = 0;
        List<Node> curList = new ArrayList<>();
        res.add(curList);
        while(!q.isEmpty()) {
            Node cur = ((LinkedList<Node>) q).getLast(); /// todo fix this
            updateList(q, curList, cur);
            i++;
            if(Math.pow(2, exp) == i) {
                if(curList.isEmpty()) {
                    break;
                }
                res.add(curList);
                curList = new ArrayList<>();
                exp++;
                i = 0;
            }
        }
        return res;
    }

    private void updateList(List<Node> q, List<Node> list, Node cur) {
        if(cur != null) {
            q.add(cur.left);
            q.add(cur.right);
            list.add(cur);
        } else {
            q.add(null);
            q.add(null);
        }
    }

    public List<Integer> inOrderTraversal() {
        return inOrderHelper(root, new ArrayList<>());
    }

    private List<Integer> inOrderHelper(Node root, List<Integer> list) {
        if(root != null) {
            inOrderHelper(root.left, list);
            list.add(root.value);
            inOrderHelper(root.right, list);
        }
        return list;
    }


    public void printTree() {
        List<Node> q = new LinkedList<>();
        q.add(root);
        printNode(root);
        System.out.println();
        int exp = 1;
        int i = 0;
        while(!q.isEmpty()) {
            Node cur = q.remove(0);
            if(cur != null) {
                printNode(cur.left);
                i++;
                q.add(cur.left);
                printNode(cur.right);
                i++;
                q.add(cur.right);
                if(i == Math.pow(2, exp)) {
                    exp++;
                    i = 0;
                    System.out.println();
                }
            }
        }
        System.out.println('\n');
    }

    private void printNode(Node root) {
        if(root != null) {
            System.out.print(" " + root.value + " ");
        } else {
            System.out.print(" . ");
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
