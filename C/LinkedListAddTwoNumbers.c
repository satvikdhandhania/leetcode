/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* newNode(int val){
    struct ListNode* temp = (struct ListNode*) malloc(sizeof(struct ListNode));
    if(temp == NULL){
        exit(0);
    }
    temp->val = val;
    temp-> next = NULL;
    return temp;
}
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    
    struct ListNode* result = NULL;
    struct ListNode* end = NULL;
    if(l1 == NULL){
        return l2;
    }
    
    if(l2 == NULL){
        return l1;
    }
    
    int sum = 0;
    while((l1!= NULL) && (l2!=NULL)){
        sum += l1->val + l2->val;
        struct ListNode* temp = newNode(sum%10);
        if(sum > 9){
            sum = 1;
        } else {
            sum = 0;
        }
        if(result == NULL){
            result = temp;
            end = temp;
        } else {
            end->next = temp;
            end = temp;
        }
        l1 = l1->next;
        l2 = l2->next;
    }
    
    while(l1!= NULL){
        sum += l1->val;
        struct ListNode* temp = newNode(sum%10);
        if(sum > 9){
            sum = 1;
        } else {
            sum = 0;
        }
        end->next = temp;
        end = temp;
    }
    
    while(l2!= NULL){
        sum += l2->val;
        struct ListNode* temp = newNode(sum%10);
        if(sum > 9){
            sum = 1;
        } else {
            sum = 0;
        }
        end->next = temp;
        end = temp;
    }
    
    if(sum!=0){
        struct ListNode* temp = newNode(sum);
        end->next = temp;
    }
    return result;
}
