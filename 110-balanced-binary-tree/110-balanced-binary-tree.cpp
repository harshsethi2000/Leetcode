/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    // A balanced BT is a tree whose diff. of leftHeight - rightHeight is always
//less than one for every node
    
    //Naive approach
    //for each node we will find leftChildHeight and rightChild Height
    //and will compare if for any (rch-lch)>1 return false
    
public:
    int getHeight(TreeNode * root){
        if(root == NULL)return 0;
        return max(getHeight(root->left), getHeight(root->right)) + 1;
    }
    bool isBalanced(TreeNode* root) {
        if(root == NULL)
                return true;
        int lh = getHeight(root->left);
        int rh = getHeight(root->right);
        if(abs(rh - lh) > 1)
            return false;
        bool la = isBalanced(root->left);
        bool ra = isBalanced(root->right);
        if(!la || !ra)
            return false;
        return true;
    }
};