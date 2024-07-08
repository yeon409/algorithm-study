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
bool ans = true;

void inorder(TreeNode* p, TreeNode* q) {
    if (p && q) {
        inorder(p->left, q->left);
        if (p->val != q->val) {
            ans = false;
            return;
        }
        inorder(p->right, q->right);
    }
    else if (p || q) {
        ans = false;
        return;
    }
};

class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        ans = true;
        if (p == nullptr && q == nullptr) return ans;
        
        inorder(p, q);
        return ans;
    }
};