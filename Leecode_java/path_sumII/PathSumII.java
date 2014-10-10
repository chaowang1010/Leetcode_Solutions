public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        pathSum(root, sum, curr, result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> result){
    	if(root == null) return;

    	if(root.left == null && root.right == null){
    		if(root.val == sum){
    			curr.add(root.val);
    			result.add(curr);
    			return;
    		}
    		return;
    	}

    	curr.add(root.val);
    	
    	// this is very tricky ... 
     	ArrayList<Integer> left = new ArrayList<Integer>(curr);
      	ArrayList<Integer> right = new ArrayList<Integer>(curr);
    	pathSum(root.left, sum - root.val, curr, result);
    	pathSum(root.right, sum - root.val, curr, result);
    	
        //curr.remove(curr.size() );
        
    	return;
    }
}