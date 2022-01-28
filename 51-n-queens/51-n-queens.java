class Solution {
    public List<List<String>> solveNQueens(int n) {
        
//         Time Complexity - O(N^3)
//         Space Complexity -O(N^2)
            
        
        //take an extra 2D array to mark and unmark Q position
        //in different different combination
        char[][] board=new char[n][n];
        //Initially mark all elements by '.'
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)board[i][j]='.';
        }
        List<List<String>> ls=new ArrayList<>();
        dfs(0,board,ls);
        return ls;
    }
    public void dfs(int col,char[][] board,List<List<String>> ls)
    {
        if(col==board.length)
        {
            //combination is valid
            //add that combination in our ls
            List<String> tmpL=new LinkedList<>();
            for(int i=0;i<board.length;i++)
            {
                String s=new String(board[i]);
                tmpL.add(s);
            }        
            ls.add(tmpL);
            return;
        }
        for(int row=0;row<board.length;row++)
        {
            if(validateCombination(row,col,board))
            {
                //if combination is possible
                //mark that element in our board as Q
                board[row][col]='Q';
                dfs(col+1,board,ls);
                //unmkark after backtracked
                board[row][col]='.';
            }
        }
    }
    public boolean validateCombination(int row,int col,char[][] board)
    {
        int tmpRow=row;
        int tmpCol=col;
        //check for lower diagnonal
        for(;row>=0 && col>=0;row--,col--)if(board[row][col]=='Q')return false;
        //check for row
        for(row=tmpRow,col=tmpCol;col>=0;col--)if(board[row][col]=='Q')return false;
        //check for upper diagonal
        for(col=tmpCol;col>=0 && row<board.length;row++,col--)if(board[row][col]=='Q')return false;
        return true;
        
        
    }
}