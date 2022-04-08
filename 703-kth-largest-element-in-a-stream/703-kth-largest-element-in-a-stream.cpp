class KthLargest {
public:
    priority_queue<int> p;
    int k;
    KthLargest(int K, vector<int>& nums) {
        k=K;
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