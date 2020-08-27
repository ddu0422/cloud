import sys
from itertools import combinations

# 연구소 크기
n, m = map(int, sys.stdin.readline().rstrip().split())
# 연구소 정보 입력
array = [
    list(map(int, sys.stdin.readline().rstrip().split()))[:m] for _ in range(n)
]
# 연구소 벽을 설치할 임시 공간
temp = [[0] * m for _ in range(n)]

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 벽
blank = [[i, j] for i in range(n) for j in range(m) if array[i][j] == 0]
# 바이러스
viruses = [[i, j] for i in range(n) for j in range(m) if array[i][j] == 2]
# 벽을 설치할 후보 좌표
candidates = combinations(blank, 3)


# 벽 설치
def install_wall(candidate):
    # 초기화
    for i in range(n):
        for j in range(m):
            temp[i][j] = array[i][j]
    # 벽 설치
    for x, y in candidate:
        temp[x][y] = 1


# 바이러스 전염
def spread_virus(x, y):
    for i in range(len(dx)):
        nx = x + dx[i]
        ny = y + dy[i]

        if not (0 <= nx < n and 0 <= ny < m):
            continue

        if temp[nx][ny] == 0:
            temp[nx][ny] = 2
            spread_virus(nx, ny)


# 안전 영역 구하기
def get_sum(array):
    total = 0

    for i in range(len(array)):
        for j in range(len(array[i])):
            if array[i][j] == 0:
                total += 1

    return total


result = 0

for candidate in candidates:
    install_wall(candidate)
    for x, y in viruses:
        spread_virus(x, y)
    result = max(result, get_sum(temp))

print(result)
