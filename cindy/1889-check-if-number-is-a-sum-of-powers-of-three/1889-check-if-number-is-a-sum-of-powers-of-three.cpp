/*
3의 배수의 합으로 숫자를 만들 수 있는지 확인함
(백트래킹)

n은 최대 10^6이므로 3^16이 최대이다.
따라서 16번에 대해 백트래킹을 하면 됨

1. n이 되면 true 반환
2. n보다 커지면 false 반환
3. 현재의 합을 sum에 더할지 말지에 따라 2가지 방향으로 백트래킹
*/

class Solution {
public:
    int pow(int a, int b) {
        if (b == 0) return 1;
        int temp = 1;

        for (int i = 0; i < b; i++) {
            temp *= a;
        }

        return temp;
    }

    bool sumCandi(int sum, int n, int i) {
        if (sum == n) {
            return true;
        }

        int cur = pow(3, i);

        if (sum > n || cur > n) {
            return false;
        }

        if (sumCandi(sum + cur, n, i + 1)) {
            return true;
        }

        return sumCandi(sum, n, i + 1);
    }

    bool checkPowersOfThree(int n) {
        return sumCandi(0, n, 0);
    }
};