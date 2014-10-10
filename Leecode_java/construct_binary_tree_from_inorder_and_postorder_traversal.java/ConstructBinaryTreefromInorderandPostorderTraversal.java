public class Solution {
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        return buildTree(int[] preorder, int[] inorder, postorder.length - 1, 0, inorder.length - 1)
    }
    public TreeNode buildTree(int[] postorder, int[] inorder, int poststart, int instart, int inend){
        if(poststart < 0 || instart > inend)  return null;

        TreeNode root = new TreeNode(postorder[poststart]);
        int inroot = 0;
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == postorder[poststart])
                inroot = i;
        }

        root.right = buildTree(poststart, inorder, poststart - 1, inroot + 1, inend);
        root.left = buildTree(poststart, inorder, poststart - (inend - inroot) - 1, instart, inroot - 1);

        return root;
    }
    
}