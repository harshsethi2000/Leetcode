class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        int r = mat.size(), c = mat[0].size();
        
        for(int i = r - 1; i>=0; i--){
            int curr_row = i, curr_col = 0;
            priority_queue<int, vector<int>, greater<int>> pq;
            while(curr_row < r && curr_col < c){
                pq.push(mat[curr_row][curr_col]);
                curr_row++;
                curr_col++;
            }
            curr_row = i, curr_col = 0;
            while(!pq.empty()){
                mat[curr_row][curr_col] = pq.top();
                curr_row++;
                curr_col++;
                pq.pop();
            }
        }
        
        for(int i=1; i<c; i++){
            int curr_row = 0, curr_col = i;
            priority_queue<int, vector<int>, greater<int>> pq;
            while(curr_row < r && curr_col < c){
                pq.push(mat[curr_row][curr_col]);
                curr_row++;
                curr_col++;
            }
            curr_row = 0, curr_col = i;
            while(!pq.empty()){
                mat[curr_row][curr_col] = pq.top();
                curr_row++;
                curr_col++;
                pq.pop();
            }
        }
        return mat;
    }
};