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
public:
    vector<int> inorderTraversal(TreeNode* root) {
       vector<int> v;
        if(root==NULL)return v;
        traversal(root,v);
        return v;
        
    }
    void traversal(TreeNode * root,vector<int> &v)
    {
        if(root==NULL)return;
        traversal(root->left,v);
        v.push_back(root->val);
        traversal(root->right,v);
    }
};