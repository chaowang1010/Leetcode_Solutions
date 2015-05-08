public class BinaryTreeLevelOrderTraversalII{
    
    public class Solution {
        public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            search(root, 0 , result);
            Collections.reverse(result);
            return result;
        }
        
        public void search(TreeNode root, int level, ArrayList<ArrayList<Integer>> result){
            if(root == null) return;
            
            if(level >= result.size()){
                result.add(new ArrayList<Integer>());
            }
            
            result.get(level).add(root.val);
            
            search(root.left, level + 1, result);
            search(root.right, level + 1, result);
        }
    }
}