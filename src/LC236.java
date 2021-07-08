import util.BinaryTree;
import util.TreeNode;

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);

        if(left==null && right == null){
            return null;
        }else if(left ==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }

    }

    public static void main(String[] args) {
        BinaryTree binaryTree= new BinaryTree(37);
        binaryTree.add(-34);
        binaryTree.add(-48);
        binaryTree.add(null);
        binaryTree.add(-100);
        binaryTree.add(-101);
        binaryTree.add(48);
        binaryTree.add(null);
        binaryTree.add(null);
        binaryTree.add(null);
        binaryTree.add(null);
        binaryTree.add(-54);
        binaryTree.add(null);
        binaryTree.add(-71);
        binaryTree.add(-22);
        binaryTree.add(null);
        binaryTree.add(null);
        binaryTree.add(null);
        binaryTree.add(8);

        binaryTree.printTree();


        //This is how to call a non-static class in a static class
//        TreeNode res = new LC236().lowestCommonAncestor(binaryTree.head,new TreeNode(-71),new TreeNode(8) );

//        System.out.println(res.val);
    }
}

