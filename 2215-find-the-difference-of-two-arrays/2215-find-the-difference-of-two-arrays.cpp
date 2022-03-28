class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        set<int> s1;
        set<int> s2;
        for(int i=0;i<nums1.size();i++)
        {
            s1.insert(nums1[i]);
        }
        for(int i=0;i<nums2.size();i++)
        {
            s2.insert(nums2[i]);
        }
        
        vector<vector<int>> ans(2);
        set<int>::iterator it1;
        set<int>::iterator it2;
        
        for (it1=s1.begin(); it1!=s1.end(); ++it1)
        {
            if(s2.find(*it1)==s2.end())
            {
                ans[0].push_back(*it1);
            }   
        }
        
        
        for (it2=s2.begin(); it2!=s2.end(); ++it2)
        {
            if(s1.find(*it2)==s1.end())
            {
                ans[1].push_back(*it2);
            }   
        }
        
        
        
        return ans;
        
        
        
    }
};