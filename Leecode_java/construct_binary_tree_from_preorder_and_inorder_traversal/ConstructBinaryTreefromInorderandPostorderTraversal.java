public class Solution {
    
    public int search(int[] inorder, int instart, int inend, int value){
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == value)
                return i;
        }
        return 0;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] postorder, int[] inorder,int postend, int poststart, int instart, int inend){
        if(poststart < postend || instart > inend)  return null;

        TreeNode root = new TreeNode(postorder[poststart]);
        int inroot = 0;
        inroot = search(inorder, instart, inend, postorder[poststart]);

        root.right = buildTree(postorder, inorder, postend + inroot - instart, poststart - 1, inroot + 1, inend);
        root.left = buildTree(postorder, inorder, postend, postend -(instart - inroot) - 1, instart, inroot - 1);

        return root;
    }
}