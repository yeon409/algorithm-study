#include<iostream>
#include<utility>
#include<vector>
using namespace std;

int N;
vector<int> v;
vector<int> upArr;

int binarySearch(int a);
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		v.push_back(input);
	}
	upArr.push_back(v[0]);
	for (int i = 1; i < N; i++) {
		if (v[i] > upArr.back()) upArr.push_back(v[i]);
		else {
			int index = binarySearch(v[i]);
			upArr[index] = v[i];
		}
	}
	cout << N - upArr.size() << endl;
	return 0;
}


int binarySearch(int a) {
	int s = 0;
	int e = upArr.size() - 1;
	while (s <= e) {
		int mid = s + (e - s) / 2;
		if (upArr[mid] < a) {
			s = mid + 1;
		}
		else {
			e = mid - 1;
		}
	}
	return s;
}
