package util;

public class TreeNode <T> {
    public T val;
    public static TreeNode left;
    public static TreeNode right;

    public TreeNode(T x) {
        val = x;
        left=null;
        right=null;
    }

}
