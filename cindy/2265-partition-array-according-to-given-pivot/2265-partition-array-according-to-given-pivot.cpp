class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        int n = nums.size();
        int* ans = new int[n];
        int* left = new int[n];
        int* right = new int[n];
        int lcnt = 0;
        int rcnt = 0;
        int pcnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                right[rcnt++] = nums[i];
            }
            else if (nums[i] < pivot) {
                left[lcnt++] = nums[i];
            }
            else {
                pcnt++;
            }
        }

        for (int i = 0; i < lcnt; i++) {
            ans[i] = left[i];
        }
        for (int i = 0; i < pcnt; i++) {
            ans[i+lcnt] = pivot;
        }
        for (int i = 0; i < rcnt; i++) {
            ans[i+lcnt+pcnt] = right[i];
        }

        delete[] left;
        delete[] right;

        vector<int> ans2;
        for (int i=0; i < n; i++) {
            ans2.push_back(ans[i]);
        }
        return ans2;
    }
};

// class Solution {
// public:
//     vector<int> pivotArray(vector<int>& nums, int pivot) {
//         int n = nums.size();
//         vector<int> ans(n);
//         vector<int> left;
//         vector<int> right;
//         int pcnt = 0;

//         for (int i = 0; i < n; i++) {
//             if (nums[i] > pivot) {
//                 right.push_back(nums[i]);
//             }
//             else if (nums[i] < pivot) {
//                 left.push_back(nums[i]);
//             }
//             else {
//                 pcnt++;
//             }
//         }

//         for (int i = 0; i < left.size(); i++) {
//             ans[i] = left[i];
//         }
//         for (int i = 0; i < pcnt; i++) {
//             ans[i+left.size()] = pivot;
//         }
//         for (int i = 0; i < right.size(); i++) {
//             ans[i+left.size()+pcnt] = right[i];
//         }

//         return ans;
//     }
// };
