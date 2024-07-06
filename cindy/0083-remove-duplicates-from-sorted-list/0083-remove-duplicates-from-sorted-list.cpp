/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == NULL) {
            return head;
        }
        
        int check = head->val;
        ListNode* prev = head;
        ListNode* cur = head->next;
        
        while(cur != NULL) {
            if (check == cur->val) {
                if (cur->next != NULL) {
                    prev->next = cur->next;
                    cur = cur->next;
                }
                else {
                    prev->next = NULL;
                    return head;
                }
            }
            else {
                if (cur->next != NULL) {
                    prev = cur;
                    cur = cur->next;
                    check = prev->val;
                }
                else {
                    return head;
                }
            }
        }
        
        return head;
    }
};