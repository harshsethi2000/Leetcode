class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int row = grid.size(), col = grid[0].size();
        vector<int>arr;
        for(int i =0; i<row; i++){
            for(int j =0; j<col; j++){
                arr.push_back(grid[i][j]);
            }
        }
        
        k = k % arr.size();
        reverse(arr.begin(), arr.end()-k);
        reverse(arr.end() -k, arr.end());
        reverse(arr.begin(), arr.end());
        
        int count = 0;
        for(int i =0; i<row; i++){
            for(int j =0; j<col; j++){
                grid[i][j] = arr[count++];
            }
        }
        // for(auto i: arr) cout<<i<<" ";
        return grid;
    }
};