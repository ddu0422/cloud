SIZE = 19

checkboard = [list(map(int, input().split())) for _ in range(SIZE)]
n = int(input())

for i in range(n):
    a, b = map(int, input().split())

    a -= 1
    b -= 1

    for j in range(SIZE):
        if b == j:
            continue
        checkboard[a][j] = 1 - checkboard[a][j]

    for j in range(SIZE):
        if a == j:
            continue
        checkboard[j][b] = 1 - checkboard[j][b]

for i in checkboard:
    for j in i:
        print(j, end=" ")
    print()
