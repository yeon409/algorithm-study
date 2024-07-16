#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

void swap(vector<vector<int>>& v, int a, int b);
int go(vector<vector<int>>& v, int k);
bool np(vector<vector<int>>& v);

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    sort(dungeons.begin(), dungeons.end());
    do {
        answer = max(answer, go(dungeons, k));
    } while (np(dungeons));
    return answer;
}

bool np(vector<vector<int>>& v) {
    int i = v.size() - 1;
    while (i > 0 && v[i - 1][0] >= v[i][0]) i--;
    if (i <= 0) return false;
    int j = v.size() - 1;
    while (v[i - 1][0] >= v[j][0]) j--;
    swap(v, i - 1, j);
    reverse(v.begin() + i, v.end());
    return true;
}

void swap(vector<vector<int>>& v, int a, int b) {
    vector<int> temp = v[a];
    v[a] = v[b];
    v[b] = temp;
}

int go(vector<vector<int>>& v, int k) {
    // for(auto vec : v){
    //     cout << vec[0] << " ";
    // }
    // cout << endl;

    int num = 0;
    for (auto vec : v) {

        if (vec[0] <= k) {
            k -= vec[1];
            num++;
        }
        else {
            break;
        }
        //cout << "k: " << k << endl;
    }
    return num;
}