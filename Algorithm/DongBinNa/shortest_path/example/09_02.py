import heapq
import sys

INF = int(1e9)
input = sys.stdin.readline

n, m, c = map(int, input().rstrip().split())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)


for _ in range(m):
    x, y, z = map(int, input().rstrip().split())
    graph[x].append((y, z))


def dijkstra(start):
    queue = []
    distance[start] = 0
    heapq.heappush(queue, (0, start))

    while queue:
        dist, vertex = heapq.heappop(queue)

        for data in graph[vertex]:
            cost = dist + data[1]
            if distance[data[0]] > cost:
                distance[data[0]] = cost
                heapq.heappush(queue, (cost, data[0]))


dijkstra(c)

max_distance = 0
count = 0

for value in distance:
    if value != INF:
        max_distance = max(max_distance, value)
        count += 1


print(count - 1, max_distance)
