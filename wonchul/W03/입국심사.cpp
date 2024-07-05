#define ll long long
#include <iostream>
#include <string>
#include <vector>

using namespace std;
ll calc(vector<int> times, ll input) {
    ll rst = 0;
    for (int time : times) {
        rst += input / time;
    }
    return rst;
}
long long solution(int n, vector<int> times) {
    //ÀÌºÐÅ½»ö
    ll s = 1;
    ll e = 1'000'000'000L * n;
    ll mid;
    ll answer = 0;
    while (s <= e) {
        mid = (s + e) / 2;
        // cout << "s: " << s << " e: " << e << endl;
        // cout << "mid: " << mid << endl;
        ll num = calc(times, mid);
        if (num >= n) {
            e = mid - 1;
            answer = mid;
        }
        else if (num < n) {
            s = mid + 1;
        }

    }
    return answer;
}
