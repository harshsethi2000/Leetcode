class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        // Method 2-
        //     The intitution behind is that we can sort the array
        //     and after sorting just fix one element to be our nums[i]
        //     and then apply traditional 2 pointer approach searching using binary search
        //     Time Complexity - O(n^2)
        //     Space Complexity - O(1)
        sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        if(nums.size()<3)return ans;
        for(int i=0;i<nums.size()-2;i++)
        {
            int num=nums[i];
          if(i == 0 || (i > 0 && nums[i] != nums[i-1]))
          {
            int start=i+1;
              int end=nums.size()-1;
              while(start<end)
              {
                  int sum =nums[start]+nums[end]+num;
                  if(sum==0)
                  {
                      
                      vector<int> tmp;
                      tmp.push_back(num);tmp.push_back(nums[start]);tmp.push_back(nums[end]);
                      ans.push_back(tmp);
                      //remove repetition
                      while(start<end && nums[start]==nums[start+1])start++;
                      while(start<end && nums[end]==nums[end-1])end--;
                      
                      end--;start++;
                  }
                  else if(sum>0)
                  {
                     end-- ;
                  }else
                  {
                      start++;
                  }
              }
          }
             
        }
        return ans;
    }
};