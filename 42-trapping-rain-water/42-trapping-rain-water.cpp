class Solution {
public:
    int trap(vector<int>& height) {
//         The water which each element can store is
//             min(maxToTheLeft,maxToTheRight)-x[i]
//         Method 1-
//             Simply iterate over the array and for each element calcluate the max left height
//                 and max right height including that element
//                 Time Complexity - O(n*n)
//                 Space Complexity - O(1)
                
        
//         Method 2-
//             we can initially calculate max left and right height for each element
//                 and store it in prefix and suffix array.
//                 TIme complexity -O(n)+O(n)+O(n)
//                 Space Complexity -O(n)=O(n)
                
        if(height.size()==1)return 0;
        vector<int> prefix;
        int max=height[0];
        prefix.push_back(height[0]);
        for(int i=1;i<height.size();i++)
        {
            if(max<height[i])max=height[i];
            prefix.push_back(max);
        }
        max=height[height.size()-1];
        int suffix[height.size()];
        suffix[height.size()-1]=height[height.size()-1];
        for(int i=height.size()-2;i>=0;i--)
        {
            if(max<height[i])max=height[i];
            suffix[i]=max;
        }
        //we got the max height of the left and right for each element.
        int ans=0;
        for(int i=0;i<height.size();i++)
        {
            ans=ans+min(prefix[i],suffix[i])-height[i];
        }
        return ans;
    }
};