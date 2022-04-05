// class Solution {
// public:
//     int maxArea(vector<int>& height) {
//         int ans=0;
//         for(int i=0;i<height.size()-1;i++)
//         {
            
//             for(int j=i+1;j<height.size();j++)
//             {
//                 int k=min(height[i],height[j]);
                
//                 ans=max(ans,k*(j-i));
//             }
//         }
//         return ans;
//     }
// };

class Solution {
public:
    int maxArea(vector<int>& height) {
        int ans=0;
        int i=0,j=height.size()-1;
        while(i<j)
        {
            int k=min(height[i],height[j]);
            ans=max(ans,k*(j-i));
            if(height[i]<height[j])i++;
            else if(height[i]>height[j])j--;
            else 
            {
                i++;j--;
            }
            
        }
        return ans;
    }
};

