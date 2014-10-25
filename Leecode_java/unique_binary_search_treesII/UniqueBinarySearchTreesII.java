// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

public class Solution {

	// Recursion...
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateSubTrees(1, n);
    }

    public ArrayList<TreeNode> generateSubTrees(int l, int r){
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	if(l > r) 
    		result.add(null);
    	else {
    		for(int i = l; i <= r; i++){
    			ArrayList<TreeNode> lefts = generateSubTrees(l, i - 1);
    			ArrayList<TreeNode> rights = generateSubTrees(i + 1, r);
    			for (TreeNode left : lefts) {  
		       		for (TreeNode right : rights) {  
		           		TreeNode root = new TreeNode(i);  
		           		root.left = left;  
		           		root.right = right;  
		           		result.add(root);  
		           	}  
		       	}  
    		}
    	}
    	return result;	
    }

    // DP : 
}