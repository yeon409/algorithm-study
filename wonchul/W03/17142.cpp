#include<iostream>
#include<vector>
#include<algorithm>
#include<stdlib.h>
#include<queue>
#include<limits>
#include<cmath>

using namespace std;

int N, M, zeroNum = 0;
int map[50][50];
int dx[4] = { -1,0,1, 0 };
int dy[4] = { 0,1,0,-1 };

vector<vector<int>> next_comb(int num, vector<int> v);
vector<pair<int, int>>  virus_point;
int BFS(vector<int> v);
void showVisited(bool visited[50][50]);
bool inRange(int x, int y);

int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) {
				virus_point.push_back(make_pair(i, j));
			}
			else if (map[i][j] == 0) zeroNum++;
		}
	}
	vector<int> forComb;
	for (int i = 0; i < virus_point.size(); i++) forComb.push_back(i);
	vector<vector<int>> combs = next_comb(M, forComb);

	int minimum = numeric_limits<int>::max();
	for (vector<int> v : combs) {
		int bbfs = BFS(v);
		if (bbfs == -1) {
			continue;
		}
		// cout << bbfs << endl;
		minimum = min(bbfs, minimum);
	}
	if (minimum == numeric_limits<int>::max()) cout << -1 << endl;
	else cout << minimum << endl;

	return 0;
}

vector<vector<int>> next_comb(int num, vector<int> v) {
	vector<vector<int>> rst;
	vector<int> comb;

	for (int i = 0; i < v.size() - num; i++) {
		comb.push_back(0);
	}
	for (int i = 0; i < num; i++) {
		comb.push_back(1);
	}
	do {
		vector<int> add;
		for (int i = 0; i < comb.size(); i++) {
			if (comb[i] == 1) {
				add.push_back(v[i]);
			}
		}
		rst.push_back(add);
	} while (next_permutation(comb.begin(), comb.end()));
	return rst;
}

int BFS(vector<int> v) {//0은 빈 칸, 1은 벽, 2는 바이러스의 위치
	queue<pair<int, int>> q;
	bool visited[50][50] = { false, };
	for (int i = 0; i < v.size(); i++) {
		q.push(virus_point[v[i]]);
	}
	q.push(make_pair(-1, -1)); // 구분자
	int day = 0;
	int filled = 0;
	while (!q.empty() && zeroNum != filled) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();
		if (cx == -1) { // 구분자를 만난 경우
			if (q.empty()) break;
			day++;
			q.push(make_pair(-1, -1));

		}
		else if (visited[cx][cy] == true) continue;
		else {
			visited[cx][cy] = true;
			if (map[cx][cy] == 0)filled++;
		}


		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (!inRange(nx, ny) || map[nx][ny] == 1 || visited[nx][ny]) continue;
			q.push(make_pair(nx, ny));
		}
	}

	if (filled == zeroNum) return day;
	else return -1;
}

bool inRange(int x, int y) {
	if (x < 0 || x >= N || y < 0 || y >= N) return false;
	return true;
}