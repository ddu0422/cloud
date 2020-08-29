import sys
from itertools import combinations

n = int(sys.stdin.readline().rstrip())
maps = [sys.stdin.readline().rstrip().split()[:n] for _ in range(n)]
teachers = [(i, j) for i in range(n) for j in range(n) if maps[i][j] == 'T']
spaces = [(i, j) for i in range(n) for j in range(n) if maps[i][j] == 'X']


# 감시
def watch(teacher, direction):
    x, y = teacher

    if direction == 0:
        while x >= 0:
            if maps[x][y] == 'S':
                return True

            if maps[x][y] == 'O':
                return False

            x -= 1

    if direction == 1:
        while x < n:
            if maps[x][y] == 'S':
                return True

            if maps[x][y] == 'O':
                return False

            x += 1

    if direction == 2:
        while y >= 0:
            if maps[x][y] == 'S':
                return True

            if maps[x][y] == 'O':
                return False

            y -= 1

    if direction == 3:
        while y < n:
            if maps[x][y] == 'S':
                return True

            if maps[x][y] == 'O':
                return False

            y += 1

    return False


# 감시 작업
def watch_process():
    for teacher in teachers:
        for direction in range(4):
            if watch(teacher, direction):
                return True

    return False


result = False

# 벽 설치
for candidates in combinations(spaces, 3):
    for x, y in candidates:
        maps[x][y] = 'O'

    if not watch_process():
        result = True
        break

    for x, y in candidates:
        maps[x][y] = 'X'


print('YES' if result else 'NO')
