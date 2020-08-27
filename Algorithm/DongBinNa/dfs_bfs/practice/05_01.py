import sys
from collections import deque

n, m, k, x = map(int, sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(n + 1)]
distance = [-1] * (n + 1)

for _ in range(m):
    u, v = map(int, sys.stdin.readline().rstrip().split())
    graph[u].append(v)


def bfs(start):
    queue = deque([start])
    distance[start] = 0

    while queue:
        vertex = queue.popleft()

        for v in graph[vertex]:
            if distance[v] == -1:
                queue.append(v)
                distance[v] = distance[vertex] + 1


bfs(x)

result = [i for i in range(len(distance)) if distance[i] == k]

if result:
    for i in result:
        print(i)
else:
    print(-1)
