
// Using Priority Queue -
//     We will be using priority queue and will add the K elements in our queue
//     Since priority queue in C++ follow the max-heap soo we will add negative of every 
//     element to make it follow the min-heap conditions.

// N as the length of nums and M as the number of calls to add(),
// Time Complexity: O(N⋅log(N)+M⋅log(k))    
// space complexity: O(N)O(N)
    

class KthLargest {
public:
    priority_queue<int> p;
    int k;
    KthLargest(int K, vector<int>& nums) {
        this->k=K;
        for(int i=0;i<nums.size();i++)
        {
            p.push(-nums[i]);
            if(p.size()>k)
                p.pop();
        }
    }
    
    int add(int val) {
         p.push(-val);
            if(p.size()>k)
                p.pop();
        return -p.top();
    }
};