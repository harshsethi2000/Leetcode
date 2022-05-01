class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& arr2, int n) {
        if(n==0)return ;
        for(int i=0;i<m;i++)
        {
            if(nums1[i]>arr2[0])
            {
                swap(nums1[i],arr2[0]);
            }
            //sort the nums2 and place that swapped element to its place
            int num=arr2[0];
            int k;
            for(k=1;k<n;k++)
            {
                if(arr2[k]<num)swap(arr2[k],arr2[k-1]);
                else break;
            }
            arr2[k-1]=num;
        }
        
        int j=0;
        for(int i=m;i<m+n;i++)
        {
            nums1[i]=arr2[j++];
        }
        
    }
};