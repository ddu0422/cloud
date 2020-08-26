import sys
from collections import deque

# 판 크기
n = int(sys.stdin.readline().rstrip())
# 판 생성
board = [[0] * n for _ in range(n)]

# 사과 개수
k = int(sys.stdin.readline().rstrip())
# 사과 위치
for _ in range(k):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    board[x - 1][y - 1] = 1

# 시간, 방향 입력
data = {}
for _ in range(int(input())):
    input_data = input().split()
    data[int(input_data[0])] = input_data[1]


# 시작 위치
snake = deque()
snake.append([0, 0])

# 동, 남, 서, 북 -> 0, 1, 2, 3
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

# 현재 방향
direction = 0
current_time = 0


# 방향 변환
def change_direction(next_direct):
    global direction

    if next_direct == 'D':
        direction += 1
    else:
        direction -= 1

    if direction == -1:
        direction = 3

    if direction == 4:
        direction = 0


while True:
    # 현재 머리
    x, y = snake[0]

    # 다음 머리가 이동할 위치
    nx = x + dx[direction]
    ny = y + dy[direction]

    # 시간 추가
    current_time += 1

    # 판을 벗어나거나 머리가 몸통에 닿으면 종료
    if not (0 <= nx < n and 0 <= ny < n) or [nx, ny] in snake:
        break

    # 머리 이동 후 추가
    snake.appendleft([nx, ny])

    # 사과를 먹지 못하면
    if board[nx][ny] == 0:
        # 꼬리 제거
        snake.pop()
    else:
        # 사과를 먹으면 제거
        board[nx][ny] = 0

    # 방향을 바꿈
    if current_time in data.keys():
        change_direction(data[current_time])

print(current_time)
