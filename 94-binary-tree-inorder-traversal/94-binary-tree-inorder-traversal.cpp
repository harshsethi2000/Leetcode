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
// class Solution {
// public:
//     vector<int> inorderTraversal(TreeNode* root) {
//         vector<int> ans;
//         if(root==NULL)return ans;
//         inorder(root,ans);
//         return ans;
//     }
//     void inorder(TreeNode * root,vector<int> & ans)
//     {
//         if(root==NULL)return;
//         inorder(root->left,ans);
//         ans.push_back(root->val);
//         inorder(root->right,ans);
//     }
// };

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        if(root==NULL)return ans;
        stack<TreeNode *> s;
        for(TreeNode *t=root;t!=NULL;t=t->left)s.push(t);
        while(!s.empty())
        {
            TreeNode *t=s.top();
            s.pop();
            ans.push_back(t->val);
            if(t->right!=NULL)
            {
                for(TreeNode *tmp=t->right;tmp!=NULL;tmp=tmp->left)s.push(tmp);        
            }
        }
        return ans;
    }
};

