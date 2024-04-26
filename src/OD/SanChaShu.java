package OD;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-04-26
 * @Author：landaguo
 */
public class SanChaShu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.addNode(data);
        }
        System.out.println(tree.height);
    }

    static class TreeNode{
        int val;
        int height;
        TreeNode left;
        TreeNode middle;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tree{
        TreeNode root;
        int height;

        private void addNode(int val){
            // 初始化一个节点
            TreeNode node = new TreeNode(val);
            if (this.root == null) {
                node.height = 1;
                this.height = 1;
                this.root = node;
            }else {
                TreeNode currentNode = this.root;
                while (true) {
                    node.height = currentNode.height + 1;
                    this.height = Math.max(node.height,this.height);
                    if (val < currentNode.val - 500) {
                        // 如果左子树为空，则将当前节点置为左节点
                        if (currentNode.left == null) {
                            currentNode.left = node;
                            break;
                        }else{
                            currentNode = currentNode.left;
                        }
                    }else if (val > currentNode.val + 500){
                        if (currentNode.right == null) {
                            currentNode.right = node;
                            break;
                        }else{
                            currentNode = currentNode.right;
                        }
                    }else{
                        if (currentNode.middle == null){
                            currentNode.middle = node;
                            break;
                        }else{
                            currentNode = currentNode.middle;
                        }
                    }
                }
            }

        }
    }

}
