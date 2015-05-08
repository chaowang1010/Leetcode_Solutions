public class BinaryTreeZigzagLevelOrderTraversal{
	
	public class Solution {
	    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) 
        {
            ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
            travel(root, sol, 0);
            return sol;
        }
    
        private void travel(TreeNode curr, ArrayList<ArrayList<Integer>> sol, int level)
        {
            if(curr == null) return;
    
            if(sol.size() <= level)
            {
                ArrayList<Integer> newLevel = new ArrayList<Integer>();
                sol.add(newLevel);
            }
    
            ArrayList<Integer> collection  = sol.get(level);
            if(level % 2 == 0) collection.add(curr.val);
            else collection.add(0, curr.val);
    
            travel(curr.left, sol, level + 1);
            travel(curr.right, sol, level + 1);
        }
}