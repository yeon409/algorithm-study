#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

// 비교 함수
bool compare(string a, string b) {
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    vector<string> numStrs;
    for (int num : numbers) {
        numStrs.push_back(to_string(num));
    }

    // 커스텀 비교 함수로 정렬
    sort(numStrs.begin(), numStrs.end(), compare);

    // 모든 숫자가 0인 경우를 처리
    if (numStrs[0] == "0") {
        return "0";
    }

    // 결과 문자열 생성
    string answer = "";
    for (string numStr : numStrs) {
        answer += numStr;
    }

    return answer;
}

int main() {
    vector<int> numbers = { 3, 30, 34, 5, 9 };
    cout << solution(numbers) << endl; // 9534330
    return 0;
}
