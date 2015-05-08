// Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

// For example:
// Given a binary tree {1,2,3,4,5},
// 1
// / \
// 2 3
// / \
// 4 5

// return the root of the binary tree [4,5,2,#,#,3,1].
// 4
// / \
// 5 2
// / \
// 3 1

// [分析]
// 起始对于每一个节点，相应的操作为：
// p.left = parent.right;
// p.right = parent;

// 第一句话“Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty”表明这个树是有着很强的限制条件的。也正是基于这样一个基础，一个简单的while循环就可以搞定这道题。

// [注意事项]
// 1）两个copy：parent node 和 parent’s right child

// [Code]

public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode p = root, parent = null, parentRight = null;
        while (p!=null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right ＝ parent;
            parent = p;
            p = left;
        }
        return parent;
    }
}