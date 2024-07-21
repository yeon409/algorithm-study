#include <iostream>
#include <string>
#include <vector>

using namespace std;
bool visited[200];
void DFS(int a, vector<vector<int>> computers);

int solution(int n, vector<vector<int>> computers) {
    int answer = 1;

    for (int i = 0; i < n; i++) {
        visited[i] = false;
    }
    DFS(0, computers);
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            DFS(i, computers);
            answer++;
            //cout << "ans++" << endl;
        }
    }
    return answer;
}

void DFS(int a, vector<vector<int>> computers) {
    //cout << "DFS(" << a << ")" << endl;
    visited[a] = true;
    for (int i = 0; i < computers.size(); i++) {
        if (a == i) continue;
        if (!visited[i] && computers[a][i] == 1) {
            DFS(i, computers);
        }
    }
}