import sys
from collections import deque

# 실험실 크기 및 바이러스 번호
n, k = map(int, sys.stdin.readline().rstrip().split())
# 실험실 정보
maps = [
    list(map(int, sys.stdin.readline().rstrip().split()))[:n] for _ in range(n)
]
# 해당 시간, 위치에 바이러스 정보
target_s, target_x, target_y = map(int, sys.stdin.readline().rstrip().split())

# 바이러스 정보
data = []

for i in range(n):
    for j in range(n):
        if maps[i][j] != 0:
            data.append([maps[i][j], 0, i, j])

data.sort()
queue = deque(data)

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while queue:
    virus, s, x, y = queue.popleft()

    if s == target_s:
        break

    for i in range(len(dx)):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n:
            if maps[nx][ny] == 0:
                maps[nx][ny] = virus
                queue.append([virus, s + 1, nx, ny])

print(maps[target_x - 1][target_y - 1])
