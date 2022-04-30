class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,greater<int> > p;
        for(int i=0;i<k;i++)p.push(nums[i]);
        for(int i=k;i<nums.size();i++)
        {
            p.push(nums[i]);
            if(p.size()>k)
            {
                p.pop();
            }
        }
        return p.top();
    }
};