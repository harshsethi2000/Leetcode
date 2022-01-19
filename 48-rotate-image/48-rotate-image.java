class Solution {
    public void rotate(int[][] matrix) {
        //its just like taking transpose then rotating the array rows
        //transpose means interchanging rows with column
        
        //Transpose
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                //swap matrix[i][j] with matrix[j][i]
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
                
            }
        }
        
        //now reverse the row 
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0,k=matrix.length-1;j<matrix.length/2;j++,k--)
            {
                //swap matrix[i][j] with matrix[i][k]
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=tmp;
            }
        }
    }
}