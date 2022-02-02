class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    //since we have to find only one solution so we can just return true if
    //we find out our solution
    public boolean solve(char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                //check for empty spaces
                if(board[i][j]=='.')
                {
                    //try all the combination
                    for(char c='1';c<='9';c++)
                    {
                        //check if combination is valid or not
                        
                        if(isValid(i,j,c,board))
                        {
                            board[i][j]=c;
                            //if combination is valid
                            //then recursively check for another empty space with this
                            // selected combination.
                            if(solve(board))return true;
                            else 
                            {
                                //recursive function that we have called returned
                                //false soo just ignore that selected combination
                                //and try finding new possible combination
                                board[i][j]='.';
                            }
                        }
                        
                    }
                    return false;
                }
                
            }
        }
        return true;
    }
    public boolean isValid(int row,int col,char c,char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            //check for row
            if(board[i][col]==c)return false;
            //check for column
            if(board[row][i]==c)return false;
            //check for small 3*3 matrix
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)return false;
            
        }
        return true;
    }
}