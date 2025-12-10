/**
 * Problem Statement: Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e. from left to right, then right to left for the next level and alternate between).
 *
 * Approach:
 * We can solve this problem using Breadth-First Search (BFS). We will traverse the tree level by level.
 * We will use a queue to store the nodes at each level. We will also maintain a boolean variable to
 * keep track of the direction of traversal for the current level (left to right or right to left).
 * For each level, we will process all the nodes in the queue and store their values in a temporary list.
 * If the traversal direction for the current level is right to left, we will reverse the temporary list before adding it to the result.
 *
 * Time Complexity: O(N), where N is the number of nodes in the binary tree, as we visit each node exactly once.
 *
 * Space Complexity: O(W), where W is the maximum width of the binary tree, as the queue can hold at most W nodes at any level. In the worst case (a complete binary tree), W can be up to N/2.
 *
 * Optimal Solution: The approach described above is already optimal in terms of time and space complexity for this problem.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (!leftToRight) {
                java.util.Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
