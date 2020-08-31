import sys

INF = int(1e9)
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(n + 1):
    for j in range(n + 1):
        if i == j:
            graph[i][j] = 0

for _ in range(m):
    i, j = map(int, input().rstrip().split())
    graph[i][j] = 1
    graph[j][i] = 1


x, k = map(int, input().rstrip().split())


for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

distance = graph[1][k] + graph[k][x]

if distance >= INF:
    print(-1)
else:
    print(distance)
