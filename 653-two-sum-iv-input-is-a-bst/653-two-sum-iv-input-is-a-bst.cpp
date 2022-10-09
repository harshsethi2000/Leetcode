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
    unordered_set<int> *s = new  unordered_set<int>();
public:
    bool findTarget(TreeNode* root, int k) {
        if(root == NULL)
            return false;
        
        if(findTarget(root->left, k)) return true;
        int value = k- root->val;
        if(s->find(value)!=s->end()){
            cout<<"Here value is "<<value<< " "<< root->val<<endl;
            return true;
        }
        s->insert(root->val);
        if(findTarget(root->right,k)) return true;
        return false;
    }
};