/*
Problem Description
You are given a binary tree. You need to count the number of balanced binary tree violations in the given tree.

Input format
Line 1: Number of nodes in the Binary Tree (N)

Line 2: N space separated node values. The position of the Nodes on this line will be used to refer to them in the below lines, starting from 1.

Line 3 to N+2: Lines specifying the child nodes for each of the N nodes


Format of each line (space separated): Parent_node Left_child_node Right_child_node

Parent_node - Node at this Position on Line 2 is the Node to which we are assigning the Left and Right child here

Left_child_node - Node at this position on Line 2 is the left child. Specify -1 if there is no Left child.

Right_child_node - Node at this position on Line 2 is the right child. Specify -1 if there is no Right child.

    2
   /\
  3 7
 /\
8 9  

Your input would be:
5           -> Number of Nodes
2 3 7 8 9   -> Node values
1 2 3       -> Node 1 (value 2) and its child nodes (left child value 3 and right child value 7)
2 4 5       -> Node 2 (value 3) and its child nodes (left child value 8 and right child value 9)
3 -1 -1     -> Node 3 (value 7) and its child nodes (left and right child are null i.e., leaf nodes)
4 -1 -1     -> Node 4 (value 8) and its child nodes (left and right child are null i.e., leaf nodes)
5 -1 -1     -> Node 5 (value 9) and its child nodes (left and right child are null i.e., leaf nodes)

Output format
Number of violations

Sample Input 1
10

7417 7225 94 8253 1406 9114 4643 3036 2097 1214

1 2 -1

2 3 4

3 -1 5

4 6 -1

5 -1 7

6 8 9

7 -1 10

8 -1 -1

9 -1 -1

10 -1 -1

Sample Output 1
4

Explanation 1
                    7417
                    /
    _______________7225_______________
   /                                  \
  94___                            ___8253
       \                          /
    1406                    __9114__
       \                   /        \
      4643               3036      2097
        \
        1214

1406 level there is balanced binary tree violation

94 level there is a balanced binary tree violation

8253 level there is balanced binary tree violation

7417 level there is balanced binary tree violation
4643 is not considered as per the definition of a balanced binary tree - at every node, the difference of height of left subtree and height of right subtree should not exceed more than 1.

Constraints
1 <= N <= 10000
*/

class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
    }
}

public class NumberOfBinaryTreeViolations {
    static int violations = 0;
    public int findNumberOfBtVoilations(TreeNode root) {
        violations = 0;
        maximumDepth(root);
        return violations;
    }

    int maximumDepth(TreeNode node)
    {
        if (node == null) {
            return 0;
        } else {
            int lDepth = maximumDepth(node.left);
            int rDepth = maximumDepth(node.right);
 
            if (Math.abs(lDepth - rDepth) > 1) {
                violations++;
            }

            if (lDepth > rDepth) {
                return (lDepth + 1);
            }
            else {
                return (rDepth + 1);
            }
        }
    }

}