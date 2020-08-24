# N x M 맵 입력
n, m = map(int, input().split())

# 현재 좌표 및 바라보는 방향 입력
x, y, d = map(int, input().split())

# map 생성
map = [list(map(int, input().split()))[:m] for _ in range(n)]

# 방문 여부 확인 리스트 생성
check = [[0] * m for _ in range(n)]


# x, y 방향
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 현재 있는 곳은 방문
check[x][y] = 1
answer = 1

# 회전 횟수
turn_time = 0

# 왼쪽으로 회전


def turn_left():
    global d
    d -= 1
    if d == -1:
        d = 3


while True:
    # 왼쪽으로 회전 후 이동
    turn_left()
    nx = x + dx[d]
    ny = y + dy[d]

    # 이동할 곳이 '땅'이고 '방문하지 않은 곳'
    if map[nx][ny] == 0 and check[nx][ny] == 0:
        check[nx][ny] = 1
        x, y = nx, ny
        answer += 1
        turn_time = 0
        continue

    # 이동할 곳이 없다면 회전
    else:
        turn_time += 1

    # 회전을 4번했으면
    if turn_time == 4:
        # 뒤로 이동
        nx = x - dx[d]
        ny = y - dy[d]

        # 이동할 곳이 '땅'이면
        if map[nx][ny] == 0:
            # 1단계로 돌아감
            x, y = nx, ny
            turn_time = 0

        # 아니면 종료
        else:
            break


print(answer)
