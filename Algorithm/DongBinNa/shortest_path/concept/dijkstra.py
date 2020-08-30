import sys

INF = int(1e9)

n, m = map(int, sys.stdin.readline().rstrip().split())
start = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
distance = [INF] * (n + 1)
path = [-1] * (n + 1)

for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append((b, c))


# 방문하지 않은 정점 중 최단 거리가 가장 짧은 정점
def get_smallest_node():
    min_value = INF
    index = 0

    for i in range(1, n + 1):
        if not visited[i] and min_value > distance[i]:
            min_value = distance[i]
            index = i

    return index


def dijkstra(start):
    distance[start] = 0
    visited[start] = True
    path[start] = 0

    for data in graph[start]:
        distance[data[0]] = data[1]
        path[data[0]] = start

    for _ in range(n - 1):
        now = get_smallest_node()
        visited[now] = True

        for data in graph[now]:
            cost = distance[now] + data[1]
            if cost < distance[data[0]]:
                distance[data[0]] = cost
                path[data[0]] = now


def find_path(start, end):
    shortest_path = []
    middle = end

    while True:
        if middle == 0:
            break

        shortest_path.append(middle)
        middle = path[middle]

    shortest_path.reverse()

    return shortest_path


dijkstra(start)

print(distance)
print(path)
for i in find_path(1, 6):
    print(i, end=" ")
