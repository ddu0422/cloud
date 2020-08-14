checkboard = [[0] * 19 for _ in range(19)]

n = int(input())

for i in range(n):
    a, b = map(int, input().split())
    checkboard[a - 1][b - 1] = 1

for i in checkboard:
    for j in i:
        print(j, end=" ")
    print()
