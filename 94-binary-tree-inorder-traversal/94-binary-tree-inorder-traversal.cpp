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
//Iterative Solution
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
       vector<int> v;
        if(root==NULL)return v;
        stack<TreeNode *> s;
        for(TreeNode *t=root;t!=NULL;t=t->left)s.push(t);
        while(!s.empty())
        {
         TreeNode *tmp=s.top();
            s.pop();
            v.push_back(tmp->val);
            if(tmp->right!=NULL)
            {
                for(TreeNode *t=tmp->right;t!=NULL;t=t->left)s.push(t);        
            }
        }
        return v;
        
    }
   
};
//Method 2-
// Recursive Solution

// class Solution {
// public:
//     vector<int> inorderTraversal(TreeNode* root) {
//        vector<int> v;
//         if(root==NULL)return v;
//         traversal(root,v);
//         return v;
        
//     }
//     void traversal(TreeNode * root,vector<int> &v)
//     {
//         if(root==NULL)return;
//         traversal(root->left,v);
//         v.push_back(root->val);
//         traversal(root->right,v);
//     }
// };
