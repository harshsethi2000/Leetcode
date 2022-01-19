class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //means the matrix is sorted 
        //we can use concept of binary search
        //can calculate start=0 end=m*n and mid=(start+end)/2
        //now for mid element of matrix that is x[mid/m][mid%m] check if target is equal greater //         //orlesser
        int start=0;
        int m=matrix.length;
        int n=matrix[0].length;
        
        int end=m*n-1;
        while(start<=end)
        {
            int mid=(start+(end-start)/2);
            int num=matrix[mid/n][mid%n];
            if(num==target)return true;
            else if(num>target)end=mid-1;
            else start=mid+1;
        }
        return false;
    }
}