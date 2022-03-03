class Solution {
public:
    int totalNQueens(int n) {
       int count=0;
        vector<vector<int>> board(n,vector<int>(n,-1));
        getCount(0,n,count,board);
        return count;
    }
    void getCount(int col,int n,int &count,vector<vector<int>> board)
    {
        if(col==n)
        {
            count++;
            return;
        }
        for(int row=0;row<n;row++)
        {
            if(validate(row,col,board))
            {
                board[row][col]=1;
                getCount(col+1,n,count,board);
                board[row][col]=-1;
            }
        }
        
    }
    bool validate(int row,int col,vector<vector<int>> board)
    {
        int tmpRow=row,tmpCol=col;
        //validate leftCol
        while(col>=0)
        {
            if(board[row][col]==1)return false;
            col--;
        }
        col=tmpCol;
        
        //validate upper diagonal
        while(row>=0 && col>=0)
        {
            if(board[row][col]==1)return false;
            row--;
            col--;
        }
        
        row=tmpRow;
        col=tmpCol;
        
        //validate lowe diagonal
        while(row<board.size() && col>=0)
        {
            if(board[row][col]==1)return false;
            row++;
            col--;
        }
        return true;
    }
    
};