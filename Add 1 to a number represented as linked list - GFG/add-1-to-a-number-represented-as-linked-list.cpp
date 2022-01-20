// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h> 
using namespace std; 

struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
};

void printList(Node* node) 
{ 
    while (node != NULL) { 
        cout << node->data; 
        node = node->next; 
    }  
    cout<<"\n";
} 


 // } Driver Code Ends
//User function template for C++

/* 

struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
};

*/

class Solution
{
    public:
    Node* reverse(Node *head)
    {
        Node *prev,*curr;
        curr=head;
        prev=NULL;
        while(curr!=NULL)
        {
            Node *tmp=curr->next;
            curr->next=prev;
            prev=curr;
            curr=tmp;
        }
        head=prev;
        return head;
    }
    Node* addOne(Node *head) 
    {
        // Your Code here
        // return head of list after adding one
        head=reverse(head);
        //to calc.
        int carry=1;
        int sum=0;
        Node*t=head;
        Node *prev=NULL;
        while(t!=NULL)
        {
            sum=t->data+carry;
            if(sum>=10)carry=1;
            else carry=0;
            t->data=sum%10;
            prev=t;
            t=t->next;
            
        }
        
        if(carry>0)
        {
            Node *tmp=new Node(carry);
            prev->next=tmp;
        }
        head=reverse(head);
    }
};

// { Driver Code Starts.

int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        
        Node* head = new Node( s[0]-'0' );
        Node* tail = head;
        for(int i=1; i<s.size(); i++)
        {
            tail->next = new Node( s[i]-'0' );
            tail = tail->next;
        }
        Solution ob;
        head = ob.addOne(head);
        printList(head); 
    }
    return 0; 
} 
  // } Driver Code Ends