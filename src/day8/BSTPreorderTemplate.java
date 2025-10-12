package day8;

import java.util.*;

public class BSTPreorderTemplate {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    "\n}";
        }
    }

    // Insert value into BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Preorder traversal (DFS)
    //There are 3 types of traversals:
    //Preorder: Root-Left-Right   (50, 30, 20, 40, 70, 60, 80)
    //InOrder: Left-Root-Right    (20, 30, 40, 50, 60, 70, 80)
    //PostOrder: Left-Right-Root  (20, 40, 30, 60, 80, 70, 50)
    public static void preorderDFSRight(TreeNode root) {
        Stack<TreeNode> traversalStack = new Stack<>();
        traversalStack.push(root);
        while (!traversalStack.isEmpty()) {
            TreeNode temp = traversalStack.pop();
            if (Objects.nonNull(temp)) {
                //Push right first, then left — ensures left subtree is processed before right.
                traversalStack.push(temp.right);
                traversalStack.push(temp.left);
                System.out.print(temp.val+"\t");
            }
        }

    }

    public static void reversePreorderDFSLeft(TreeNode root) {
        Stack<TreeNode> traversalStack = new Stack<>();
        traversalStack.push(root);
        while (!traversalStack.isEmpty()) {
            TreeNode temp = traversalStack.pop();
            if (Objects.nonNull(temp)) {
                //Push left first, then right — ensures right subtree is processed before left.
                traversalStack.push(temp.left);
                traversalStack.push(temp.right);
                System.out.print(temp.val+"\t");
            }
        }

    }


    public static void levelOrderNodeTraversalBFSRight(TreeNode root) {
        Queue<TreeNode> traversalQueue = new LinkedList<>();
        traversalQueue.offer(root);
        while (!traversalQueue.isEmpty()) {
            TreeNode temp = traversalQueue.poll();
            if (Objects.nonNull(temp)) {
                traversalQueue.offer(temp.right);
                traversalQueue.offer(temp.left);
                System.out.print(temp.val+"\t");
            }
        }

    }

    public static void levelOrderNodeTraversalBFSLeft(TreeNode root) {
        Queue<TreeNode> traversalQueue = new LinkedList<>();
        traversalQueue.offer(root);
        while (!traversalQueue.isEmpty()) {
            TreeNode temp = traversalQueue.poll();
            if (Objects.nonNull(temp)) {
                traversalQueue.offer(temp.left);
                traversalQueue.offer(temp.right);
                System.out.print(temp.val+"\t");
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        // Build BST
        for (int val : values) {
            root = insert(root, val);
        }
        System.out.println(root);
        // Call preorder traversal
        reversePreorderDFSLeft(root);
        System.out.println("\n");
        // Call preorder traversal
        preorderDFSRight(root);


        System.out.println("\n\nBFS");
        levelOrderNodeTraversalBFSRight(root);
        System.out.println("\n");
        levelOrderNodeTraversalBFSLeft(root);

    }
}
/**
       50
      /  \
    30    70
   / \    / \
 20  40  60  80
 *
 * */