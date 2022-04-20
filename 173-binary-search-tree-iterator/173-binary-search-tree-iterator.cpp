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

// push extreme left to stack
// while(stack!empty)
// {
//     pop and print
//     push element right to extreme left
// }

class BSTIterator {
public:
    stack<TreeNode *> s; 
    BSTIterator(TreeNode* root) {
       for(TreeNode *t=root;t!=NULL;t=t->left)s.push(t);
    }    
    int next() {
       TreeNode *t=s.top();
        s.pop();
        if(t->right!=NULL)for(TreeNode *tmp=t->right;tmp!=NULL;tmp=tmp->left)s.push(tmp);
        return t->val;
        
    }
    
    bool hasNext() {
        return s.empty()==false;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */