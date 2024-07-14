#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

// �� �Լ�
bool compare(string a, string b) {
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    vector<string> numStrs;
    for (int num : numbers) {
        numStrs.push_back(to_string(num));
    }

    // Ŀ���� �� �Լ��� ����
    sort(numStrs.begin(), numStrs.end(), compare);

    // ��� ���ڰ� 0�� ��츦 ó��
    if (numStrs[0] == "0") {
        return "0";
    }

    // ��� ���ڿ� ����
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
