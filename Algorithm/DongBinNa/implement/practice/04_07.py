import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().rstrip().split())
maps = [list(map(int, sys.stdin.readline().rstrip().split()))[:n]
        for _ in range(n)]

chicken_store = []
houses = []

for i in range(n):
    for j in range(n):
        if maps[i][j] == 2:
            chicken_store.append([i + 1, j + 1])

        if maps[i][j] == 1:
            houses.append([i + 1, j + 1])

candidates = list(combinations(chicken_store, m))


def get_sum(candidate):
    result = 0

    for x1, y1 in houses:
        temp = 1e9
        # candidate 쪼개기
        for x2, y2 in candidate:
            # [1, 2]
            # [2, 3]
            temp = min(temp, abs(x1 - x2) + abs(y1 - y2))
        result += temp

    return result


result = 1e9

# combination 쪼개기
for candidate in candidates:
    # candidate = ([1, 2], [2, 3]), ([2, 3], [3, 4]) ...
    result = min(result, get_sum(candidate))

print(result)
