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
    vector<double> averageOfLevels(TreeNode* root) {
        queue<TreeNode *> q;
        q.push(root);
        vector<double> ans;
        while(!q.empty()){
            int k = q.size();
            int size = q.size();
            double a = 0.00000;
            while(k--){
                TreeNode *t = q.front();
                q.pop();
                a += t->val;
                if(t->left) q.push(t->left);
                if(t->right)q.push(t->right);
            }
            ans.push_back(a/size);
        }
        return ans;
    }
};