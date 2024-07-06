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
vector<int> ans;

void inorder(TreeNode* cur) {    
    if (cur) {
        inorder(cur->left);
        ans.push_back(cur->val);
        inorder(cur->right);
    }
};

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        ans.clear();
        inorder(root);
        
        return ans;
    }
};