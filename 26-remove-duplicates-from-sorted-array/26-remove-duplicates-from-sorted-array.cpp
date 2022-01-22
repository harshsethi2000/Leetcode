class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
//         Method 1-
//             Simply put all the elements in set
//             since set can contains only unique elements
//         Time Complexity -O(nlogn+n)
//             Space Complexity O(n)
//             Method 2-
//                 Can take two pointers i and j 
//                 if x[i]!=x[j] increment i for every unique element and change x[i]=x[j]
//                     Time Complexity -O(n)
        int i=0;
        if(nums.size()==0)return 0;
        for(int j=1;j<nums.size();j++)
        {
            if(nums[i]!=nums[j])
            {
                i++;
                if(i>0)nums[i]=nums[j];
            }
        }
        return i+1;
    }
};