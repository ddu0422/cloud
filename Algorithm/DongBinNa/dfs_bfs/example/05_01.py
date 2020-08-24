n, m = map(int, input().split())
map = [list(map(int, input()))[:m] for _ in range(n)]


def dfs(x, y):
    if not (0 <= x < n and 0 <= y < m):
        return False

    if map[x][y] == 0:
        map[x][y] = 1

        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)

        return True

    return False


answer = 0

for i in range(n):
    for j in range(m):
        if dfs(i, j):
            answer += 1

print(answer)
