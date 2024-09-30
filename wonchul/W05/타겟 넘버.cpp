#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int answer;
void DFS(int depth, int sign, vector<int> numbers, int curent, int target);

int solution(vector<int> numbers, int target) {
    answer = 0;
    DFS(0, 0, numbers, numbers[0], target);
    DFS(0, 1, numbers, numbers[0], target);
    DFS(0, 0, numbers, -1 * numbers[0], target);
    DFS(0, 1, numbers, -1 * numbers[0], target);
    return answer;
}

void DFS(int depth, int sign, vector<int> numbers, int curent, int target) {
    curent += pow(-1, sign) * numbers[depth + 1];
    // cout << "DFS(depth: " << depth << ", sign: " << sign << ", curent: " << curent << " )" << endl;
    if (depth == numbers.size() - 2) {
        if (curent == target) {
            answer++;
        }
    }
    else {
        DFS(depth + 1, 0, numbers, curent, target);
        DFS(depth + 1, 1, numbers, curent, target);
    }

}