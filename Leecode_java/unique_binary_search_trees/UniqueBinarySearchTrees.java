// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

// For example,
// Given n = 3, there are a total of 5 unique BST's.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

public class Solution {

	// count(k) = sum_{i=0}^(k-1) (count(i)*count(k-1-i))
    public int numTrees(int n) {
        if(n == 0) return 0;
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
		for(int k = 2; k <= n; k++){
			for(int i = 0; i < k; i ++){
				count[k] += count[i] * count[k - 1 -i];
        	}
		}
        return count[n];
    }
}