#include <string>
#include <vector>
#include <queue>
#include <stdlib.h>
#include <deque>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    priority_queue<int> pq;
    deque<pair<int, int>> dq;
    for (int p : priorities) {
        dq.push_back(make_pair(p, 0));
        pq.push(p);
    }
    dq[location].second = 1;
    while (true) {
        if (dq.front().first < pq.top()) { // �� ū �켱������ �ִ� ���
            dq.push_back(dq.front());
            dq.pop_front();
        }
        else { // dp.first == pq.top
            answer++;
            if (dq.front().second == 1) { // Ÿ���ΰ��
                break;
            }
            dq.pop_front();
            pq.pop();
        }
    }
    return answer;
}