#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string, int> p;
    unordered_map<string, int> c;
    for (int i = 0; i < participant.size(); i++) {
        if (p.find(participant[i]) == p.end()) { //없는 경우 
            p.insert({ participant[i], 1 });
        }
        else p.find(participant[i])->second++; // 있는 경우
    }
    for (int i = 0; i < completion.size(); i++) {
        // cout << completion[i] << " : " <<  p.find(completion[i])->second << endl;
        p.find(completion[i])->second--;
        if (p.find(completion[i])->second == 0) p.erase(completion[i]);
    }
    for (auto s : p) {
        // cout << s.first << endl;
        answer = s.first;
    }

    return answer;
}