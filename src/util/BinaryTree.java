package util;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public static TreeNode head;
    private static List<TreeNode> arrayList = new ArrayList<>();
    private static int completeParentNum = 0;
    private static boolean leftNull = true;
    private static boolean rightNull = true;

    private static int treeSize = 0;

    public BinaryTree(Integer n) {
        TreeNode treeNode = new TreeNode(n);
        head = treeNode;
        arrayList.add(head);
        treeSize++;
    }

    public static void add(Integer n) {
        TreeNode treeNode = new TreeNode(n);
        arrayList.add(treeNode);
        treeSize++;
        TreeNode parent = arrayList.get(completeParentNum);
        if (treeNode.val != null) {
            if (leftNull) {
                parent.left = treeNode;
                leftNull = false;
            } else if (rightNull) {
                parent.right = arrayList.get(completeParentNum);
                rightNull = false;
            }
        }

        if((leftNull==false && rightNull==false )||treeNode.val == null){
            completeParentNum++;
            leftNull=true;
            rightNull=true;
        }
    }

    public static void printTree() {
        if (treeSize == 0) {
            System.out.println("The tree is empty");
        }
        printTreeRec(head);
    }

    private static TreeNode printTreeRec(TreeNode treeNode) {
        if(treeNode==null){
            return null;
        }
        System.out.println(printTreeRec(treeNode.left).val);
        System.out.println(treeNode.val);
        System.out.println(printTreeRec(treeNode.right).val);

        return treeNode;
    }


}
