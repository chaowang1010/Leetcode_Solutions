public class BinaryTreeLevelOrderTraversal{
	
	public class Solution {
	// Recursion
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        search(root, 0, result);
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

	// Iteration
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if(root == null) return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);  //queue operations
			 int nodesNextLevel = 0;
			 int nodesCurrLevel = 1;
			 int level = 0;
			 result.add(new ArrayList<Integer>());

			 while(!queue.isEmpty()){
			 	TreeNode curr = queue.poll();
			 	nodesCurrLevel --;
			 	if(curr != null){
			 		result.get(level).add(curr.val);
			 		if(curr.left!=null){
			 		    queue.offer(curr.left);
			 		    nodesNextLevel ++;
			 		}
			 		if(curr.right!=null){
			 		    queue.offer(curr.right);
			 		    nodesNextLevel ++;
			 		}
			 	}
			 	if(nodesCurrLevel == 0){
			 		nodesCurrLevel = nodesNextLevel;
			 		level ++;
			 		nodesNextLevel = 0;
			 		if(level >= result.size() && !queue.isEmpty()){    // be careful
						result.add(new ArrayList<Integer>());
					}
			 	}
			 }
			 return result;
		}
}