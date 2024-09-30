class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        vector<vector<int>> v(m);
        int p = 0;
        
        if (m * n != original.size())
            return {};
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                v[r].push_back(original[p++]);
            }
        }
        
        return v;
    }
};