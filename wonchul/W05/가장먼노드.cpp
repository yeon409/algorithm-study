#include<iostream>
#include <string>
#include <vector>
#include<stack>

using namespace std;

stack<int> s1;
stack<int> s2;

bool visited[20001];
int save = 0;

void BFS(vector<vector<int>> lines) {
    int s_num;
    while (!s1.empty() || !s2.empty()) {
        //cout << "save: " << save << endl;
        save = 0;
        if (!s1.empty()) s_num = 1;
        else s_num = 2;
        if (s_num == 1) {
            while (!s1.empty()) {
                int s1_top = s1.top();
                for (int i = 0; i < lines[s1_top].size(); i++) {
                    int next = lines[s1_top][i];
                    if (visited[next]) continue;
                    //cout << "next push: " << next << endl;
                    visited[next] = true;
                    s2.push(next);
                    save++;
                }
                s1.pop();
                save++;
            }
        }
        else {
            while (!s2.empty()) {
                int s2_top = s2.top();
                for (int i = 0; i < lines[s2_top].size(); i++) {
                    int next = lines[s2_top][i];
                    if (visited[next]) continue;
                    //cout << "next push: " << next << endl;
                    visited[next] = true;
                    s1.push(next);
                }
                s2.pop();
                save++;
            }
        }
    }
}

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    vector<vector<int>> lines(n + 1);
    for (int i = 0; i < n; i++) visited[i] = false;
    for (int i = 0; i < edge.size(); i++) {
        lines[edge[i][0]].push_back(edge[i][1]);
        lines[edge[i][1]].push_back(edge[i][0]);
    }
    s1.push(1);
    visited[1] = true;
    BFS(lines);
    return save;
}