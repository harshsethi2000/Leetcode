class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> p;
        for(int i=0;i<k;i++)p.push(-1*nums[i]);
        for(int i=k;i<nums.size();i++)
        {
            p.push(-1*nums[i]);
            if(p.size()>k)
            {
                p.pop();
            }
        }
        return -1*p.top();
    }
};