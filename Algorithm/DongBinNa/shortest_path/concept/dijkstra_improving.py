import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().rstrip().split())
start = int(input().rstrip())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().rstrip().split())
    graph[a].append((b, c))


def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, now = heapq.heappop(queue)

        if distance[now] < dist:
            continue

        for data in graph[now]:
            cost = dist + data[1]
            if distance[data[0]] > cost:
                distance[data[0]] = cost
                heapq.heappush(queue, (cost, data[0]))


dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])
