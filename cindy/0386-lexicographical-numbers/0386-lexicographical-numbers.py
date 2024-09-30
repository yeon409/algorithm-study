class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []
        curr = 1

        for _ in range(n):
            ans.append(curr)

            # 앞자리수 돌리기
            if curr * 10 <= n:
                curr *= 10
            else:
                # n에 도달했으면 앞자리수 depth로 돌아가기
                if curr >= n:
                    curr //= 10

                # 뒷자리수 돌리기
                curr += 1

                # 9까지 다 돌아서 0을 돌아왔으면 앞자리수 depth로 돌아가기
                while curr % 10 == 0:
                    curr //= 10


        return ans
