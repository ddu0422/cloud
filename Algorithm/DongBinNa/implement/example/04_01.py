n = int(input())
moves = input().split()

x, y = 1, 1

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

move_type = ['L', 'R', 'U', 'D']

for move in moves:
    for i in range(len(move_type)):
        if move == move_type[i]:
            nx = x + dx[i]
            ny = y + dy[i]

    if 1 <= nx <= n and 1 <= ny <= n:
        x, y = nx, ny

print(x, y)
