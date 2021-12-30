package lesson6;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int quantity = 20;

        List<TreeImpl> treeList = new ArrayList<>();
        while (treeList.size() < quantity) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            makeTree(tree);
            treeList.add(tree);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println("Дерево №" + i + ". Балансировка: " + isBalanced(treeList.get(i).getRoot()));
            treeList.get(i).display();
        }
    }

    public static void makeTree(Tree<Integer> tree) {
        int min = -25;
        int max = 25;
        int value;
        int count = 0;

        max -= min;
        max++;

        while (count < 20) {
            value = (int) (Math.random() * max) + min;
            tree.add(value);
            count++;
        }
    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
