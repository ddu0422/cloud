h, w = map(int, input().split())
n = int(input())

maps = [[0] * w for _ in range(h)]

for _ in range(n):
    l, d, x, y = map(int, input().split())
    x -= 1
    y -= 1

    if d == 0:
        for i in range(y, y + l):
            maps[x][i] = 1

    if d == 1:
        for i in range(x, x + l):
            maps[i][y] = 1

for i in maps:
    for j in i:
        print(j, end=" ")
    print()
