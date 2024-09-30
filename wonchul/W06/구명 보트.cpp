#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
    reverse(people.begin(), people.end());
    int start_idx = 0;
    int end_idx = people.size() - 1;
    while (start_idx <= end_idx) {

        if (start_idx == end_idx) {
            answer++;
            break;
        }
        if (people[start_idx] + people[end_idx] <= limit) {
            start_idx++;
            end_idx--;
            answer++;
        }
        else {
            start_idx++;
            answer++;
        }
    }
    return answer;
}