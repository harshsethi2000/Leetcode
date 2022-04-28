class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int[][] cost = new int[heights.length][heights[0].length];
        
        // Initialize to -1 at;
        for(int i = 0; i < cost.length; i++) {
            for(int j = 0; j < cost[0].length; j++)  {
                cost[i][j] = -1;
            }
        }
        
        Deque<Pair> queue = new ArrayDeque<>();
        
        queue.add(new Pair(0, 0));
        
        // Define all possible direction to move
        int[][] directions = new int[][] {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        
        while(!queue.isEmpty()) {
            
            Pair curr = queue.remove();
            int row = curr.row;
            int col = curr.col;
            int currCost = cost[row][col];
            
            // Iterate all directions
            
            for(int i = 0; i < directions.length; i++) {       
                int newRow = row + directions[i][0];
                int newCol = col +  directions[i][1];
                
                if(isValidMove(newRow, newCol, heights)) {
                    int neighbourAtCost = cost[newRow][newCol];
                    int newCost = Math.max(currCost, Math.abs(heights[row][col] - heights[newRow][newCol]));

                    // if current cost is less than previous, visit it
                    if(neighbourAtCost == -1 || newCost < neighbourAtCost) {
                        cost[newRow][newCol] = newCost;
                        queue.add(new Pair(newRow, newCol));
                    } 
                }
            }
        }
        
        int finalEffort = cost[heights.length - 1][heights[0].length - 1];
        return finalEffort == -1? 0 : finalEffort;
    }
    
    // If value lies outside the matrix, its not a valid move
    private boolean isValidMove(int row, int col, int[][] heights) {
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) return false;
        
        return true;
    }
    
    // Simple approach to keep a row, col
    private class Pair {
        public int row;
        public int col;
        
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}