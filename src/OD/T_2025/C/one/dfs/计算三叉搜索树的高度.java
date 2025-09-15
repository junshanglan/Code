package OD.T_2025.C.one.dfs;

import java.util.Scanner;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode middle;
    TreeNode right;
    TreeNode(){

    }

    TreeNode(int value){
        this.value = value;
        this.left =  null;
        this.middle =  null;
        this.right =  null;
    }
}

/**
 * 模拟数的生成，注意递归边界
 */
public class 计算三叉搜索树的高度 {

    public static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root,scanner.nextInt(),1);
        }
        System.out.println(res);
    }

    public static TreeNode insert(TreeNode tree,int value,int height){
        // 插入到末尾节点，可能会涉及到高度变化
        if (tree == null){
            res = Math.max(res,height);
            return new TreeNode(value);
        }
        if (value < tree.value - 500){
            tree.left = insert(tree.left,value,height + 1);
        }else if (value > tree.value + 500){
            tree.right = insert(tree.right,value,height + 1);
        }else{
            tree.middle = insert(tree.middle,value,height + 1);
        }
        return tree;
    }
}
