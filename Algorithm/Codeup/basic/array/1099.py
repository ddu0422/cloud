SIZE = 10

maps = [list(map(int, input().split()))[:SIZE] for _ in range(SIZE)]

i = 1
j = 1

while i < SIZE - 1 and i < SIZE - 1:
    now = maps[i][j]
    right = maps[i][j + 1]
    down = maps[i + 1][j]

    if now == 2:
        maps[i][j] = 9
        break

    maps[i][j] = 9

    if right == 1 and down == 1:
        break

    if right == 0 or right == 2:
        j += 1
        continue

    if down == 0 or down == 2:
        i += 1
        continue

for i in maps:
    for j in i:
        print(j, end=" ")
    print()
