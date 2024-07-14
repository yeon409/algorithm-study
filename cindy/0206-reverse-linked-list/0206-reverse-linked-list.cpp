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
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }

        ListNode* cur = head;
        ListNode* prev = nullptr;
        ListNode* next = head->next;

        while (cur != nullptr) {
            cur->next = prev;
            prev = cur;
            cur = next;
            if (next == nullptr) {
                break;
            }
            next = next->next;
        }
        return prev;
    }
};